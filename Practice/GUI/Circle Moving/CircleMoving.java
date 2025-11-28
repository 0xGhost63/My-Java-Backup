import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class CircleMoving extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage myStage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MoveCircle.fxml"));
        loader.setController(new CircleController()); // explicitly set controller
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 600);
        myStage.setTitle("Circle Moving");
        myStage.setResizable(false);
        myStage.setScene(scene);
        myStage.show();
    }
}

// package-private controller
class CircleController
{
    @FXML
    private Circle mycircle;

    private double x_axis;
    private double y_axis;

    @FXML
    public void initialize()
    {
        x_axis = mycircle.getCenterX();
        y_axis = mycircle.getCenterY();
    }

    @FXML
    public void moveUP(ActionEvent event)
    {
        y_axis -= 10;
        mycircle.setCenterY(y_axis);
    }

    @FXML
    public void moveDOWN(ActionEvent event)
    {
        y_axis += 10;
        mycircle.setCenterY(y_axis);
    }

    @FXML
    public void moveRIGHT(ActionEvent event)
    {
        x_axis += 10;
        mycircle.setCenterX(x_axis);
    }

    @FXML
    public void moveLEFT(ActionEvent event)
    {
        x_axis -= 10;
        mycircle.setCenterX(x_axis);
    }
}
