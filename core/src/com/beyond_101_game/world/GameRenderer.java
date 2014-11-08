package com.beyond_101_game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameRenderer {

	//private GameUpdater updater;
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;
	
	private OrthographicCamera cam;
	
	public GameRenderer(GameUpdater updater) {
		//this.updater = updater;
		
		TmxMapLoader loader = new TmxMapLoader();
		map = loader.load("Test.tmx");
		
		mapRenderer = new OrthogonalTiledMapRenderer(map);
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
	}
	
	public void render() {
		//System.out.println("rendering");
        Gdx.gl.glClearColor(25f, 25f, 35f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        mapRenderer.setView(cam);
        mapRenderer.render();
	}
}
