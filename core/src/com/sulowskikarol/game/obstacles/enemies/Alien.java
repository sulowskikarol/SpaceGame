package com.sulowskikarol.game.obstacles.enemies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.math.Rectangle;
import com.sulowskikarol.game.obstacles.ObstacleManager;

import java.util.Random;

public class Alien extends Actor implements Enemy {
    Texture texture;
    Rectangle collisionRectangle;
    int SIZE = 65;
    float speedX = ObstacleManager.speedX;

    public Alien(Texture texture) {
        this.texture = texture;

        Random random = new Random();
        int endX = Gdx.graphics.getWidth() - 1 - SIZE;
        int randY = random.nextInt(Gdx.graphics.getHeight() - SIZE);

        this.setBounds(endX, randY, SIZE, SIZE);
        this.collisionRectangle = new Rectangle(endX, randY, SIZE, SIZE);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (isVisible()) {
            super.draw(batch, parentAlpha);
            batch.draw(texture, (int) getX(), (int) getY(), SIZE, SIZE);
        }
    }

    @Override
    public void move() {
        float movedX = getX() - Gdx.graphics.getDeltaTime() * speedX;
        super.setPosition(movedX, getY());
        collisionRectangle.setPosition((int) movedX, (int) getY());
    }

    @Override
    public boolean checkCollision(Rectangle other) {
        return collisionRectangle.overlaps(other) && isVisible();
    }

    @Override
    public boolean isOnScreen() {
        return (getX() > -SIZE);
    }
}
