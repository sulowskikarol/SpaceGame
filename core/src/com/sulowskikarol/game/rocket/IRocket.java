package com.sulowskikarol.game.rocket;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IRocket {
    void draw(SpriteBatch batch);
    float getX();
    void setX(float x);
    float getY();
    void setY(float y);
    float getSIZE();
}