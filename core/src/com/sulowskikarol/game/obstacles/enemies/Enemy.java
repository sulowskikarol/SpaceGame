package com.sulowskikarol.game.obstacles.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import java.awt.*;

public interface Enemy {
    void draw(Batch batch, float parentAlpha);
    void move();
    boolean checkCollision(Rectangle collisionRectangle);
    boolean isOnScreen();
    void setVisible(boolean visible);
    boolean isVisible();
}
