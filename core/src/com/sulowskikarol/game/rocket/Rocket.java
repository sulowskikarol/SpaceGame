package com.sulowskikarol.game.rocket;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Rocket implements IRocket {
    private float x, y;
    private float SIZE = 100;
    private Texture texture = new Texture("rocket.png");

    public Rocket() {
        //domyślne położenie rakiety
        this.x = 50;
        this.y = 200;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y, SIZE, SIZE);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSIZE() {
        return SIZE;
    }

    public void dispose() {
        texture.dispose();
    }
}
