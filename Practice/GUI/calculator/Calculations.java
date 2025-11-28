package calculator;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Calculations
{
    @FXML
    private Label display;

    private double first_Number = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @FXML
    private void numberPressed(ActionEvent event)
    {
        Button btn = (Button) event.getSource();
        String value = btn.getText();

        if (startNewNumber)
        {
            display.setText(value);
            startNewNumber = false;
        }
        else
        {
            display.setText(display.getText() + value);
        }
    }

    @FXML
    private void operatorPressed(ActionEvent event)
    {
        Button btn = (Button) event.getSource();
        operator = btn.getText();
        first_Number = Double.parseDouble(display.getText());
        startNewNumber = true;
    }

    @FXML
    private void equalsPressed()
    {
        double second_Number = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator)
        {
            case "+": result = first_Number + second_Number; break;
            case "-": result = first_Number - second_Number; break;
            case "×": result = first_Number * second_Number; break;
            case "/": result = first_Number / second_Number; break;
        }

        display.setText(String.valueOf(result));
        startNewNumber = true;
    }

    @FXML
    private void clearPressed()
    {
        display.setText("");
        first_Number = 0;
        operator = "";
        startNewNumber = true;
    }
}
