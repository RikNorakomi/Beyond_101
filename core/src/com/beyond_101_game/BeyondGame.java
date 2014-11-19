package com.beyond_101_game;

import com.badlogic.gdx.Game;
import com.beyond_101_game.graphics.GameScreen;
import com.beyond_101_game.graphics.LogoSplashScreen;
import com.beyond_101_game.helpers.AssetLoader;

public class BeyondGame extends Game {

	private GameScreen gameScreen;
	LogoSplashScreen logoSplashScreen;
	
	AssetLoader assetLoader;
	
	@Override
	public void create() {		
		logoSplashScreen = new LogoSplashScreen(this);
		gameScreen = new GameScreen(this);
		 
		assetLoader = new AssetLoader();
		assetLoader.load();
		
		setScreen(gameScreen);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();	
	}
	
	public GameScreen getGameScreen() {
		return this.gameScreen;
	}
}
