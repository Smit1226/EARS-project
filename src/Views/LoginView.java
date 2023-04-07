package Views;

import java.sql.SQLException;

import Controllers.UserController;
import Entities.UserEntity;
import Services.UserService;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginView extends Application {

  // *****************************************
  // Do not delete, it's for comment record
  private static String loginEmail;

  public static String getLoginEmail() {
    return loginEmail;
  }
  // *****************************************

  public static UserEntity userEntity;

  @Override
  public void start(Stage primaryStage) {
    // enter pasword, email
    // sent to the controller
    // we verify the password, email
    // if good then we allow them to enter the dash
    // if not return error
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(20, 20, 20, 20));
    pane.setVgap(50);
    pane.setHgap(50);

    Label label = new Label("Login- EARS");
    label.setFont(Font.font(null, FontWeight.BOLD, 60));
    label.setTextFill(Color.web("0574B2"));
    pane.add(label, 0, 0, 2, 1);
    GridPane.setHalignment(label, HPos.CENTER);

    Label label1 = new Label("User ID");
    label1.setFont(Font.font(null, FontWeight.BOLD, 30));
    pane.add(label1, 0, 2);
    TextField userNameField = new TextField();
    pane.add(userNameField, 1, 2);

    Label label2 = new Label("Password");
    label2.setFont(Font.font(null, FontWeight.BOLD, 30));
    pane.add(label2, 0, 3);
    PasswordField passwordField = new PasswordField();
    pane.add(passwordField, 1, 3);

    Button login = new Button("Login");
    login.setStyle("-fx-background-color: #0574B2");
    login.setTextFill(Color.WHITE);

    Button cancel = new Button("Cancel");
    cancel.setStyle("-fx-background-color: #B6BBBE");
    cancel.setTextFill(Color.WHITE);

    pane.add(login, 1, 4);
    pane.add(cancel, 1, 4);
    GridPane.setHalignment(login, HPos.LEFT);
    GridPane.setHalignment(cancel, HPos.CENTER);

    Label label3 = new Label("Don’t have an account? Contact IT Department.");
    label3.setFont(Font.font(20));
    label3.setTextFill(Color.web("0574B2"));
    pane.add(label3, 0, 6, 2, 1);
    GridPane.setHalignment(label3, HPos.CENTER);

    Label label5 = new Label("Algoma University");
    label5.setFont(Font.font(20));
    label5.setTextFill(Color.BLACK);
    pane.add(label5, 0, 8, 2, 1);
    GridPane.setHalignment(label5, HPos.CENTER);

    // event when user click login
    login.setOnAction(e -> {
      String email = userNameField.getText();
      String password = passwordField.getText();
      // *****************************************
      // Do not delete, it's for comment record
      loginEmail = email;
      // *****************************************
      // sent to the user controller

      Boolean isAuthenticated = UserController.authenticate(email, password);
      if (isAuthenticated == true) {

        userEntity = UserService.getUserByEmail(email);
        UserContext userContext = UserContext.getInstance();
        userContext.setUser(userEntity);

        if (userEntity.getRole().equalsIgnoreCase("regular")) {
          new DashboardView().start(new Stage());
        }

        if (userEntity.isAdmin()) {
          try {

            new AdminUserDashBoardView().start(new Stage());
          } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
        primaryStage.close();
      }

      if (isAuthenticated == false) {
        Stage commentStage = new Stage();
        StackPane pane10 = new StackPane();
        pane10.setPadding(new Insets(15, 25, 15, 25));

        Label label10 = new Label("username/password incorrect");
        label10.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        pane10.getChildren().add(label10);
        StackPane.setAlignment(label10,Pos.CENTER);
        
        
        Scene secondScene = new Scene(pane10,300,300);
        commentStage.setScene(secondScene);
        commentStage.show();



        System.out.println("username/password incorrect");
      }
    });

    cancel.setOnAction(e -> {
      new LoginView().start(new Stage());
    });

    Scene scene = new Scene(pane, 1280, 720);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Employment Application Review System");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}