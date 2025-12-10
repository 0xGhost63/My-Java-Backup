import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Task_2 extends Application
{
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        // Stage
        stage.setTitle("JavaFX with FXML");
        stage.setResizable(false);

        // FXML loading
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Task_2.fxml"));

        Parent rootNode = fxmlloader.load();

        // Scene 
        Scene scene = new Scene(rootNode);

        // Displaying stage
        stage.setScene(scene);
        stage.show();
    }
}
