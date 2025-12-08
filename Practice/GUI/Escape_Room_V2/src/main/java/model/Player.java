package model;

import javafx.scene.input.KeyCode;

/**
 * Represents the player character in the game.
 * Handles movement, health, score, and lives.
 */
public class Player extends GameObject implements Damageable {
    private int health;
    private int maxHealth;
    private int score;
    private int lives;
    private double speed;
    private KeyCode lastPressedKey;
    
    // Movement flags
    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;

    /**
     * Creates a new Player at the specified position.
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     */
    public Player(double x, double y) {
        super(x, y, 40, 40, "/images/player.png");
        this.maxHealth = 100;
        this.health = maxHealth;
        this.score = 0;
        this.lives = 3;
        this.speed = 3.0;
    }

    /**
     * Updates player position based on movement flags.
     */
    public void update() {
        double newX = x;
        double newY = y;

        if (movingLeft) {
            newX -= speed;
        }
        if (movingRight) {
            newX += speed;
        }
        if (movingUp) {
            newY -= speed;
        }
        if (movingDown) {
            newY += speed;
        }

        setX(newX);
        setY(newY);
    }

    /**
     * Starts movement in a direction.
     * @param key The key that was pressed
     */
    public void startMoving(KeyCode key) {
        switch (key) {
            case W:
            case UP:
                movingUp = true;
                break;
            case S:
            case DOWN:
                movingDown = true;
                break;
            case A:
            case LEFT:
                movingLeft = true;
                break;
            case D:
            case RIGHT:
                movingRight = true;
                break;
        }
        lastPressedKey = key;
    }

    /**
     * Stops movement in a direction.
     * @param key The key that was released
     */
    public void stopMoving(KeyCode key) {
        switch (key) {
            case W:
            case UP:
                movingUp = false;
                break;
            case S:
            case DOWN:
                movingDown = false;
                break;
            case A:
            case LEFT:
                movingLeft = false;
                break;
            case D:
            case RIGHT:
                movingRight = false;
                break;
        }
    }

    /**
     * Adds score to the player.
     * @param points Points to add
     */
    public void addScore(int points) {
        this.score += points;
    }

    /**
     * Restores health to the player.
     * @param amount Amount of health to restore
     */
    public void restoreHealth(int amount) {
        this.health = Math.min(maxHealth, health + amount);
    }

    @Override
    public void takeDamage(int amount) {
        this.health = Math.max(0, health - amount);
    }

    /**
     * Checks if the player is dead.
     * @return true if health is 0 or below
     */
    public boolean isDead() {
        return health <= 0;
    }

    /**
     * Loses a life and resets health if lives remain.
     */
    public void loseLife() {
        lives--;
        if (lives > 0) {
            health = maxHealth;
        }
    }

    /**
     * Checks if the player has no lives left.
     * @return true if game over
     */
    public boolean isGameOver() {
        return lives <= 0 && health <= 0;
    }

    /**
     * Checks if player has a key to open doors.
     * @return true if player has key
     */
    public boolean hasKey() {
        return score > 0; // Simplified: using score > 0 as key indicator
        // In a more complex version, you'd track keys separately
    }

    // Getters and Setters
    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setPosition(double x, double y) {
        setX(x);
        setY(y);
    }
}

