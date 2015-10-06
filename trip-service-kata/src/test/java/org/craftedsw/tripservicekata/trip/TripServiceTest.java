package org.craftedsw.tripservicekata.trip;


import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@Test
public class TripServiceTest {

  @Mock private User searchedUser;
  @Mock private User loggedUser;
  @Mock private TripDAO tripDAO;
  @Mock private Trip trip;

  @BeforeMethod
  public void setUpMethod() {
    initMocks(this);
  }

  @Test(expectedExceptions = UserNotLoggedInException.class)
  public void throw_UserNotLoggedInException_if_no_user_is_logged() {

    User noLoggedUser = null;
    TripService tripService = new TesteableTripService(noLoggedUser, tripDAO);

    tripService.getTripsByUser(searchedUser);
  }


  public void find_no_trips_if_loggedUser_and_searched_user_are_not_friends() {

    TripService tripService = new TesteableTripService(loggedUser, tripDAO);
    given(searchedUser.getFriends()).willReturn(new ArrayList<User>());

    List<Trip> tripsByUser = tripService.getTripsByUser(searchedUser);

    assertThat(tripsByUser, is(empty()));
  }


  public void find_trips_if_loggedUser_and_searched_user_are_friends() {

    given(tripDAO.findTripsByUser(searchedUser)).willReturn(Arrays.asList(trip));
    TripService tripService = new TesteableTripService(loggedUser, tripDAO);
    given(searchedUser.isFriend(loggedUser)).willReturn(true);

    List<Trip> tripsByUser = tripService.getTripsByUser(searchedUser);

    assertThat(tripsByUser, is(Arrays.asList(trip)));
    verify(tripDAO, times(1)).findTripsByUser(searchedUser);
  }


  private class TesteableTripService extends TripService {

    private final Optional<User> loggedUser;

    public TesteableTripService(User loggedUser, TripDAO tripDAO) {

      super(tripDAO);
      this.loggedUser = Optional.ofNullable(loggedUser);
    }

    @Override
    protected Optional<User> getLoggedUser() {
      return this.loggedUser;
    }
  }

}
