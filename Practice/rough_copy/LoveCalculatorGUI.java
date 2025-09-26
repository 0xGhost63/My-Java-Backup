import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LoveCalculatorGUI extends JFrame {

    private JTextField name1Field, name2Field;
    private JLabel resultLabel;
    private JButton calculateButton;
    private AnimationPanel animationPanel;
    private Random random = new Random();

    public LoveCalculatorGUI() {
        // Basic JFrame setup
        setTitle("❤️ Love Calculator ❤️");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Define colors and fonts
        Color pink = new Color(255, 182, 193);
        Color red = new Color(255, 69, 0);
        Font centuryGothic = new Font("Century Gothic", Font.BOLD, 16);
        Font centuryGothicTitle = new Font("Century Gothic", Font.BOLD, 32);

        // Main panel with a custom background and layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(pink);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title Label
        JLabel titleLabel = new JLabel("Love Calculator");
        titleLabel.setFont(centuryGothicTitle);
        titleLabel.setForeground(red);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(titleLabel, gbc);

        // Labels for names
        JLabel name1Label = new JLabel("Your Name:");
        name1Label.setFont(centuryGothic);
        name1Label.setForeground(Color.BLACK);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(name1Label, gbc);

        JLabel name2Label = new JLabel("Their Name:");
        name2Label.setFont(centuryGothic);
        name2Label.setForeground(Color.BLACK);
        gbc.gridy = 2;
        mainPanel.add(name2Label, gbc);

        // Text fields for names
        name1Field = new JTextField(15);
        name1Field.setFont(centuryGothic);
        name1Field.setBorder(BorderFactory.createLineBorder(red, 2, true));
        name1Field.setBackground(new Color(255, 230, 235));
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(name1Field, gbc);

        name2Field = new JTextField(15);
        name2Field.setFont(centuryGothic);
        name2Field.setBorder(BorderFactory.createLineBorder(red, 2, true));
        name2Field.setBackground(new Color(255, 230, 235));
        gbc.gridy = 2;
        mainPanel.add(name2Field, gbc);

        // Calculate Button with a nice style
        calculateButton = new JButton("Calculate Love ❤️");
        calculateButton.setFont(centuryGothic);
        calculateButton.setBackground(red);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        calculateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(calculateButton, gbc);
        
        // Result Label
        resultLabel = new JLabel("Enter names and click the button!", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        resultLabel.setForeground(red);
        gbc.gridy = 4;
        mainPanel.add(resultLabel, gbc);

        // Custom panel for animations
        animationPanel = new AnimationPanel();
        animationPanel.setPreferredSize(new Dimension(400, 250));
        gbc.gridy = 5;
        mainPanel.add(animationPanel, gbc);

        // Add action listener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateLove();
            }
        });

        // Add the main panel to the frame
        add(mainPanel);
    }

    private void calculateLove() {
        String name1 = name1Field.getText().trim().toLowerCase();
        String name2 = name2Field.getText().trim().toLowerCase();

        if (name1.isEmpty() || name2.isEmpty()) {
            resultLabel.setText("Please enter both names.");
            return;
        }

        // Simple love calculation based on common letters
        int commonLetters = 0;
        for (char c : "love".toCharArray()) {
            if (name1.indexOf(c) != -1 && name2.indexOf(c) != -1) {
                commonLetters += 20; // Bonus for letters in "love"
            }
        }
        
        // Count common letters
        String combined = name1 + name2;
        int sum = 0;
        for (char c : combined.toCharArray()) {
            sum += c;
        }
        int loveScore = (sum % 100) + commonLetters;
        
        // Ensure score is between 0 and 100
        loveScore = Math.max(0, Math.min(100, loveScore));

        // Display result with a message
        String message;
        if (loveScore >= 80) {
            message = "A perfect match! " + loveScore + "% ❤️";
            animationPanel.addHearts(10);
        } else if (loveScore >= 50) {
            message = "A strong connection! " + loveScore + "% 💕";
            animationPanel.addHearts(5);
        } else {
            message = "It's a start! " + loveScore + "% 💔";
            animationPanel.addHearts(2);
        }
        
        // Update label and start animation
        resultLabel.setText(message);
        animationPanel.startAnimation();
    }

    // Custom JPanel for the heart animation
    class AnimationPanel extends JPanel {
        private java.util.List<Heart> hearts = new java.util.ArrayList<>();
        private Timer timer;

        public AnimationPanel() {
            setBackground(new Color(255, 182, 193));
            setOpaque(true);

            timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Update heart positions and opacities
                    for (Heart heart : hearts) {
                        heart.y -= heart.speed;
                        heart.opacity -= heart.fadeRate;
                        if (heart.opacity <= 0) {
                            heart.reset();
                        }
                    }
                    repaint(); // Trigger repaint
                }
            });
        }
        
        public void startAnimation() {
            if (!timer.isRunning()) {
                timer.start();
            }
        }
        
        public void addHearts(int count) {
            hearts.clear();
            for (int i = 0; i < count; i++) {
                hearts.add(new Heart(getWidth(), getHeight()));
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            for (Heart heart : hearts) {
                g2d.setColor(new Color(heart.color.getRed(), heart.color.getGreen(), heart.color.getBlue(), (int) (heart.opacity * 255)));
                drawHeart(g2d, heart.x, heart.y, heart.size);
            }
        }
        
        private void drawHeart(Graphics2D g2d, int x, int y, int size) {
            int[] xPoints = {x, x - size / 2, x + size / 2, x};
            int[] yPoints = {y + size, y, y, y + size};
            g2d.fillPolygon(xPoints, yPoints, 4);

            g2d.fillArc(x - size, y - size, size, size, 0, 180);
            g2d.fillArc(x, y - size, size, size, 0, 180);
        }
    }
    
    // Heart object for animation
    class Heart {
        int x, y, size, speed;
        float opacity, fadeRate;
        Color color;

        public Heart(int panelWidth, int panelHeight) {
            reset();
            this.x = random.nextInt(panelWidth);
            this.y = random.nextInt(panelHeight);
        }
        
        public void reset() {
            this.x = random.nextInt(400); // Random x position
            this.y = 250 + random.nextInt(50); // Start from the bottom
            this.size = 10 + random.nextInt(20); // Random size
            this.speed = 1 + random.nextInt(3); // Random speed
            this.opacity = 1.0f;
            this.fadeRate = 0.005f + random.nextFloat() * 0.01f;
            this.color = (random.nextBoolean()) ? new Color(255, 105, 180) : new Color(255, 0, 0); // Pink or Red
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoveCalculatorGUI().setVisible(true);
            }
        });
    }
}
