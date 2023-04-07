package Views;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;

import java.sql.Timestamp;
import java.util.ArrayList;

import Controllers.ApplicationController;
import Controllers.ListApplicationController;
import Entities.ApplicationEntity;
import Entities.FacultySearchEntity;
import Entities.ListApplicationEntity;
import Services.ApplicationService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ViewFacultySearchView extends Application {
  private ListApplicationController listApplicationController = new ListApplicationController();
  private FacultySearchEntity facultySearch = new FacultySearchEntity();
  private static Integer clickedApplicationId;

  public static Integer getClickedApplicationId() {
    return clickedApplicationId;
  }

  public ViewFacultySearchView() {

  }

  public ViewFacultySearchView(FacultySearchEntity facultySearch) {
    this.facultySearch = facultySearch;
  }

  public void openApplication() throws Exception {
    try {
      // Set the root of the current scene to the new view
      new ApplicationProcessView().start(new Stage());
      System.out.println("page changed");
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  @Override
  public void start(Stage arg0) throws Exception {
    Pane root = new Pane();
    Scene scene = new Scene(root, 1280, 720, Color.WHITE);
    Stage stage = new Stage();

    Label facultySearchLabel = new Label("Faculty Search: Software Engineering Instructor");
    facultySearchLabel.setFont(Font.font(null, FontWeight.BOLD, 26));
    facultySearchLabel.setLayoutX(20);
    facultySearchLabel.setLayoutY(20);

    Button dashboardBtn = new Button("Dashboard");
    dashboardBtn.setStyle("-fx-background-color: #0147AB; -fx-text-fill: white;");
    dashboardBtn.setPrefWidth(150);
    dashboardBtn.setPrefHeight(35);
    dashboardBtn.setLayoutX(1000);
    dashboardBtn.setLayoutY(70);
    dashboardBtn.setOnAction((ActionEvent e) -> {
      stage.close();
      try {
        if (UserContext.getInstance().getUser().isAdmin()) {
          new AdminDashBoardView().start(new Stage());
        } else {
          new DashboardView().start(new Stage());
          ;
        }
        System.out.println("page changed");
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    });

    // Create table view
    TableView<ListApplicationEntity> table = new TableView<ListApplicationEntity>();
    table.setEditable(false);

    // table columns
    TableColumn<ListApplicationEntity, String> applicantNameColumn = new TableColumn<ListApplicationEntity, String>(
        "Applicant Name");
    TableColumn<ListApplicationEntity, Timestamp> submitDateColumn = new TableColumn<ListApplicationEntity, Timestamp>(
        "Submit Date");
    TableColumn<ListApplicationEntity, String> statusColumn = new TableColumn<ListApplicationEntity, String>("Status");
    // Get values
    applicantNameColumn.setCellValueFactory(new PropertyValueFactory<>("applicantName"));
    submitDateColumn.setCellValueFactory(new PropertyValueFactory<>("submitDate"));
    statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    // Insert values
    ObservableList<ListApplicationEntity> apps = FXCollections
        .observableArrayList(listApplicationController.listFacultySearchApplications(facultySearch.getId()));
    // ObservableList<ListApplicationEntity> apps =
    // listApplicationController.listFacultySearchApplications(facultySearch.getId());
    table.setItems(apps);

    table.getColumns().addAll(applicantNameColumn, submitDateColumn, statusColumn);
    table.setPrefSize(600, 370);
    table.setLayoutX(350);
    table.setLayoutY(160);

    // create table row with a for loop
    // how to to pass id date from a vew to another
    System.out.println(facultySearch.getId());
    // ObservableList<ApplicationEntity> applications = applicationController
    // .listFacultySearchApplications(1);

    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    // Get clicked table row information
    table.setRowFactory(e -> {
      TableRow<ListApplicationEntity> row = new TableRow<>();
      row.setOnMouseClicked(event -> {
        if ((event.getClickCount() == 2) && (!row.isEmpty())) {
          ListApplicationEntity clickData = row.getItem();
          clickedApplicationId = clickData.getId();
          System.out.println("Application Id: " + clickedApplicationId + " is clicked!");
          // stage.close();
          try {
            openApplication();
          } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }
      });
      return row;
    });

    root.getChildren().add(facultySearchLabel);
    root.getChildren().add(dashboardBtn);
    root.getChildren().add(table);

    stage.setScene(scene);
    stage.setTitle("Employment Application Review System");
    stage.show();
    // stage.requestFocus();

  }

}