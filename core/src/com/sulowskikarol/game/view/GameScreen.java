package com.sulowskikarol.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.sulowskikarol.game.MyGame;
import com.sulowskikarol.game.obstacles.ObstacleManager;
import com.sulowskikarol.game.rocket.shooting.BulletManager;
import com.sulowskikarol.game.rocket.Rocket;
import com.sulowskikarol.game.rocket.RocketController;
import com.sulowskikarol.game.score.Score;

public class GameScreen extends ScreenFacade {
    private MyGame game;
    SpriteBatch batch;
    Rocket rocket;
    RocketController controller;
    ObstacleManager obstacleManager;
    BulletManager bulletManager;
    Score score;
    Texture[] obstaclesTextures;
    Texture bulletIMG;
    BitmapFont font;
    float timeLapse;

    public GameScreen(MyGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        rocket = new Rocket();
        controller = new RocketController(rocket);
        obstaclesTextures = new Texture[4];
        obstaclesTextures[0] = new Texture("meteor.png");
        obstaclesTextures[1] = new Texture("alien.jpg");
        obstaclesTextures[2] = new Texture("asteroid.png");
        obstaclesTextures[3] = new Texture("ufo.png");
        bulletIMG = new Texture("bullet.png");
        obstacleManager = new ObstacleManager(obstaclesTextures);
        bulletManager = new BulletManager(bulletIMG);
        score = new Score();
        score.resetTotalScore();
        obstacleManager.addObserver(score);
        font = new BitmapFont();
        timeLapse = 0.0f;
    }

    @Override
    public void render (float delta) {
        ScreenUtils.clear(0.041f, 0.074f, 0.136f, 1);
        timeLapse += delta;
        if (timeLapse >= 1.5f) {
            obstacleManager.generateObstacle();
            timeLapse = 0.0f;
        }

        batch.begin();

        font.getData().setScale(2.0f);
        font.draw(batch, "Total Score: " + Score.getTotalScore(), 425, 480);
        controller.draw(batch);
        obstacleManager.draw(batch);
        bulletManager.draw(batch);
        batch.end();

        bulletManager.checkBullets(obstacleManager);

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            bulletManager.addBullet(controller.getX(), controller.getY(), controller.getSIZE());
        }

        if (obstacleManager.checkCollision(controller.getCollisionRectangle())) {
            game.setScreen(new GameOverScreen(game));
        }
    }

    @Override
    public void dispose () {
        score.resetTotalScore();
        rocket.dispose();
        bulletIMG.dispose();
        for (Texture texture : obstaclesTextures) {
            texture.dispose();
        }
        batch.dispose();
    }
}
