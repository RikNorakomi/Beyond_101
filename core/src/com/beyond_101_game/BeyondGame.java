package com.beyond_101_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.beyond_101_game.graphics.GameScreen;

public class BeyondGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("Beyond", "Created");
		setScreen(new GameScreen());
	}
}
