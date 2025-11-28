package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Login extends Application
{
    public static void main(String[] args)
    {
        launch(args); // starts the JavaFX application
    }

    @Override
    public void start(Stage myStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Home.fxml"));
        Scene scene = new Scene(root,666,666,Color.DARKGRAY);

        myStage.setScene(scene);
        myStage.setResizable(false);
        myStage.setTitle("LogIn Page :)");
        myStage.show();
    }
}
