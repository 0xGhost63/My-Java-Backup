package model;

/**
 * Coin item that increases the player's score when collected.
 */
public class Coin extends Item {
    private static final int COIN_VALUE = 10;

    /**
     * Creates a new Coin at the specified position.
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     */
    public Coin(double x, double y) {
        super(x, y, 25, 25, "/images/coin.png");
    }

    @Override
    public void collect(Player player) {
        if (!collected && detectCollision(player)) {
            player.addScore(COIN_VALUE);
            markAsCollected();
            // Play sound effect (to be implemented)
        }
    }
}

