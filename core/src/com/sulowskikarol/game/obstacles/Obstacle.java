package com.sulowskikarol.game.obstacles;

import com.badlogic.gdx.graphics.Texture;
import com.sulowskikarol.game.obstacles.blockage.Blockade;
import com.sulowskikarol.game.obstacles.enemies.Enemy;

public interface Obstacle {
    Blockade createBlockade(Texture texture);
    Enemy createEnemy(Texture texture);
}
