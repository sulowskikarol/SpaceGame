package com.sulowskikarol.game.obstacles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.sulowskikarol.game.obstacles.blockage.Asteroid;
import com.sulowskikarol.game.obstacles.blockage.Blockade;
import com.sulowskikarol.game.obstacles.enemies.Enemy;
import com.sulowskikarol.game.obstacles.enemies.UFO;

public class DynamicObstacle implements Obstacle  {
    @Override
    public Blockade createBlockade(Texture texture) {
        return new Asteroid(texture);
    }

    @Override
    public Enemy createEnemy(Texture texture) {
        return new UFO(texture);
    }
}
