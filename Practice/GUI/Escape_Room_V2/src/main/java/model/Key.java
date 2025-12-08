package model;

/**
 * Key item that allows the player to unlock doors.
 * When collected, sets a flag that can be checked for level transitions.
 */
public class Key extends Item {
    /**
     * Creates a new Key at the specified position.
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     */
    public Key(double x, double y) {
        super(x, y, 25, 25, "/images/key.png");
    }

    @Override
    public void collect(Player player) {
        if (!collected && detectCollision(player)) {
            // Add a special score bonus for keys
            player.addScore(50);
            markAsCollected();
            // Play sound effect (to be implemented)
        }
    }

    /**
     * Checks if the key has been collected.
     * @return true if collected
     */
    public boolean isKeyCollected() {
        return collected;
    }
}

