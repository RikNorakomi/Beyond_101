package com.beyond_101_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.beyond_101_game.graphics.GameScreen;
import com.beyond_101_game.helpers.AssetLoader;

public class BeyondGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("Beyond", "Created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
		
	}
}
