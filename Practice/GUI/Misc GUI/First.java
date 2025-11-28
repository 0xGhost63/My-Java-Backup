import javafx.application.Application;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;



import java.awt.*;

public class First extends Application
{
    public static void main(String [] args )
    {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("First Program");
        stage.setResizable(false);
//        stage.setHeight(600);
//        stage.setWidth(800);

        Image icon = new Image("file:images/icon.png");
        stage.getIcons().add(icon);

        Label myLabel = new Label("First Program");

        StackPane mypane = new StackPane();
        mypane.setStyle("-fx-background-color: Pink;");
        mypane.getChildren().add(myLabel);

//        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Hehe...you can't escape until pressing S");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("S"));
        Scene myscene = new Scene(mypane,600,600,Color.PINK);

        stage.setScene(myscene);
        stage.show();
    }




}
