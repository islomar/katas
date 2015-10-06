package org.craftedsw.tripservicekata.trip;


import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.testng.annotations.Test;

@Test
public class TripServiceTest {

  @Test(expectedExceptions = UserNotLoggedInException.class)
  public void throw_UserNotLoggedInException_if_no_user_is_logged() {

    TripService tripService = new TesteableTripService();
    User noLoggedUser = null;

    tripService.getTripsByUser(noLoggedUser);
  }

  private class TesteableTripService extends TripService {

    @Override
    protected User getLoggedUser() {
      return null;
    }
  }

}
