package Controllers;

import java.util.ArrayList;

import Entities.*;
import Services.*;;

public class DashboardController {

    
  public static UserEntity getUserById(Integer id) {
    return UserService.getUserById(id);
  }

  public static UserEntity getUserByEmail(String email) {
    return UserService.getUserByEmail(email);
  }
    
}
