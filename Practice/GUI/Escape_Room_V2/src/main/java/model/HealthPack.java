package model;

/**
 * Health pack item that restores player health when collected.
 */
public class HealthPack extends Item {
    private static final int HEAL_AMOUNT = 30;

    /**
     * Creates a new HealthPack at the specified position.
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     */
    public HealthPack(double x, double y) {
        super(x, y, 30, 30, "/images/healthpack.png");
    }

    @Override
    public void collect(Player player) {
        if (!collected && detectCollision(player)) {
            player.restoreHealth(HEAL_AMOUNT);
            markAsCollected();
            // Play sound effect (to be implemented)
        }
    }
}

