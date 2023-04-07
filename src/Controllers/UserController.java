package Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import Entities.*;
import Services.UserService;

public class UserController {

  public static ArrayList<UserEntity> getAllUsers() throws ClassNotFoundException, SQLException {
    return UserService.getAllUsers();
  }

  public static UserEntity getUserById(Integer id) {
    return UserService.getUserById(id);
  }

  public static boolean authenticate(String email, String password) {
    // query user by email
    UserEntity userEntity = UserService.getUserByEmail(email);
    // comapre databaseSaved.password === userEnterpassword
    if(userEntity == null){
      return false;
    }
    return userEntity.comparePassword(password);
    
  }
  /*
  public static String firstName(String email) {
    UserEntity userEntity = UserService.getUserByEmail(email);
    return userEntity.getFirstName();
  }

  public static String lastName(String email) {
    UserEntity userEntity = UserService.getUserByEmail(email);
      return userEntity.getLastName();
  }

  public static String Role(String email) {
    UserEntity userEntity = UserService.getUserByEmail(email);
      return userEntity.getRole();
  }
  public static String Pass(String email) {
    UserEntity userEntity = UserService.getUserByEmail(email);
    return userEntity.getPassword();
  }

 */

}
