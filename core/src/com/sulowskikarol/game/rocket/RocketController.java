package com.sulowskikarol.game.rocket;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class RocketController implements IRocket {

    private IRocket rocket;
    private float SPEED = 400;
    private Rectangle collisionRectangle;

    public RocketController(Rocket rocket) {
        this.rocket = rocket;
        this.collisionRectangle = new Rectangle((int) getX(), (int) getY(), (int) getSIZE(), (int) getSIZE());
    }

    public void draw(SpriteBatch batch) {
        float deltaTime = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            setY(getY() + SPEED * deltaTime);
            if (getY() > Gdx.graphics.getHeight() - 1 - getSIZE()) {
                setY(Gdx.graphics.getHeight() - 1 - getSIZE());
            }
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            setY(getY() - SPEED * deltaTime);
            if (getY() < 0.0f) {
                setY(0.0f);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            setX(getX() + SPEED * deltaTime);
            if (getX() > Gdx.graphics.getWidth() - 1 - getSIZE()) {
                setX(Gdx.graphics.getWidth() - 1 - getSIZE());
            }
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            setX(getX() - SPEED * deltaTime);
            if (getX() < 0.0f) {
                setX(0.0f);
            }
        }
        collisionRectangle.setPosition(getX(), getY());
        rocket.draw(batch);
    }

    @Override
    public float getX() {
        return rocket.getX();
    }

    @Override
    public void setX(float x) {
        rocket.setX(x);
    }

    @Override
    public float getY() {
        return rocket.getY();
    }

    @Override
    public void setY(float y) {
        rocket.setY(y);
    }

    @Override
    public float getSIZE() {
        return rocket.getSIZE();
    }

    public Rectangle getCollisionRectangle() {
        return collisionRectangle;
    }
}
