package model;

/**
 * Enemy that patrols back and forth in a horizontal path.
 */
public class PatrolEnemy extends Enemy {
    private double startX;
    private double endX;
    private boolean movingRight;
    private double patrolDistance;

    /**
     * Creates a new PatrolEnemy.
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     * @param patrolDistance Distance to patrol from start position
     * @param speed Movement speed
     * @param damage Damage dealt to player
     */
    public PatrolEnemy(double x, double y, double patrolDistance, double speed, int damage) {
        super(x, y, 35, 35, speed, damage);
        this.startX = x;
        this.patrolDistance = patrolDistance;
        this.endX = x + patrolDistance;
        this.movingRight = true;
    }

    @Override
    public void update(Player player, double levelWidth, double levelHeight) {
        // Patrol back and forth
        if (movingRight) {
            setX(x + speed);
            if (x >= endX) {
                movingRight = false;
            }
        } else {
            setX(x - speed);
            if (x <= startX) {
                movingRight = true;
            }
        }

        // Check boundaries
        if (x < 0) {
            x = 0;
            movingRight = true;
        }
        if (x + width > levelWidth) {
            x = levelWidth - width;
            movingRight = false;
        }
    }

    /**
     * Gets the patrol distance.
     * @return Patrol distance
     */
    public double getPatrolDistance() {
        return patrolDistance;
    }
}

