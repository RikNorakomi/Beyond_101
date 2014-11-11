package com.beyond_101_game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.beyond_101_game.entity.Player;
import com.beyond_101_game.helpers.AssetLoader;

public class GameRenderer {

	// private GameUpdater updater;

	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;

	private OrthographicCamera cam;
	private SpriteBatch sb;

	private Texture playerImg;

	public GameRenderer(GameUpdater updater,
			OrthogonalTiledMapRenderer mapRenderer, OrthographicCamera cam) {

		// this.updater = updater;
		this.cam = cam;
		this.mapRenderer = mapRenderer;

		playerImg = new Texture("img/player.jpg");
		sb = new SpriteBatch();

	}

	public void render() {
		// System.out.println("rendering");
		Gdx.gl.glClearColor(25f, 25f, 35f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		mapRenderer.setView(cam);
		mapRenderer.render();

		sb.begin();
		sb.draw(playerImg, Player.getX(), Player.getY());
		sb.end();

	}

}
