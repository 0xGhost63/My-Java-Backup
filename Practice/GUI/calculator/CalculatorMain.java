package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorMain extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));

        stage.setTitle("Calculator :)");
        stage.setResizable(false);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
