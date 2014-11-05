package com.beyond_101_game.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.beyond_101_game.world.GameRenderer;
import com.beyond_101_game.world.GameUpdater;

public class GameScreen implements Screen {

	private GameUpdater updater;
	private GameRenderer renderer;
	
	public GameScreen() {
		Gdx.app.log("Beyond", "Game Screen Atached!");
		
		updater = new GameUpdater();
		renderer = new GameRenderer(updater);
	}
	
	@Override
	public void render(float delta) {
		updater.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		//Gdx.app.log("Beyond", "Resizing");
	}

	@Override
	public void show() {
		//Gdx.app.log("Beyond", "SHOW");
	}

	@Override
	public void hide() {
		//Gdx.app.log("Beyond", "HIDE");
	}

	@Override
	public void pause() {
		//Gdx.app.log("Beyond", "PAUSE");
	}

	@Override
	public void resume() {
		//Gdx.app.log("Beyond", "RESUME");
	}

	@Override
	public void dispose() {
		//Gdx.app.log("Beyond", "DISPOSE");
	}
}