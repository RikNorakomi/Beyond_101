package com.beyond_101_game;




import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.beyond_101_game.graphics.GameScreen;
import com.beyond_101_game.helpers.AssetLoader;

public class BeyondGame extends Game {

	GameScreen gameScreen;
	LogoSplashScreen logoSplashScreen;
	
	
	@Override
	public void create() {
		
		 logoSplashScreen = new LogoSplashScreen(this);
		 gameScreen = new GameScreen(this);
		
		Gdx.app.log("Beyond", "Created");
		AssetLoader.load();
		setScreen(logoSplashScreen);
	}
	
	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
		
	}
}
