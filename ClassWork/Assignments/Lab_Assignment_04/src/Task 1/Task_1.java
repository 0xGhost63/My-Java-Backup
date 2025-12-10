import javafx.application.Application;
import javafx.event.ActionEvent;       
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//Without FXML 
public class Task_1 extends Application
{
    Label response;
    ToggleGroup tg;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage mystage) throws Exception
    {
        // Stage
        mystage.setTitle("Lab JavaFX :)");
        mystage.setResizable(true);

        // Node
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);

        // Scene
        Scene myScene = new Scene(rootNode, 300, 200);

        // Labels
        Label choose = new Label("Please Select Your Semester !");
        response = new Label("No Semester Selected !");

        // Button
        Button btnConfirm = new Button("Confirm Selection Semester");

        // Radio Buttons
        RadioButton rbOne = new RadioButton("First");
        RadioButton rbTwo = new RadioButton("Second");
        RadioButton rbThree = new RadioButton("Third");

        // Setting ToggleGroup of radio Buttons
        tg = new ToggleGroup();
        rbOne.setToggleGroup(tg);
        rbOne.setSelected(true);
        rbTwo.setToggleGroup(tg);
        rbThree.setToggleGroup(tg);

        // Separator
        Separator separator = new Separator();
        separator.setPrefWidth(190);

        // Adding the nodes to the root node
        rootNode.getChildren().addAll(choose, rbOne, rbTwo, rbThree, separator, btnConfirm, response);

        // Setting the scene to the stage
        mystage.setScene(myScene);
        mystage.show();

        //Event Handling !

        btnConfirm.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            public void handle(ActionEvent a)
            {
                RadioButton rb = (RadioButton) tg.getSelectedToggle();
                response.setText(rb.getText() + "  is confirmed");
            }
        });
    }
}
