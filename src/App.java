import DAL.Database;
import Views.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    private boolean isLogin = false;

    public static void main(String[] args) throws Exception {
        // initialize database connection pool
        new Database();
        launch(args);

    }

    @Override
    public void start(Stage arg0) throws Exception {
        // display login view by default, when detect already login, switch to dashboard
        // view
        if (isLogin) {

        } else {
            new LoginView().start(new Stage());
        }
    }

}
