package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * Abstract base class for all game objects.
 * Provides common functionality for position, collision detection, and rendering.
 */
public abstract class GameObject {
    protected double x;
    protected double y;
    protected double width;
    protected double height;
    protected ImageView imageView;
    protected boolean active;

    /**
     * Creates a new GameObject at the specified position with the given image.
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param width The width of the object
     * @param height The height of the object
     * @param imagePath Path to the image resource
     */
    public GameObject(double x, double y, double width, double height, String imagePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.active = true;
        
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            this.imageView = new ImageView(image);
            this.imageView.setFitWidth(width);
            this.imageView.setFitHeight(height);
            this.imageView.setLayoutX(x);
            this.imageView.setLayoutY(y);
        } catch (Exception e) {
            // If image not found, create a colored rectangle placeholder
            this.imageView = new ImageView();
            this.imageView.setFitWidth(width);
            this.imageView.setFitHeight(height);
            this.imageView.setLayoutX(x);
            this.imageView.setLayoutY(y);
        }
    }

    /**
     * Updates the position of the game object.
     */
    public void updatePosition() {
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
    }

    /**
     * Detects collision with another game object using bounding box collision.
     * @param other The other game object to check collision with
     * @return true if colliding, false otherwise
     */
    public boolean detectCollision(GameObject other) {
        if (!this.active || !other.active) {
            return false;
        }
        
        return x < other.x + other.width &&
               x + width > other.x &&
               y < other.y + other.height &&
               y + height > other.y;
    }

    /**
     * Gets the bounding rectangle for this object.
     * @return Rectangle representing the bounds
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    // Getters and Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
        updatePosition();
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
        updatePosition();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        if (imageView != null) {
            imageView.setFitWidth(width);
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        if (imageView != null) {
            imageView.setFitHeight(height);
        }
    }

    public ImageView getImageView() {
        return imageView;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
        if (imageView != null) {
            imageView.setVisible(active);
        }
    }
}

