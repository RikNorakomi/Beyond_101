package com.beyond_101_game.graphics;

import static com.beyond_101_game.helpers.Variables.DIRECTION;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.beyond_101_game.BeyondGame;
import com.beyond_101_game.entity.Player;
import com.beyond_101_game.world.GameRenderer;
import com.beyond_101_game.world.GameUpdater;

public class GameScreen implements Screen {
	BeyondGame game;

	private GameUpdater updater;
	private GameRenderer renderer;
	
	private Player player;
	
	public static TiledMap map;
	public TiledMapTileLayer tilelayer;
	
	private OrthogonalTiledMapRenderer mapRenderer;
	private OrthographicCamera cam;

	public GameScreen(BeyondGame game) {
		this.game = game;

		Gdx.app.log("Beyond", "Game Screen Atached!");
	}

	@Override
	public void show() {
		createCamera();
		createMap();
		
		tilelayer = (TiledMapTileLayer) map.getLayers().get("Player");
		player = new Player(tilelayer, map);

		updater = new GameUpdater();
		renderer = new GameRenderer(updater, mapRenderer, cam);
	}

	@Override
	public void render(float delta) {
		processKeyboardInput();
		updater.update(delta);
		player.update(delta);
		renderer.render();
	}

	public void processKeyboardInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			DIRECTION = 4;
		} else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			DIRECTION = 3;
		} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			DIRECTION = 2;
		} else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			DIRECTION = 1;
		}
	}

	@Override
	public void resize(int width, int height) {
		// Gdx.app.log("Beyond", "Resizing");
	}

	public void createCamera() {
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
	}

	public void createMap() {
		TmxMapLoader loader = new TmxMapLoader();
		map = loader.load("island_map.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);
	}

	@Override
	public void hide() {
		// Gdx.app.log("Beyond", "HIDE");
	}

	@Override
	public void pause() {
		// Gdx.app.log("Beyond", "PAUSE");
	}

	@Override
	public void resume() {
		// Gdx.app.log("Beyond", "RESUME");
	}

	@Override
	public void dispose() {
		// Gdx.app.log("Beyond", "DISPOSE");
	}
}