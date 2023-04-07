package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAL.Database;
import Entities.*;

public class UserService {
  /**
   * Mapper function to convert the user db data to our user entity class
   */
  public static UserEntity toEntity(ResultSet resultSet) {
    UserEntity userEntity = new UserEntity();
    try {
      userEntity.setId(resultSet.getInt("id"));
      userEntity.setEmail(resultSet.getString("email"));
      userEntity.setPassword(resultSet.getString("password"));
      userEntity.setFirstName(resultSet.getString("firstName"));
      userEntity.setLastName(resultSet.getString("lastName"));
      userEntity.setRole(resultSet.getString("role"));
    } catch (SQLException sqlException) {
      // @todo: handle if a col is not selected from the query
    }
    return userEntity;
  }

  public static UserEntity getUserById(Integer id) {
    UserEntity userEntity = null;
    try {
      ResultSet resultSet = Database.getConnection().prepareStatement("SELECT * FROM users WHERE id=" + id)
          .executeQuery();

      // in programming, iterator => mem pointer

      if (resultSet.next()) {
        // transform the result set to our user data in Java
        // user object: id, email, firstName, lastName
        // abstract the tranforming logic into a furncito
        userEntity = UserService.toEntity(resultSet);
      } else {
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return userEntity;
  }

  public static UserEntity getUserByEmail(String email) {
    UserEntity userEntity = null;
    try {
      Connection connection = Database.getConnection();
      ResultSet resultSet = connection
          .prepareStatement(
              "SELECT * FROM users WHERE email ='" + email + "'")
          .executeQuery();

      if (resultSet.next()) {
        // convert the user db result set to our user entity pass
        userEntity = UserService.toEntity(resultSet);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userEntity;

  }

  public static UserEntity setUserByEmail(String email, String firstname, String lastname, String pass, String role) {
    UserEntity userEntity = null;
    try {
      Connection connection = Database.getConnection();

      String query = "UPDATE users SET password=?, role=?, firstName=?, lastName=? WHERE email=?";
      PreparedStatement statement = connection.prepareStatement(query);
      statement.setString(1, pass);
      statement.setString(2, role);
      statement.setString(3, firstname);
      statement.setString(4, lastname);
      statement.setString(5, email);
      statement.executeUpdate();

      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return userEntity;

  }

  public static ArrayList<UserEntity> getAllUsers() throws SQLException, ClassNotFoundException {
    String query = "SELECT * FROM users";
    Connection connection = Database.getConnection();
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    ArrayList<UserEntity> userList = new ArrayList<UserEntity>();
    while (rs.next()) {
      int id = rs.getInt("id");
      String firstName = rs.getString("firstName");
      String lastName = rs.getString("lastName");
      String email = rs.getString("email");
      String role = rs.getString("role");

      userList.add(new UserEntity(id, firstName, lastName, email, role));

    }
    connection.close();
    return userList;
  }

}