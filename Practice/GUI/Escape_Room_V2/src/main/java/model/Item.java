package model;

/**
 * Abstract base class for all collectible items in the game.
 */
public abstract class Item extends GameObject implements Collectible {
    protected boolean collected;

    /**
     * Creates a new Item at the specified position.
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     * @param width Width of the item
     * @param height Height of the item
     * @param imagePath Path to the item's image
     */
    public Item(double x, double y, double width, double height, String imagePath) {
        super(x, y, width, height, imagePath);
        this.collected = false;
    }

    /**
     * Checks if the item has been collected.
     * @return true if collected
     */
    public boolean isCollected() {
        return collected;
    }

    /**
     * Marks the item as collected.
     */
    public void markAsCollected() {
        this.collected = true;
        setActive(false);
    }

    @Override
    public abstract void collect(Player player);
}

