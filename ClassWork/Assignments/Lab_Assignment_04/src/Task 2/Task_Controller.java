import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;

public class Task_Controller 
{

    @FXML
    private Button btnConfirm;

    @FXML
    private ToggleGroup tg;

    @FXML
    private Label response;

    @FXML
    void onClickHandler(ActionEvent event)
    {
        RadioButton rb = (RadioButton) tg.getSelectedToggle();
        response.setText(rb.getText() + " is confirmed.");
    }
}
