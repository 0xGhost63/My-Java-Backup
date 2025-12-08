package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages game levels, tracks current level, and handles level transitions.
 */
public class LevelManager {
    private int currentLevel;
    private final int totalLevels = 3;
    private Player player;
    private List<Enemy> enemies;
    private List<Item> items;
    private double levelWidth;
    private double levelHeight;
    private double goalX;
    private double goalY;
    private double goalWidth;
    private double goalHeight;
    private boolean keyRequired;
    private boolean keyCollected;

    /**
     * Creates a new LevelManager.
     */
    public LevelManager() {
        this.currentLevel = 1;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
        this.keyRequired = false;
        this.keyCollected = false;
        this.levelWidth = 800;
        this.levelHeight = 600;
    }

    /**
     * Initializes the specified level with enemies, items, and goals.
     * @param level Level number (1-3)
     */
    public void initializeLevel(int level) {
        this.currentLevel = level;
        this.enemies.clear();
        this.items.clear();
        this.keyCollected = false;

        switch (level) {
            case 1:
                initializeLevel1();
                break;
            case 2:
                initializeLevel2();
                break;
            case 3:
                initializeLevel3();
                break;
        }
    }

    /**
     * Initializes Level 1 - Easy difficulty.
     */
    private void initializeLevel1() {
        keyRequired = false;
        levelWidth = 800;
        levelHeight = 600;
        goalX = 750;
        goalY = 280;
        goalWidth = 50;
        goalHeight = 40;

        // Add a few patrol enemies
        enemies.add(new PatrolEnemy(200, 100, 150, 2.0, 10));
        enemies.add(new PatrolEnemy(400, 400, 120, 1.5, 10));

        // Add coins
        items.add(new Coin(150, 150));
        items.add(new Coin(350, 200));
        items.add(new Coin(600, 350));

        // Add health pack
        items.add(new HealthPack(500, 100));
    }

    /**
     * Initializes Level 2 - Medium difficulty.
     */
    private void initializeLevel2() {
        keyRequired = true;
        levelWidth = 1000;
        levelHeight = 700;
        goalX = 950;
        goalY = 330;
        goalWidth = 50;
        goalHeight = 40;

        // Add more enemies with varying types
        enemies.add(new PatrolEnemy(150, 150, 200, 2.5, 15));
        enemies.add(new PatrolEnemy(500, 250, 180, 2.0, 15));
        enemies.add(new ChaseEnemy(300, 400, 1.5, 3.0, 150, 20));
        enemies.add(new PatrolEnemy(700, 150, 150, 2.0, 15));

        // Add items
        items.add(new Coin(200, 200));
        items.add(new Coin(450, 300));
        items.add(new Coin(750, 200));
        items.add(new HealthPack(600, 400));
        
        // Add key
        items.add(new Key(550, 150));
    }

    /**
     * Initializes Level 3 - Hard difficulty.
     */
    private void initializeLevel3() {
        keyRequired = true;
        levelWidth = 1200;
        levelHeight = 800;
        goalX = 1150;
        goalY = 380;
        goalWidth = 50;
        goalHeight = 40;

        // Add many enemies
        enemies.add(new PatrolEnemy(100, 100, 200, 3.0, 20));
        enemies.add(new PatrolEnemy(350, 200, 180, 2.5, 20));
        enemies.add(new ChaseEnemy(500, 350, 2.0, 3.5, 200, 25));
        enemies.add(new ChaseEnemy(200, 500, 2.0, 3.5, 180, 25));
        enemies.add(new PatrolEnemy(700, 300, 200, 2.5, 20));
        enemies.add(new ChaseEnemy(900, 150, 1.8, 3.2, 200, 25));

        // Add items
        items.add(new Coin(250, 250));
        items.add(new Coin(500, 400));
        items.add(new Coin(800, 300));
        items.add(new Coin(1000, 200));
        items.add(new HealthPack(400, 600));
        items.add(new HealthPack(950, 500));
        
        // Add key
        items.add(new Key(650, 250));
    }

    /**
     * Updates all enemies in the current level.
     * @param player The player object
     */
    public void updateEnemies(Player player) {
        for (Enemy enemy : enemies) {
            if (enemy.isActive()) {
                enemy.update(player, levelWidth, levelHeight);
                enemy.checkPlayerCollision(player);
            }
        }
    }

    /**
     * Checks for item collection.
     * @param player The player object
     */
    public void checkItemCollection(Player player) {
        for (Item item : items) {
            if (!item.isCollected() && item.isActive()) {
                if (item instanceof Key) {
                    if (item.detectCollision(player)) {
                        item.collect(player);
                        keyCollected = true;
                    }
                } else {
                    item.collect(player);
                }
            }
        }
    }

    /**
     * Checks if player reached the goal.
     * @param player The player object
     * @return true if player reached goal
     */
    public boolean checkGoalReached(Player player) {
        if (keyRequired && !keyCollected) {
            return false;
        }

        return player.getX() >= goalX && 
               player.getX() <= goalX + goalWidth &&
               player.getY() >= goalY && 
               player.getY() <= goalY + goalHeight;
    }

    /**
     * Checks if player collided with level boundaries.
     * @param player The player object
     */
    public void checkBoundaries(Player player) {
        if (player.getX() < 0) {
            player.setX(0);
        }
        if (player.getX() + player.getWidth() > levelWidth) {
            player.setX(levelWidth - player.getWidth());
        }
        if (player.getY() < 0) {
            player.setY(0);
        }
        if (player.getY() + player.getHeight() > levelHeight) {
            player.setY(levelHeight - player.getHeight());
        }
    }

    /**
     * Advances to the next level.
     * @return true if there is a next level, false otherwise
     */
    public boolean nextLevel() {
        if (currentLevel < totalLevels) {
            currentLevel++;
            return true;
        }
        return false;
    }

    // Getters and Setters
    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getTotalLevels() {
        return totalLevels;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getLevelWidth() {
        return levelWidth;
    }

    public double getLevelHeight() {
        return levelHeight;
    }

    public double getGoalX() {
        return goalX;
    }

    public double getGoalY() {
        return goalY;
    }

    public double getGoalWidth() {
        return goalWidth;
    }

    public double getGoalHeight() {
        return goalHeight;
    }

    public boolean isKeyRequired() {
        return keyRequired;
    }

    public boolean isKeyCollected() {
        return keyCollected;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}

