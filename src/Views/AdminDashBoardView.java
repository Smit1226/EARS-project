package Views;

import Views.*;
import Entities.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

import Controllers.*;

public class AdminDashBoardView extends Application {
  TextArea textArea;
  final ObservableList<FacultySearchEntity> listFacultySearch = FXCollections.observableArrayList();
  private FacultySearchController facultySearchController = new FacultySearchController();

  @Override
  public void start(Stage ps) throws Exception {
    Pane root = new Pane();
    Scene scene = new Scene(root, 1280, 720, Color.WHITE);
    Stage stage = new Stage();

    Line line = new Line();
    line.setStartX(0);
    line.setStartY(0);
    line.setEndX(0);
    line.setEndY(1280);
    line.setStrokeWidth(270);
    line.setStroke(Color.rgb(169, 169, 169));

    Button viewUsersBtn = new Button("Users");
    viewUsersBtn.setFont(Font.font(null, FontWeight.BOLD, 20));

    viewUsersBtn.setStyle(
        "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");
    viewUsersBtn.setOnMouseEntered(e -> {
      viewUsersBtn.setCursor(Cursor.HAND);
      viewUsersBtn.setStyle(
          "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;");
    });

    viewUsersBtn.setOnMouseExited(e -> {
      viewUsersBtn.setCursor(Cursor.DEFAULT);
      viewUsersBtn.setStyle(
          "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: black; -fx-border-color: transparent;");
    });
    viewUsersBtn.setOnAction(e -> {
      viewUsersBtn.setStyle("-fx-background-color: #FF6347; -fx-text-fill: white;");
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

    Button facultySearchBtn = new Button("Faculty search");
    facultySearchBtn.setFont(Font.font(null, FontWeight.BOLD, 20));
    facultySearchBtn.setStyle(
        "-fx-background-color: null; -fx-background-insets: 0; -fx-text-fill: blue; -fx-border-color: transparent;");
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

    Button newSearchBtn = new Button("New search");
    newSearchBtn.setStyle("-fx-background-color: #0147AB; -fx-text-fill: white;");
    newSearchBtn.setPrefWidth(150);
    newSearchBtn.setPrefHeight(35);
    newSearchBtn.setLayoutX(950);
    newSearchBtn.setLayoutY(70);
    newSearchBtn.setOnAction((ActionEvent event) -> {
      stage.close();
      try {
        new CreateFacultySearchView().start(new Stage());
        System.out.println("new faculty view.");
      } catch (Exception e1) {
        e1.printStackTrace();
      }

    });

    ListView<FacultySearchEntity> facultySearchesListView = new ListView<>();
    ArrayList<FacultySearchEntity> facultySearches = facultySearchController.listAllFacultySearches();
    ObservableList<FacultySearchEntity> items = FXCollections.observableArrayList(facultySearches);

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
          System.out.println("Clicked " + selectedFacultySearch.gettitle());
          stage.close();
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

    root.getChildren().add(line);
    root.getChildren().add(viewUsersBtn);
    root.getChildren().add(facultySearchBtn);
    root.getChildren().add(newSearchBtn);
    root.getChildren().add(facultySearchesListView);

    stage.setScene(scene);
    stage.setTitle("Employment Application Review System");
    stage.show();
    stage.requestFocus();
  }

}
