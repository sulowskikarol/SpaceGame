package com.sulowskikarol.game.rocket.shooting;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sulowskikarol.game.obstacles.ObstacleManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BulletManager {
    List<Bullet> bulletList;
    Texture texture;

    public BulletManager(Texture texture) {
        this.texture = texture;
        bulletList = new ArrayList<>();
    }

    public void addBullet(float x, float y, float size) {
        bulletList.add(new Bullet(texture, x + size, y + size/2 - 5));
    }

    public void checkBullets(ObstacleManager obstacleManager) {
        Iterator<Bullet> iterator = bulletList.iterator();
        while(iterator.hasNext()) {
            Bullet bullet = iterator.next();
            if (!bullet.isOnScreen()) {
                iterator.remove();
            }
        }

        for (Bullet bullet : bulletList) {
            if(obstacleManager.checkCollision(bullet.collisionRectangle)) {
                bullet.setVisible(false);
            }
        }
    }

    public void draw(SpriteBatch batch) {
        for (Bullet bullet : bulletList) {
            bullet.move();
            bullet.draw(batch, 1);
        }
    }
}
