package com.sulowskikarol.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sulowskikarol.game.MyGame;

public class MainMenuScreen extends ScreenFacade {
    private MyGame game;
    private BitmapFont font;
    private SpriteBatch batch;
    private Texture background;

    public MainMenuScreen(MyGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        batch = new SpriteBatch();
        font = new BitmapFont();
        background = new Texture("background.jpg");
        font.getData().setScale(3f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0);
        font.getData().setScale(3f);
        font.draw(batch,"Space Game", 370, 380);
        font.getData().setScale(2f);
        font.draw(batch, "Press ENTER to play...", 350, 50);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
        }
    }

    @Override
    public void dispose() {
        font.dispose();
        batch.dispose();
        background.dispose();
    }
}
