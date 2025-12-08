package model;

/**
 * Interface for collectible items in the game.
 * Items that implement this interface can be collected by the player.
 */
public interface Collectible {
    /**
     * Called when the item is collected by a player.
     * @param player The player that collected the item
     */
    void collect(Player player);
}

