package model;

/**
 * Abstract base class for all enemy types.
 * Provides common enemy functionality.
 */
public abstract class Enemy extends GameObject implements Damageable {
    protected double speed;
    protected int damage;

    /**
     * Creates a new Enemy at the specified position.
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     * @param width Width of the enemy
     * @param height Height of the enemy
     * @param speed Movement speed
     * @param damage Damage dealt to player on collision
     */
    public Enemy(double x, double y, double width, double height, double speed, int damage) {
        super(x, y, width, height, "/images/enemy.png");
        this.speed = speed;
        this.damage = damage;
    }

    /**
     * Updates the enemy's position and behavior.
     * Must be implemented by subclasses.
     * @param player The player object to interact with
     * @param levelWidth Width of the level for boundary checking
     * @param levelHeight Height of the level for boundary checking
     */
    public abstract void update(Player player, double levelWidth, double levelHeight);

    /**
     * Gets the damage this enemy deals.
     * @return Damage amount
     */
    public int getDamage() {
        return damage;
    }

    @Override
    public void takeDamage(int amount) {
        // Enemies can be damaged in future implementations
        setActive(false);
    }

    /**
     * Checks collision with player and applies damage.
     * @param player The player to check collision with
     * @return true if collision occurred
     */
    public boolean checkPlayerCollision(Player player) {
        if (detectCollision(player)) {
            player.takeDamage(damage);
            return true;
        }
        return false;
    }
}

