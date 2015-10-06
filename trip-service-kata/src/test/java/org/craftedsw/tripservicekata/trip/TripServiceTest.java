package org.craftedsw.tripservicekata.trip;


import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@Test
public class TripServiceTest {

  @Mock private User user;

  @BeforeMethod
  public void setUpMethod() {
    initMocks(this);
  }

  @Test(expectedExceptions = UserNotLoggedInException.class)
  public void throw_UserNotLoggedInException_if_no_user_is_logged() {

    User noLoggedUser = null;
    TripService tripService = new TesteableTripService(noLoggedUser);

    tripService.getTripsByUser(noLoggedUser);
  }

  public void find_no_trips_if_loggedUser_and_searched_user_are_not_friends() {

    TripService tripService = new TesteableTripService(user);
    given(user.getFriends()).willReturn(new ArrayList<User>());

    List<Trip> tripsByUser = tripService.getTripsByUser(user);
    assertThat(tripsByUser, is(empty()));
  }

  private class TesteableTripService extends TripService {

    private final User loggedUser;

    public TesteableTripService(User loggedUser) {

      this.loggedUser = loggedUser;
    }

    @Override
    protected User getLoggedUser() {
      return this.loggedUser;
    }
  }

}
