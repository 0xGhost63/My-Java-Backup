package model;

/**
 * Enemy that chases the player when they are within detection range.
 */
public class ChaseEnemy extends Enemy {
    private double detectionRange;
    private double chaseSpeed;

    /**
     * Creates a new ChaseEnemy.
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     * @param speed Base movement speed
     * @param chaseSpeed Speed when chasing player
     * @param detectionRange Distance at which enemy detects player
     * @param damage Damage dealt to player
     */
    public ChaseEnemy(double x, double y, double speed, double chaseSpeed, double detectionRange, int damage) {
        super(x, y, 35, 35, speed, damage);
        this.chaseSpeed = chaseSpeed;
        this.detectionRange = detectionRange;
    }

    @Override
    public void update(Player player, double levelWidth, double levelHeight) {
        // Calculate distance to player
        double dx = player.getX() - x;
        double dy = player.getY() - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        // If player is within range, chase them
        if (distance <= detectionRange && distance > 0) {
            // Normalize direction vector
            double moveSpeed = chaseSpeed;
            double moveX = (dx / distance) * moveSpeed;
            double moveY = (dy / distance) * moveSpeed;

            double newX = x + moveX;
            double newY = y + moveY;

            // Check boundaries
            newX = Math.max(0, Math.min(newX, levelWidth - width));
            newY = Math.max(0, Math.min(newY, levelHeight - height));

            setX(newX);
            setY(newY);
        } else {
            // Otherwise, move slowly in a random pattern or stay still
            // For simplicity, just stay in place when not chasing
        }
    }

    /**
     * Gets the detection range.
     * @return Detection range in pixels
     */
    public double getDetectionRange() {
        return detectionRange;
    }

    /**
     * Checks if player is in detection range.
     * @param player The player to check
     * @return true if player is in range
     */
    public boolean isPlayerInRange(Player player) {
        double dx = player.getX() - x;
        double dy = player.getY() - y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance <= detectionRange;
    }
}

