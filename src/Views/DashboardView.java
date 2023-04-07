package Views;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

import Controllers.*;
import Entities.*;

public class DashboardView extends Application {

  private FacultySearchController facultySearchController = new FacultySearchController();

  @Override
  public void start(Stage primaryStage) {
    UserContext userContext = UserContext.getInstance();
    // have a service function call to get user whenever we start this class
    UserEntity latestUser = UserController.getUserById(userContext.getUser().getID());

    UserContext.getInstance().setUser(latestUser);
    // set latest user

    ArrayList<FacultySearchEntity> facultySearchesAssignedToUsers = facultySearchController
        .listUserAllFacultySearch(userContext.getUser().getID());

    // render list of faculty searches

    BorderPane pane = new BorderPane();

    pane.setPadding(new Insets(50, 100, 100, 200));

    VBox vBox = new VBox();
    vBox.setPadding(new Insets(10, 5, 5, 300));

    Label label1 = new Label("Dashboard");
    label1.setFont(Font.font(40));

    Label label2 = new Label("");
    label2.setText("user: " + userContext.getUser().getEmail());
    label2.setFont(Font.font(20));

    vBox.getChildren().addAll(label1, label2);
    pane.setTop(vBox);

    BorderPane.setAlignment(vBox, Pos.CENTER);

    Label label = new Label("");
    label.setText(UserContext.getInstance().getUser().getFirstName() + ","
        + UserContext.getInstance().getUser().getLastName() + " ");

    label.setFont(Font.font(20));
    label.setLayoutX(1050);
    label.setLayoutY(50);

    // action
    label.setOnMouseClicked(e -> {
      new Profile().start(new Stage());
      primaryStage.close();
    });

    Image camera = new Image("https://cdn-icons-png.flaticon.com/512/3566/3566345.png");
    ImageView cameraView = new ImageView(camera);
    cameraView.setFitHeight(30);
    cameraView.setFitWidth(30);
    cameraView.setX(1200);
    cameraView.setY(50);

    Label label3 = new Label("Faculty searches");
    label3.setFont(Font.font(20));
    label3.setLayoutX(175);
    label3.setLayoutY(200);

    Rectangle rect = new Rectangle();
    rect.setWidth(500);
    rect.setHeight(400);
    rect.setArcHeight(20);
    rect.setArcWidth(20);
    rect.setFill(Color.LIGHTGREY);
    rect.setX(375);
    rect.setY(200);
    Group root = new Group(rect);

    // todo: we should loop the facultySearchesAssignedToUsers list,
    // then display a hyperlink for each element in the list loop

    /*
     * 
     * for (int i = 0; i < facultySearchesAssignedToUsers.size(); i++) {
     * FacultySearchEntity facultySearchEntity =
     * facultySearchesAssignedToUsers.get(i);
     * 
     * 
     * Hyperlink link = new Hyperlink(facultySearchEntity.getTitle());
     * 
     * 
     * 
     * link.setTextFill(Color.web("0574B2"));
     * link.setLayoutX(400);
     * link.setLayoutY(225 + i * 50);
     * root.getChildren().add(link);
     * 
     * 
     * link.setOnAction(e -> {
     * try {
     * new ViewFacultySearchView().start(new Stage());
     * } catch (Exception e1) {
     * // TODO Auto-generated catch block
     * e1.printStackTrace();
     * }
     * });
     * 
     * }
     * 
     * 
     */

    ListView<FacultySearchEntity> facultySearchesListView = new ListView<>();
    ObservableList<FacultySearchEntity> items = FXCollections.observableArrayList(facultySearchesAssignedToUsers);

    facultySearchesListView.setItems(items);

    facultySearchesListView.setCellFactory(param -> {
      ListCell<FacultySearchEntity> cell = new ListCell<FacultySearchEntity>() {
        protected void updateItem(FacultySearchEntity item, boolean empty) {
          super.updateItem(item, empty);
          setText(empty ? null : item.gettitle());
        }
      };

      cell.setOnMouseClicked(event -> {
        if (!cell.isEmpty()) {
          // Handle the click event
          FacultySearchEntity selectedFacultySearch = cell.getItem();
          primaryStage.close();
          try {
            // Set the root of the current scene to the new view
            new ViewFacultySearchView(selectedFacultySearch).start(new Stage());
            // System.out.println("page changed");
          } catch (Exception e1) {
            e1.printStackTrace();
          }
        }
      });

      cell.setOnMouseEntered(e -> {
        cell.setCursor(Cursor.HAND);
      });
      cell.setOnMouseExited(e -> {
        cell.setCursor(Cursor.DEFAULT);
      });

      return cell;
    });

    facultySearchesListView.setPrefHeight(400);
    facultySearchesListView.setPrefWidth(800);
    facultySearchesListView.setLayoutX(300);
    facultySearchesListView.setLayoutY(200);
    facultySearchesListView
        .setStyle("-fx-control-inner-background: #a9a9a9;-fx-font-size: 24px; -fx-font-family: 'SketchFlow Print';");

    root.getChildren().addAll(cameraView, label, label3, pane, facultySearchesListView);

    Scene scene = new Scene(root, 1280, 720);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Profile");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
