package com.sulowskikarol.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.sulowskikarol.game.view.MainMenuScreen;


public class MyGame extends ApplicationAdapter {
	private Screen currentScreen;


	@Override
	public void create () {
		currentScreen = new MainMenuScreen(this);
		currentScreen.show();
	}

	@Override
	public void render () {
		if (currentScreen != null) {
			currentScreen.render(Gdx.graphics.getDeltaTime());
		}
	}
	
	@Override
	public void dispose () {

	}

	public void setScreen(Screen screen) {
		currentScreen = screen;
		currentScreen.show();
	}
}
