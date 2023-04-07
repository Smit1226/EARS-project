package Views;

import Entities.UserEntity;

public class UserContext {

  // Private constructor to prevent instantiation from outside the class
  private UserContext() {
  }

  // Private static instance of the class
  private static UserContext instance;

  // Public static method to get the instance of the class
  public static UserContext getInstance() {
    if (instance == null) {
      instance = new UserContext();
    }
    return instance;
  }

  // Fields to persist user context
  private UserEntity currentUser;

  // Methods to manage user context
  public UserEntity getUser() {
    return currentUser;
  }

  public void setUser(UserEntity currentUser) {
    this.currentUser = currentUser;
  }
}