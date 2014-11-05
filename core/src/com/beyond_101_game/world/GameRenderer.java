package com.beyond_101_game.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.beyond_101_game.helpers.AssetLoader;

public class GameRenderer {

	//private GameUpdater updater;
	
	private OrthographicCamera cam;
	private SpriteBatch batcher;
	
	public GameRenderer(GameUpdater updater) {
		//this.updater = updater;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
	}
	
	public void render() {
		System.out.println("rendering");

        Gdx.gl.glClearColor(25f, 25f, 35f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batcher.begin();
	        for(int x = 0; x < 25; x++) {
	        	for(int y = 0; y < 15; y++) {
		        	batcher.disableBlending();
		        	batcher.draw(AssetLoader.grassTile, x * 32, y * 32, 32, 32);
	        	}
	        }
        batcher.end();
	}
}
