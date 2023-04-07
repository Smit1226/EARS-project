package Views;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

import Controllers.*;
import Entities.*;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/** @todo: make sure to re-write this */
public class AdminUserDashBoardView extends Application {
  Label adminlabel;
  Button userBtn;
  Line line1;
  Label managerLabel;
  Button addUserBtn;
  Line line2;
  Button viewUsersBtn;
  Button facultySearchBtn;
  Line line3;
  Label userlistLabel;
  TextField searchField;
  Line line4;
  TableView table;
  FilteredList<UserEntity> FilteredData;
  SortedList<UserEntity> sortedData;
  private ObservableList<UserEntity> dataList = FXCollections.observableArrayList();

  // This class is the main entry point
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage ps) throws ClassNotFoundException, SQLException {
    Pane root = new Pane();
    Scene scene = new Scene(root, 1280, 720, Color.WHITE);
    Stage stage = new Stage();

    adminlabel = new Label("Admin");
    adminlabel.setFont(Font.font(null, FontWeight.BOLD, 36));
    adminlabel.setLayoutX(50);
    adminlabel.setLayoutY(10);

    userBtn = new Button(LoginView.userEntity.getFirstName()+", "+LoginView.userEntity.getLastName());
    userBtn.setFont(Font.font(20));

    userBtn.setStyle(
        "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");
    userBtn.setStyle(
        "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");
    userBtn.setOnMouseEntered(e -> {
      userBtn.setCursor(Cursor.HAND);
      userBtn.setStyle(
          "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;");
    });

    userBtn.setOnMouseExited(e -> {
      userBtn.setCursor(Cursor.DEFAULT);
      userBtn.setStyle(
          "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");
    });
    userBtn.setOnMouseClicked(e -> {
      new Profile().start(new Stage());
    });


    userBtn.setLayoutX(1022);
    userBtn.setLayoutY(10);

    line1 = new Line();
    line1.setStartX(0);
    line1.setStartY(55);
    line1.setEndX(1280);
    line1.setEndY(55);
    line1.setStroke(Color.BLACK);

    managerLabel = new Label("Manager");
    managerLabel.setFont(Font.font(null, FontWeight.BOLD, 36));
    managerLabel.setTextFill(javafx.scene.paint.Color.GREY);
    managerLabel.setLayoutX(168);
    managerLabel.setLayoutY(50);

    addUserBtn = new Button("Add User");
    addUserBtn.setStyle("-fx-background-color: #0147AB; -fx-text-fill: white;");


    addUserBtn.setOnMouseEntered(e -> {
      addUserBtn.setCursor(Cursor.HAND);}
    );

    addUserBtn.setOnMouseExited(e -> {
      addUserBtn.setCursor(Cursor.DEFAULT);}
   );
    addUserBtn.setOnMouseClicked(e -> {
      stage.close();
      try {
        new AddUserView().start(new Stage());
      } catch (ClassNotFoundException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });

    addUserBtn.setPrefWidth(150);
    addUserBtn.setLayoutX(933);
    addUserBtn.setLayoutY(62);

    line2 = new Line();
    line2.setStartX(0);
    line2.setStartY(191);
    line2.setEndX(0);
    line2.setEndY(1280);
    line2.setStrokeWidth(270);
    line2.setStroke(Color.rgb(169, 169, 169));

    viewUsersBtn = new Button("Users");
    viewUsersBtn.setFont(Font.font(null, FontWeight.BOLD, 20));
    viewUsersBtn.setStyle(
        "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;");
    /*
     * viewUsersBtn.setOnMouseEntered(e -> {
     * viewUsersBtn.
     * setStyle("-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;"
     * );
     * });
     * 
     * viewUsersBtn.setOnMouseExited(e -> {
     * viewUsersBtn.
     * setStyle("-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;"
     * );
     * });
     * viewUsersBtn.setOnAction(e -> {
     * viewUsersBtn.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;"
     * );
     * });
     */
    viewUsersBtn.setOnMouseEntered(e -> {
      viewUsersBtn.setCursor(Cursor.HAND);
    });

    viewUsersBtn.setOnMouseExited(e -> {
      viewUsersBtn.setCursor(Cursor.DEFAULT);
    });

    viewUsersBtn.setOnAction((ActionEvent e) -> {
      stage.close();
      try {
        new AdminUserDashBoardView().start(new Stage());
        System.out.println("page changed");
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    });

    viewUsersBtn.setLayoutX(30);
    viewUsersBtn.setLayoutY(150);

    facultySearchBtn = new Button("Faculty search");
    facultySearchBtn.setFont(Font.font(null, FontWeight.BOLD, 20));
    facultySearchBtn.setStyle(
        "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");
    facultySearchBtn.setOnMouseEntered(e -> {
      facultySearchBtn.setCursor(Cursor.HAND);
      facultySearchBtn.setStyle(
          "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;");
    });

    facultySearchBtn.setOnMouseExited(e -> {
      facultySearchBtn.setCursor(Cursor.DEFAULT);
      facultySearchBtn.setStyle(
          "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");
    });
    facultySearchBtn.setOnAction(e -> {
      facultySearchBtn.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;");
    });
    facultySearchBtn.setOnAction((ActionEvent e) -> {
      stage.close();
      try {
        new AdminDashBoardView().start(new Stage());
        System.out.println("page changed");
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    });

    facultySearchBtn.setLayoutX(-13);
    facultySearchBtn.setLayoutY(260);

    line3 = new Line();
    line3.setStartX(0);
    line3.setStartY(105);
    line3.setEndX(1150);
    line3.setEndY(105);
    line3.setStroke(Color.rgb(169, 169, 169));

    userlistLabel = new Label("User List");
    userlistLabel.setFont(Font.font(24));
    userlistLabel.setLayoutX(175);
    userlistLabel.setLayoutY(105);

    searchField = new TextField();
    searchField.setPromptText("Search");

    searchField.setLayoutX(933);
    searchField.setLayoutY(110);

    line4 = new Line();
    line4.setStartX(0);
    line4.setStartY(140);
    line4.setEndX(1150);
    line4.setEndY(140);
    line4.setStroke(Color.rgb(169, 169, 169));

    table = new TableView<UserEntity>();
    table.setEditable(true);

    TableColumn<UserEntity, String> nameColumn = new TableColumn<UserEntity, String>("Name");
    TableColumn<UserEntity, String> firstNameColumn = new TableColumn<UserEntity, String>("First Name");
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<UserEntity, String>("firstName"));
    firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<UserEntity, String> lastNameColumn = new TableColumn<UserEntity, String>("Last Name");
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<UserEntity, String>("lastName"));
    lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<UserEntity, String> emailColumn = new TableColumn<UserEntity, String>("Email");
    emailColumn.setCellValueFactory(new PropertyValueFactory<UserEntity, String>("email"));
    emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    TableColumn<UserEntity, String> blankColumn = new TableColumn<UserEntity, String>("");

    TableColumn<UserEntity, String> roleColumn = new TableColumn<UserEntity, String>("Role");
    roleColumn.setCellValueFactory(new PropertyValueFactory<UserEntity, String>("role"));
    roleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    nameColumn.getColumns().addAll(firstNameColumn, lastNameColumn);

    // table.getColumns().add(firstNameColumn);
    // table.getColumns().add(lastNameColumn);

    table.getColumns().addAll(nameColumn, emailColumn, roleColumn, blankColumn);
    table.prefHeightProperty().bind(stage.heightProperty());
    table.prefWidthProperty().bind(stage.widthProperty());

    dataList = FXCollections.observableList(UserController.getAllUsers());

    // table.getItems().add(new UserEntity("Zhengbin","Xue","1", "1"));
    // table.getItems().add(new UserEntity("Stelle","Sun","2", "2"));
    // table.getItems().add(new UserEntity("Alan","Lan","3", "3"));
    // table.getItems().add(new UserEntity("Coco","Xiao","4", "4"));
    // table.getItems().add(new UserEntity("Tander","Ye","5", "5"));

    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    firstNameColumn.setOnEditCommit(event -> {
      String newFirstName = event.getNewValue();
      int rowIndex = event.getTablePosition().getRow();
      UserEntity user = (UserEntity) table.getItems().get(rowIndex);
      user.setFirstName(newFirstName);
      AdminUserDashBoardController.updateUserData(user);
    });

    lastNameColumn.setOnEditCommit(event -> {
      String newLastName = event.getNewValue();
      int rowIndex = event.getTablePosition().getRow();
      UserEntity user = (UserEntity) table.getItems().get(rowIndex);
      user.setLastName(newLastName);
      AdminUserDashBoardController.updateUserData(user);
    });

    table.setLayoutX(135);
    table.setLayoutY(140);
    FilteredData = new FilteredList<>(dataList, b -> true);
    searchField.textProperty().addListener((Observable, oldValue, newValue) -> {
      FilteredData.setPredicate(user -> {
        if (newValue == null || newValue.isEmpty()) {
          return true;
        }
        String lowerCaseFilter = newValue.toLowerCase();

        if (user.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
          return true;
        } else if (user.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
          return true;
        } else if (user.getRole().toLowerCase().indexOf(lowerCaseFilter) != -1) {// String.valueOf(employee.getID())
          return true;
        } else {
          return false;
        }
      });
    });
    sortedData = new SortedList<>(FilteredData);
    sortedData.comparatorProperty().bind(table.comparatorProperty());
    table.setItems(sortedData);

    root.getChildren().add(adminlabel);
    root.getChildren().add(userBtn);
    root.getChildren().add(line1);
    root.getChildren().add(managerLabel);
    root.getChildren().add(addUserBtn);
    root.getChildren().add(line2);
    root.getChildren().add(viewUsersBtn);
    root.getChildren().add(line3);
    root.getChildren().add(facultySearchBtn);
    root.getChildren().add(userlistLabel);
    root.getChildren().add(searchField);
    root.getChildren().add(line4);
    root.getChildren().add(table);

    stage.setScene(scene);
    stage.setTitle("Employment Application Review System");
    stage.show();
    stage.requestFocus();

  }
}