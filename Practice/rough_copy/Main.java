import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Main extends Application 
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mystage)
    {
        mystage.setTitle("My First JavaFX Application");
        FlowPane rootNode = new FlowPane();
        Label myLabel = new Label ("Hello World");
        Button myButton = new Button("Click Me :)");

        rootNode.getChildren().addAll(myLabel,myButton);

        Scene myscene = new Scene(rootNode, 400, 300);
        mystage.setScene(myscene);
        mystage.show();
    }
}

//javac --module-path /home/sannan/javafx/javafx-sdk-23.0.1/lib --add-modules javafx.controls Main.java && java --module-path /home/sannan/javafx/javafx-sdk-23.0.1/lib --add-modules javafx.controls Main
