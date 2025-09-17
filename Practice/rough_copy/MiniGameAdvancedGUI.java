import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MiniGameAdvancedGUI extends JFrame {

    private final int numberToGuess;
    private int attempts = 0;
    private final JTextField guessField;
    private final JLabel resultLabel;
    private final JButton guessButton;
    private final JLabel attemptsLabel;

    public MiniGameAdvancedGUI() {
        super("Guess the Number! 🎲");

        // Apply Nimbus Look & Feel if available
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // fallback to default look & feel
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350); // Bigger window
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Guess the Number Game", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        JLabel instructionsLabel = new JLabel("I've picked a number between 1 and 100. Enter your guess below:", SwingConstants.CENTER);
        instructionsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        gbc.gridy = 1;
        mainPanel.add(instructionsLabel, gbc);

        gbc.gridwidth = 1;

        // --- Bigger input box ---
        guessField = new JTextField(20);
        guessField.setFont(new Font("Segoe UI", Font.PLAIN, 28));
        guessField.setPreferredSize(new Dimension(300, 70));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(guessField, gbc);

        // --- Bigger button ---
        guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Segoe UI", Font.BOLD, 24));
        guessButton.setPreferredSize(new Dimension(200, 70));
        gbc.gridx = 1;
        mainPanel.add(guessButton, gbc);

        resultLabel = new JLabel("Let's go!", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(resultLabel, gbc);

        attemptsLabel = new JLabel("Attempts: 0", SwingConstants.CENTER);
        attemptsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        gbc.gridy = 4;
        mainPanel.add(attemptsLabel, gbc);

        Random rand = new Random();
        numberToGuess = rand.nextInt(100) + 1;

        ActionListener guessActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        };
        guessButton.addActionListener(guessActionListener);
        guessField.addActionListener(guessActionListener);

        add(mainPanel);
        setVisible(true);
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            attempts++;
            attemptsLabel.setText("Attempts: " + attempts);

            if (guess < numberToGuess) {
                resultLabel.setText("Too low! ⬇️");
                resultLabel.setForeground(Color.RED);
            } else if (guess > numberToGuess) {
                resultLabel.setText("Too high! ⬆️");
                resultLabel.setForeground(Color.RED);
            } else {
                resultLabel.setText("🎉 You got it in " + attempts + " tries!");
                resultLabel.setForeground(new Color(34, 139, 34));
                guessButton.setEnabled(false);
                guessField.setEditable(false);
            }
            guessField.setText("");
        } catch (NumberFormatException ex) {
            resultLabel.setText("That's not a number. Try again. 🤨");
            resultLabel.setForeground(Color.ORANGE);
            guessField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MiniGameAdvancedGUI::new);
    }
}
