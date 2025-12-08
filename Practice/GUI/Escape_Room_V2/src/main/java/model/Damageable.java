package model;

/**
 * Interface for objects that can take damage.
 */
public interface Damageable {
    /**
     * Applies damage to the object.
     * @param amount The amount of damage to apply
     */
    void takeDamage(int amount);
}

