package com.sulowskikarol.game.rocket.shooting;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bullet extends Actor {
    Texture texture;
    Rectangle collisionRectangle;
    int sizeX = 20, sizeY = 10;
    float speed = 600;

    public Bullet(Texture texture, float x, float y) {
        this.texture = texture;
        this.setBounds(x, y, sizeX, sizeY);
        this.collisionRectangle = new Rectangle(x, y, sizeX, sizeY);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, (int) getX(), (int) getY(), sizeX, sizeY);
    }

    public void move() {
        float movedX = getX() + Gdx.graphics.getDeltaTime() * speed;
        super.setPosition(movedX, getY());
        collisionRectangle.setPosition((int) movedX, (int) getY());
    }

    public boolean isOnScreen() {
        return (getX() + sizeX < Gdx.graphics.getWidth() && isVisible());
    }
}
