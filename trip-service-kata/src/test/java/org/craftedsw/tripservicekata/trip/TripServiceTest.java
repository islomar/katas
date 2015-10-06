package org.craftedsw.tripservicekata.trip;


import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@Test
public class TripServiceTest {

  @Mock private User searchedUser;
  @Mock private User loggedUser;

  @BeforeMethod
  public void setUpMethod() {
    initMocks(this);
  }

  @Test(expectedExceptions = UserNotLoggedInException.class)
  public void throw_UserNotLoggedInException_if_no_user_is_logged() {

    User noLoggedUser = null;
    TripService tripService = new TesteableTripService(noLoggedUser, null);

    tripService.getTripsByUser(noLoggedUser);
  }

  public void find_no_trips_if_loggedUser_and_searched_user_are_not_friends() {

    TripService tripService = new TesteableTripService(loggedUser, null);
    given(searchedUser.getFriends()).willReturn(new ArrayList<User>());

    List<Trip> tripsByUser = tripService.getTripsByUser(searchedUser);

    assertThat(tripsByUser, is(empty()));
  }

  public void find_trips_if_loggedUser_and_searched_user_are_friends() {

    Trip trip = new Trip();
    TripService tripService = new TesteableTripService(loggedUser, Arrays.asList(trip));
    given(searchedUser.getFriends()).willReturn(Arrays.asList(loggedUser));

    List<Trip> tripsByUser = tripService.getTripsByUser(searchedUser);

    assertThat(tripsByUser, is(Arrays.asList(trip)));
  }

  private class TesteableTripService extends TripService {

    private final User loggedUser;
    private final List<Trip> tripList;

    public TesteableTripService(User loggedUser, List<Trip> tripList) {

      super(new TripDAO());
      this.loggedUser = loggedUser;
      this.tripList = tripList;
    }

    @Override
    protected User getLoggedUser() {
      return this.loggedUser;
    }

    @Override
    protected List<Trip> findTripsByUser(User user) {
      return this.tripList;
    }
  }

}
