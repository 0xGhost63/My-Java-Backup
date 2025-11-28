import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField display;
    private double num1, num2, result;
    private char operator;

    public CalculatorGUI() {
        // Title
        setTitle("Simple Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        // Display field
        display = new JTextField();
        display.setBounds(30, 40, 270, 40);
        display.setEditable(false);
        add(display);

        // Button labels
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Button grid
        int x = 30, y = 100;
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBounds(x, y, 60, 60);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            add(button);

            x += 70;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 70;
            }
        }

        // Clear button
        JButton clearBtn = new JButton("C");
        clearBtn.setBounds(30, y, 270, 60);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 20));
        clearBtn.addActionListener(this);
        add(clearBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        // Clear button
        if (input.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
            operator = '\0';
            return;
        }

        // Operator buttons
        if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
            num1 = Double.parseDouble(display.getText());
            operator = input.charAt(0);
            display.setText("");
            return;
        }

        // Equals button
        if (input.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if (num2 == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = num1 / num2; 
                    break;
            }
            display.setText(String.valueOf(result));
            operator = '\0';
            return;
        }

        // Numbers and decimal
        display.setText(display.getText() + input);
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
