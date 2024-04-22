package com.sulowskikarol.game.obstacles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.sulowskikarol.game.obstacles.blockage.Blockade;
import com.sulowskikarol.game.obstacles.enemies.Enemy;
import com.sulowskikarol.game.score.ScoreObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ObstacleManager {
    List<Enemy> enemyList;
    List<Blockade> blockadeList;
    List<ScoreObserver> scoreObservers;
    Texture[] obstaclesTextures;


    public static float speedX = 200.0f;

    public ObstacleManager(Texture[] obstaclesTextures) {
        enemyList = new ArrayList<>();
        blockadeList = new ArrayList<>();
        scoreObservers = new ArrayList<>();
        this.obstaclesTextures = obstaclesTextures;
        speedX = 200.0f;
    }

    public void addObserver(ScoreObserver scoreObserver) {
        scoreObservers.add(scoreObserver);
    }

    public void notifyObservers(int points) {
        for (ScoreObserver scoreObserver : scoreObservers) {
            scoreObserver.updateScore(points);
        }
    }

    public void generateObstacle() {
        Obstacle factory = null;
        Random random = new Random();
        int randInt = random.nextInt(4);

        switch (randInt) {
            case 0:
                factory = new StaticObstacle();
                blockadeList.add(factory.createBlockade(obstaclesTextures[0]));
                break;
            case 1:
                factory = new StaticObstacle();
                enemyList.add(factory.createEnemy(obstaclesTextures[1]));
                break;
            case 2:
                factory = new DynamicObstacle();
                blockadeList.add(factory.createBlockade(obstaclesTextures[2]));
                break;
            case 3:
                factory = new DynamicObstacle();
                enemyList.add(factory.createEnemy(obstaclesTextures[3]));
                break;
        }
    }

    public void draw(SpriteBatch batch) {
        for (Blockade blockade : blockadeList) {
            blockade.move();
            blockade.draw(batch, 1);
        }

        for (Enemy enemy : enemyList) {
            enemy.move();
            enemy.draw(batch, 1);
        }
        speedX += 0.1f;
        clearOutdatedObstacles();
    }

    public boolean checkCollision(Rectangle collisionRectangle) {
        for (Blockade blockade : blockadeList) {
            if (blockade.checkCollision(collisionRectangle)) {
                notifyObservers(-10);
                return true;
            }
        }

        for (Enemy enemy : enemyList) {
            if (enemy.checkCollision(collisionRectangle)) {
                enemy.setVisible(false);
                notifyObservers(10);
                return true;
            }
        }
        return false;
    }

    private void clearOutdatedObstacles() {
        Iterator<Blockade> blockadeIterator = blockadeList.iterator();
        while (blockadeIterator.hasNext()) {
            Blockade blockade = blockadeIterator.next();
            if (!blockade.isOnScreen()) {
                blockadeIterator.remove();
            }
        }

        Iterator<Enemy> enemyIterator = enemyList.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();
            if (!enemy.isOnScreen()) {
                if (enemy.isVisible())
                    notifyObservers(-50);
                enemyIterator.remove();
            }
        }
    }
}
