package Views;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Controllers.AddUserController;
import Entities.DepartmentEntity;
import Services.UserService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddUserView extends Application {
	private ObservableList<DepartmentEntity> departmentList = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {

		GridPane pane2 = new GridPane();
		Label title = new Label("Create A New User");
		title.setFont(Font.font(null, FontWeight.BOLD, 35));
		pane2.add(title, 0, 0);
		GridPane.setHalignment(title, HPos.LEFT);

		GridPane pane = new GridPane();

		pane.setPadding(new Insets(20, 20, 20, 20));
		pane.setVgap(2);
		pane.setHgap(150);

		Image camera = new Image("https://cdn-icons-png.flaticon.com/512/3566/3566345.png");
		ImageView cameraView = new ImageView(camera);
		cameraView.setFitHeight(50);
		cameraView.setFitWidth(50);

		BorderPane pane1 = new BorderPane();
		pane1.setCenter(cameraView);

		pane.add(pane1, 1, 0, 2, 1);

		Label label = new Label("First Name");
		pane.add(label, 1, 5);
		TextField firstName = new TextField();
		pane.add(firstName, 1, 6);

		Label label1 = new Label("Last Name");
		pane.add(label1, 2, 5);
		TextField lastName = new TextField();
		pane.add(lastName, 2, 6);

		Label label2 = new Label("Email");
		pane.add(label2, 1, 10);
		TextField email = new TextField();
		pane.add(email, 1, 11, 2, 1);

		Label label9 = new Label("Password");
		pane.add(label9, 1, 19);
		PasswordField password = new PasswordField();
		pane.add(password, 1, 20);

		Label label10 = new Label("Role");
		pane.add(label10, 2, 19);
		ChoiceBox roleBox = new ChoiceBox();
        ObservableList<String> options = FXCollections.observableArrayList(
        "Regular",
        "Admin");
        roleBox.setItems(options);
		roleBox.getSelectionModel().selectFirst();
		pane.add(roleBox, 2, 20);

		Label label11 = new Label("Department");
		pane.add(label11,2,28);
		ChoiceBox<DepartmentEntity> departmentIDBox = new ChoiceBox();
		departmentList = FXCollections.observableList(AddUserController.getDepartmentList());
        departmentIDBox.setItems(departmentList);
		departmentIDBox.getSelectionModel().selectFirst();

		pane.add(departmentIDBox, 2, 29);



		Button save = new Button("   Save   ");
		save.setFont(Font.font(17));
		save.setStyle("-fx-background-color: #0574B2");
		save.setTextFill(Color.WHITE);

		pane.add(save, 1, 31);

		pane2.add(pane, 100, 1);
		GridPane.setHalignment(pane, HPos.CENTER);

		// action
		save.setOnAction(e -> {
            if(firstName.getText()==""||lastName.getText()==""||email.getText()==""||password.getText()==""){
                System.out.println("Failed!");
            }else{
                AddUserController.addUserToMysql(firstName.getText(),lastName.getText(),email.getText(),password.getText(),(String) roleBox.getValue(), departmentIDBox.getValue().getId());
            }
            primaryStage.close();
			try {
				new AdminUserDashBoardView().start(new Stage());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Scene scene = new Scene(pane2, 1280, 720);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Profile");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
