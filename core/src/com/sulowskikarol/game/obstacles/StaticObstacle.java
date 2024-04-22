package com.sulowskikarol.game.obstacles;

import com.badlogic.gdx.graphics.Texture;
import com.sulowskikarol.game.obstacles.blockage.Blockade;
import com.sulowskikarol.game.obstacles.blockage.Meteor;
import com.sulowskikarol.game.obstacles.enemies.Alien;
import com.sulowskikarol.game.obstacles.enemies.Enemy;

public class StaticObstacle implements Obstacle {
    @Override
    public Blockade createBlockade(Texture texture) {
        return new Meteor(texture);
    }

    @Override
    public Enemy createEnemy(Texture texture) {
        return new Alien(texture);
    }
}
