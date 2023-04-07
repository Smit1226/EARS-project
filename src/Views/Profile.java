package Views;

import java.sql.SQLException;

import Services.UserService;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class Profile extends Application {

	@Override
	public void start(Stage primaryStage) {

		GridPane pane2 = new GridPane();
		Label title = new Label("XXX's Profile");
		title.setText(LoginView.userEntity.getFirstName() + "'s Profile");
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
		firstName.setText(LoginView.userEntity.getFirstName());
		pane.add(firstName, 1, 6);

		Label label1 = new Label("Last Name");
		pane.add(label1, 2, 5);
		TextField lastName = new TextField();
		lastName.setText(LoginView.userEntity.getLastName());
		pane.add(lastName, 2, 6);

		Label label2 = new Label("Email");
		pane.add(label2, 1, 10);
		TextField email = new TextField();
		email.setText(LoginView.userEntity.getEmail());
		pane.add(email, 1, 11, 2, 1);

		Label label9 = new Label("Password");
		pane.add(label9, 1, 19);
		PasswordField password = new PasswordField();
		password.setText(LoginView.userEntity.getPassword());
		pane.add(password, 1, 20);

		Label label10 = new Label("Role");
		pane.add(label10, 2, 19);
		TextField role = new TextField();
		role.setText(LoginView.userEntity.getRole());
		pane.add(role, 2, 20);

		Button save = new Button("   Save   ");
		save.setFont(Font.font(17));
		save.setStyle("-fx-background-color: #0574B2");
		save.setTextFill(Color.WHITE);

		pane.add(save, 1, 31);

		pane2.add(pane, 100, 1);
		GridPane.setHalignment(pane, HPos.CENTER);

		// action
		save.setOnAction(e -> {

			String firstname = firstName.getText();
			String lastname = lastName.getText();
			String Pass = password.getText();
			String Role = role.getText();
			String Email = email.getText();

			UserService.setUserByEmail(Email, firstname, lastname, Pass, Role);
			UserContext userContext = UserContext.getInstance();
			try {
				if (userContext.getUser().isAdmin()) {
					new AdminUserDashBoardView().start(new Stage());
				} else {
					new DashboardView().start(new Stage());
				}

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				primaryStage.close();
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
