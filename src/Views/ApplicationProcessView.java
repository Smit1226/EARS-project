package Views;

import Entities.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafx.scene.text.Font.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controllers.*;
import DAL.Database;

public class ApplicationProcessView extends Application {
    ApplicationController applicationController = new ApplicationController();
    protected Integer id = ViewFacultySearchView.getClickedApplicationId();
    protected String loginEmail = LoginView.getLoginEmail();

    UserEntity user = new UserEntity();
    private Integer usrId = getUsrId(loginEmail);

    protected TextField fNameTextField = new TextField();
    protected TextField lNameTextField = new TextField();
    protected TextField phoneTextField = new TextField();
    protected TextField emailTextField = new TextField();
    protected TextField addressTextField = new TextField();
    protected TextField cityTextField = new TextField();
    protected TextField provinceTextField = new TextField();
    protected TextField applicationIDTextField = new TextField();
    protected TextField positionTextField = new TextField();
    protected TextField departmentTextField = new TextField();
    protected TextField statusTextField = new TextField();
    protected TextArea experience1TextArea = new TextArea();
    protected TextArea experience2TextArea = new TextArea();
    protected TextArea education1TextArea = new TextArea();
    protected TextArea education2TextArea = new TextArea();

    protected TextArea commentTextArea = new TextArea();
    protected Button btnComment = new Button("Comment");
    protected Button btnAccept = new Button("Accept");
    protected Button btnIgnore = new Button("Ignore");
    protected Button btnReject = new Button("Reject");
    protected Button btnUpdateComment = new Button("Update");
    protected Button btnDeleteComment = new Button("Delete");
    protected Button btnIgnoreComment = new Button("Ignore");


    @Override
    public void start(Stage stage) throws Exception {

        // render an application

        // render button for accept/reject
        //
        System.out.println("appid: " + id + ", userid: "+ usrId);
        // Create a border Pane
        BorderPane borderPane = new BorderPane();
        // Set padding value for borderPane
        borderPane.setPadding(new Insets(15));

        // Create single row panel
        HBox hbox = addHbox();
        borderPane.setTop(hbox);

        borderPane.setLeft(addVBox());
        borderPane.setCenter(addSomething());

        // Set size and title for the window
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.setResizable(false);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("Application Process");
        stage.show();
        // Close the app when the stage is closed
        stage.setOnCloseRequest(e -> {
            //System.exit(0);
            stage.hide();
        });

        btnIgnore.setOnAction(e -> {
            //System.exit(0);
            stage.hide();
        });
        // Fill data into TextFields
        loadData();

    } // End of start method

    private HBox addHbox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(20); // Gap between nodes
        // hbox.setStyle("-fx-background-color: #008080;");

        // Add header, player id text field, three buttons
        Text header = new Text("Application Process - EARS");
        header.setFont(font("Arial", FontWeight.BOLD, 15));
        // Set center
        hbox.setAlignment(Pos.CENTER);

        hbox.getChildren().addAll(header);
        return hbox;
    } // End of addHbox method

    private VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(25)); // Set all sides to 25
        vbox.setSpacing(25); // Gap between nodes

        // Add single row pane inside the VBox pane
        HBox hBox1 = new HBox();
        // Add GridPane to UI
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(30);
        grid1.setVgap(30);
        grid1.setPadding(new Insets(15, 15, 15, 15));// Margins around grid(top,right,bottom,left)

        // Set First Name label and textField on gridPane
        Label fNameLabel = new Label("First Name: ");
        GridPane.setHalignment(fNameLabel, HPos.LEFT);
        grid1.add(fNameLabel, 0, 0);
        GridPane.setHalignment(fNameTextField, HPos.RIGHT);
        // Set non-editable textField
        fNameTextField.setEditable(false);
        fNameTextField.setMouseTransparent(true);
        fNameTextField.setFocusTraversable(false);
        grid1.add(fNameTextField, 1, 0);

        // Set Last Name label and textField on gridPane
        Label lNameLabel = new Label("Last Name: ");
        GridPane.setHalignment(lNameLabel, HPos.LEFT);
        grid1.add(lNameLabel, 2, 0);
        GridPane.setHalignment(lNameTextField, HPos.RIGHT);
        // Set non-editable textField
        lNameTextField.setEditable(false);
        lNameTextField.setMouseTransparent(true);
        lNameTextField.setFocusTraversable(false);
        grid1.add(lNameTextField, 3, 0);

        // Set Phone label and textField on gridPane
        Label phoneLabel = new Label("Phone: ");
        GridPane.setHalignment(phoneLabel, HPos.LEFT);
        grid1.add(phoneLabel, 4, 0);
        GridPane.setHalignment(phoneTextField, HPos.RIGHT);
        // Set non-editable textField
        phoneTextField.setEditable(false);
        phoneTextField.setMouseTransparent(true);
        phoneTextField.setFocusTraversable(false);
        grid1.add(phoneTextField, 5, 0);

        // Set email label and textField on gridPane
        Label emailLabel = new Label("Email: ");
        GridPane.setHalignment(emailLabel, HPos.LEFT);
        grid1.add(emailLabel, 6, 0);
        GridPane.setHalignment(emailTextField, HPos.RIGHT);
        // Set non-editable textField
        emailTextField.setEditable(false);
        emailTextField.setMouseTransparent(true);
        emailTextField.setFocusTraversable(false);
        grid1.add(emailTextField, 7, 0);

        // Set address label and textField on gridPane
        Label addressLabel = new Label("Address: ");
        GridPane.setHalignment(addressLabel, HPos.LEFT);
        grid1.add(addressLabel, 0, 1);
        // addressTextField.setPrefColumnCount(5);
        GridPane.setHalignment(addressTextField, HPos.RIGHT);
        // Merge 3 columns into 1 column
        GridPane.setColumnSpan(addressTextField, 3);
        // Set non-editable textField
        addressTextField.setEditable(false);
        addressTextField.setMouseTransparent(true);
        addressTextField.setFocusTraversable(false);
        grid1.add(addressTextField, 1, 1);

        // Set city label and textField on gridPane
        Label cityLabel = new Label("City: ");
        GridPane.setHalignment(cityLabel, HPos.LEFT);
        grid1.add(cityLabel, 4, 1);
        GridPane.setHalignment(cityTextField, HPos.RIGHT);
        // Set non-editable textField
        cityTextField.setEditable(false);
        cityTextField.setMouseTransparent(true);
        cityTextField.setFocusTraversable(false);
        grid1.add(cityTextField, 5, 1);

        // Set province label and textField on gridPane
        Label provinceLabel = new Label("Province: ");
        GridPane.setHalignment(provinceLabel, HPos.LEFT);
        grid1.add(provinceLabel, 6, 1);
        GridPane.setHalignment(provinceTextField, HPos.RIGHT);
        // Set non-editable textField
        provinceTextField.setEditable(false);
        provinceTextField.setMouseTransparent(true);
        provinceTextField.setFocusTraversable(false);
        grid1.add(provinceTextField, 7, 1);

        // Set application id label and textField on gridPane
        Label applicationIdLabel = new Label("Application ID: ");
        GridPane.setHalignment(applicationIdLabel, HPos.LEFT);
        grid1.add(applicationIdLabel, 0, 2);
        GridPane.setHalignment(applicationIDTextField, HPos.RIGHT);
        // Set non-editable textField
        applicationIDTextField.setEditable(false);
        applicationIDTextField.setMouseTransparent(true);
        applicationIDTextField.setFocusTraversable(false);
        grid1.add(applicationIDTextField, 1, 2);

        // Set position label and textField on gridPane
        Label positionLabel = new Label("Position: ");
        GridPane.setHalignment(positionLabel, HPos.LEFT);
        grid1.add(positionLabel, 2, 2);
        GridPane.setHalignment(positionTextField, HPos.RIGHT);
        // Set non-editable textField
        positionTextField.setEditable(false);
        positionTextField.setMouseTransparent(true);
        positionTextField.setFocusTraversable(false);
        grid1.add(positionTextField, 3, 2);

        // Set department label and textField on gridPane
        Label departmentLabel = new Label("Department: ");
        GridPane.setHalignment(departmentLabel, HPos.LEFT);
        grid1.add(departmentLabel, 4, 2);
        GridPane.setHalignment(departmentTextField, HPos.RIGHT);
        // Set non-editable textField
        departmentTextField.setEditable(false);
        departmentTextField.setMouseTransparent(true);
        departmentTextField.setFocusTraversable(false);
        grid1.add(departmentTextField, 5, 2);

        // Set status label and textField on gridPane
        Label statustLabel = new Label("Status: ");
        GridPane.setHalignment(statustLabel, HPos.LEFT);
        grid1.add(statustLabel, 6, 2);
        GridPane.setHalignment(statusTextField, HPos.RIGHT);
        // Set non-editable textField
        statusTextField.setEditable(false);
        statusTextField.setMouseTransparent(true);
        statusTextField.setFocusTraversable(false);
        grid1.add(statusTextField, 7, 2);

        // Set experience 1 label and textField on gridPane
        Label experience1Label = new Label("Experience 1: ");
        GridPane.setHalignment(experience1Label, HPos.LEFT);
        grid1.add(experience1Label, 0, 3);
        GridPane.setHalignment(experience1TextArea, HPos.RIGHT);
        // Merge 7 columns into 1 column, 2 rows into 1 row
        GridPane.setColumnSpan(experience1TextArea, 7);
        GridPane.setRowSpan(experience1TextArea, 2);
        // Set height for textArea
        experience1TextArea.setPrefRowCount(1);
        // Set non-editable textField
        experience1TextArea.setEditable(false);
        experience1TextArea.setMouseTransparent(true);
        experience1TextArea.setFocusTraversable(false);
        grid1.add(experience1TextArea, 1, 3);

        // Set experience 2 label and textField on gridPane
        Label experience2Label = new Label("Experience 2: ");
        GridPane.setHalignment(experience2Label, HPos.LEFT);
        grid1.add(experience2Label, 0, 5);
        GridPane.setHalignment(experience2TextArea, HPos.RIGHT);
        // Merge 7 columns into 1 column, 2 rows into 1 row
        GridPane.setColumnSpan(experience2TextArea, 7);
        GridPane.setRowSpan(experience2TextArea, 2);
        // Set height for textArea
        experience2TextArea.setPrefRowCount(1);
        // Set non-editable textField
        experience2TextArea.setEditable(false);
        experience2TextArea.setMouseTransparent(true);
        experience2TextArea.setFocusTraversable(false);
        grid1.add(experience2TextArea, 1, 5);

        // Set education 1 label and textField on gridPane
        Label education1Label = new Label("Education 1: ");
        GridPane.setHalignment(education1Label, HPos.LEFT);
        grid1.add(education1Label, 0, 7);
        GridPane.setHalignment(education1TextArea, HPos.RIGHT);
        // Merge 7 columns into 1 column, 2 rows into 1 row
        GridPane.setColumnSpan(education1TextArea, 7);
        GridPane.setRowSpan(education1TextArea, 2);
        // Set height for textArea
        education1TextArea.setPrefRowCount(1);
        // Set non-editable textField
        education1TextArea.setEditable(false);
        education1TextArea.setMouseTransparent(true);
        education1TextArea.setFocusTraversable(false);
        grid1.add(education1TextArea, 1, 7);

        // Set education 2 label and textField on gridPane
        Label education2Label = new Label("Education 2: ");
        GridPane.setHalignment(education2Label, HPos.LEFT);
        grid1.add(education2Label, 0, 9);
        GridPane.setHalignment(education2TextArea, HPos.RIGHT);
        // Merge 7 columns into 1 column, 2 rows into 1 row
        GridPane.setColumnSpan(education2TextArea, 7);
        GridPane.setRowSpan(education2TextArea, 2);
        // Set height for textArea
        education2TextArea.setPrefRowCount(1);
        // Set non-editable textField
        education2TextArea.setEditable(false);
        education2TextArea.setMouseTransparent(true);
        education2TextArea.setFocusTraversable(false);
        grid1.add(education2TextArea, 1, 9);

        // Add gridPane and hBox to VBox
        hBox1.getChildren().add(grid1);
        vbox.getChildren().add(hBox1);

        // Add single row pane inside the VBox pane
        HBox hBox2 = new HBox();
        // Add GridPane to UI
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(30);
        grid2.setVgap(30);
        grid2.setPadding(new Insets(15, 15, 15, 15));// Margins around grid(top,right,bottom,left)

        // Set buttons on gridPane
        grid2.add(btnComment, 27, 0);
        grid2.add(btnAccept, 28, 0);
        grid2.add(btnIgnore, 29, 0);
        grid2.add(btnReject, 30, 0);

        btnComment.setOnAction(e -> {
            // Create a new stage for comment window
            Stage commentStage = new Stage();

            // Create a border Pane
            BorderPane borderPane1 = new BorderPane();
            // Set padding value for borderPane
            borderPane1.setPadding(new Insets(15, 25, 15, 25));

            borderPane1.setLeft(addVBox1());
            StackPane secondPane = new StackPane(borderPane1);
            Scene secondScene = new Scene(secondPane, 500, 400);
            commentStage.setScene(secondScene);
            commentStage.show();

            // get comment of the loading application
            loadComment();
        });

        btnAccept.setOnAction(e -> {
            // Update status for the application
            ApplicationEntity updatedApplication = applicationController.acceptApplication(id);
            updatedApplication.setStatus("accept");
            loadData();

            // Show notify
            Alert msgbox = new Alert(AlertType.INFORMATION);
            msgbox.setTitle("Accept Application");
            msgbox.setHeaderText(null);
            msgbox.setContentText("The application is accepted!");
            msgbox.showAndWait();
        });

        btnReject.setOnAction(e -> {
            // Update status for the application
            ApplicationEntity updatedApplication = applicationController.rejectApplication(id);
            updatedApplication.setStatus("reject");
            loadData();

            // Show notify
            Alert msgbox = new Alert(AlertType.INFORMATION);
            msgbox.setTitle("Reject Application");
            msgbox.setHeaderText(null);
            msgbox.setContentText("The application is rejected!");
            msgbox.showAndWait();
        });

        // Add gridPane and hBox to VBox
        hBox2.getChildren().add(grid2);
        vbox.getChildren().add(hBox2);

        return vbox;
    } // End of addVBox method

    // Method for comment window
    private VBox addVBox1() {
        VBox vbox1 = new VBox();
        vbox1.setPadding(new Insets(20)); // Set all sides to 25
        vbox1.setSpacing(20);

        Label testLabel = new Label("Write down your comments here: ");
        commentTextArea.setPrefWidth(400);

        // Add single row pane inside the VBox pane
        HBox hBox3 = new HBox();
        // Add GridPane to UI
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(30);
        grid3.setVgap(30);
        grid3.setPadding(new Insets(15, 15, 15, 15));// Margins around grid(top,right,bottom,left)

        // Set buttons on gridPane
        grid3.add(btnUpdateComment, 7, 0);
        grid3.add(btnDeleteComment, 8, 0);
        grid3.add(btnIgnoreComment, 9, 0);

        // Set actions for buttons
        btnUpdateComment.setOnAction(e -> {
            // Saving or Updating comment for the application
            // String commentArea = String.valueOf(commentTextArea.getText().trim());
            // call controller
            ApplicationEntity application = applicationController.getApplication(id);
            String commentArea = commentTextArea.getText();
            if (application.getContent() == null) {

                System.out.println("is empty");
                ApplicationEntity savedApplication = applicationController.saveComment(id, commentArea, usrId);
                savedApplication.setContent(commentArea);
            } else {
                System.out.println("is not empty");
                ApplicationEntity updatedApplication = applicationController.updateComment(id, commentArea);
                updatedApplication.setContent(commentArea);
            }
            loadComment(); // Reload the latest comment

            // notice
            Alert msgbox = new Alert(AlertType.INFORMATION);
            msgbox.setTitle("Save the comment");
            msgbox.setHeaderText(null);
            msgbox.setContentText("Your comment is saved!");
            msgbox.showAndWait();
        });
        btnDeleteComment.setOnAction(e -> {
            // Deleting comment for the application
            // call controller
            ApplicationEntity application = applicationController.getApplication(id);
            String commentArea = commentTextArea.getText();
            if (application.getContent() == null) {

                System.out.println("is empty");
                Alert msgbox = new Alert(AlertType.INFORMATION);
                msgbox.setTitle("Delete the comment");
                msgbox.setHeaderText(null);
                msgbox.setContentText("There is no comment can be delete!");
                msgbox.showAndWait();
            } else {
                System.out.println("is not empty");
                ApplicationEntity deletedApplication = applicationController.deleteComment(id);
                deletedApplication.setContent(commentArea);

                Alert msgbox = new Alert(AlertType.INFORMATION);
                msgbox.setTitle("Delete the comment");
                msgbox.setHeaderText(null);
                msgbox.setContentText("Your comment is deleted!");
                msgbox.showAndWait();
            }
            loadComment(); // Reload the latest comment
        });
        btnIgnoreComment.setOnAction(e -> {
            final Stage currentStage = (Stage) btnIgnoreComment.getScene().getWindow();
            currentStage.close();
        });

        vbox1.getChildren().addAll(testLabel, commentTextArea, grid3);
        return vbox1;
    } // End of addVBox1 method

    // Load data into UI
    public void loadData() {
        // call controller
        ApplicationEntity application = applicationController.getApplication(id);
        // Fill data
        fNameTextField.setText(String.valueOf(application.getFirstName()));
        lNameTextField.setText(String.valueOf(application.getLastName()));
        phoneTextField.setText(String.valueOf(application.getPhone()));
        emailTextField.setText(String.valueOf(application.getEmail()));
        addressTextField.setText(String.valueOf(application.getAddress()));
        cityTextField.setText(String.valueOf(application.getCity()));
        provinceTextField.setText(String.valueOf(application.getProvince()));
        positionTextField.setText(String.valueOf(application.getPosition()));
        departmentTextField.setText(String.valueOf(application.getDepartment()));
        statusTextField.setText(String.valueOf(application.getStatus()));
        experience1TextArea.setText(String.valueOf(application.getExperience1()));
        experience2TextArea.setText(String.valueOf(application.getExperience2()));
        education1TextArea.setText(String.valueOf(application.getEducation1()));
        education2TextArea.setText(String.valueOf(application.getEducation2()));
        applicationIDTextField.setText(String.valueOf(application.getId()));


    } // End of Loading data method

    // Load comment into UI
    public void loadComment() {
        // call controller
        ApplicationEntity application = applicationController.getApplication(id);
        // Fill comment
        if (application.getContent() == null) {
            commentTextArea.setText("");
        } else {
            commentTextArea.setText(String.valueOf(application.getContent()));
        }
    } // End of Loading comment method

    private Node addSomething() {
        return null;
    }

    public void onClickAcceptButton() {
        //
        ApplicationController applicationController = new ApplicationController();
        ApplicationEntity acceptedApplication = applicationController.acceptApplication(1);
        // refresh the application data in the view;
        // pane.set

    }

    public Integer getUsrId (String email) {
        Integer id = null;
        Connection connection = Database.getConnection();
    String sql = "";
    try {
      sql = "select id from users where email = '" + loginEmail + "'";
      ResultSet resultSet = connection.createStatement().executeQuery(sql);

      if (resultSet.next()) {
        id = (resultSet.getInt("id"));
      } else {
      }
      // Close the db connection
      connection.close();
      System.out.println("DB is disconnected!");
      
    } catch (SQLException e) {
      e.printStackTrace();
    }
        return id;
    }

}