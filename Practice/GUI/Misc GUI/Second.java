import javafx.application.Application;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Second extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage myStage)
    {
        myStage.setTitle("Drawing :)");
        Pane root = new Pane();
        //TEXT
        Text text = new Text();
        text.setText("Hi from Sannan !! :)");
        text.setFill(Color.RED);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        text.setX(30);
        text.setY(50);
        root.getChildren().add(text);


        Scene scene = new Scene(root,600,600,Color.LIGHTBLUE);


        myStage.setScene(scene);
        myStage.show();
    }

}