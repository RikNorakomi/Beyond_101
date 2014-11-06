package com.beyond_101_game.world;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.beyond_101_game.helpers.AssetLoader;
import com.beyond_101_game.tiles.Tiles;

public class GameRenderer {

	//private GameUpdater updater;
	
	private OrthographicCamera cam;
	private SpriteBatch batcher;
	
	private Tiles grass;
	private Tiles sand;
	
	private Random random = new Random();
	
	public GameRenderer(GameUpdater updater) {
		//this.updater = updater;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		
		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);
		
		grass = new Tiles(AssetLoader.grassTile);
		sand = new Tiles(AssetLoader.sandTile);
	}
	
	public void render() {
		//System.out.println("rendering");

        Gdx.gl.glClearColor(25f, 25f, 35f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batcher.begin();
        	batcher.disableBlending();
        	
	        for(int x = 0; x < 25; x++) {
	        	for(int y = 0; y < 15; y++) {
	        		if(random.nextInt(2) > 0) {
	        			batcher.draw(grass.texture, x * 32, y * 32, 32, 32);
	        		} else { 
	        			batcher.draw(sand.texture, x * 32, y * 32, 32, 32);
	        		}
	        	}
	        }
	        
        batcher.end();
	}
}
