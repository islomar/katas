package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.craftedsw.tripservicekata.user.UserSession;

public class TripService {

  private final TripDAO tripDAO;

  public TripService(TripDAO tripDAO) {

    this.tripDAO = tripDAO;
  }

  public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
    List<Trip> tripList = new ArrayList<Trip>();
    User loggedUser = getLoggedUser();

    throwExceptionIfNoLoggedUser(loggedUser);

    if (user.isFriend(loggedUser)) {
      tripList = findTripsByUser(user);
    }
    return tripList;
  }

  public void throwExceptionIfNoLoggedUser(User loggedUser) {
    if (loggedUser == null) {
      throw new UserNotLoggedInException();
    }
  }

  protected List<Trip> findTripsByUser(User user) {
    return tripDAO.findTripsByUser(user);
  }

  protected User getLoggedUser() {
    return UserSession.getInstance().getLoggedUser();
  }

}
