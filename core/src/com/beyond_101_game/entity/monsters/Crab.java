package com.beyond_101_game.entity.monsters;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.beyond_101_game.entity.Entity;
import com.beyond_101_game.helpers.AssetLoader;

public class Crab extends Entity {

	public Crab(TiledMap map, TiledMapTileLayer layer, OrthographicCamera cam) {
		super(map, layer, cam);
		
		this.sprite = AssetLoader.crab;
		
		this.x = 60;
		this.y = 60;
		
		this.width = AssetLoader.crab.getRegionWidth();
		this.height = AssetLoader.crab.getRegionHeight();
	}
	
	public void update(float delta) {
		super.update(delta);
		
		if(x < 220)
			this.x++;
	}
	
	public void render(SpriteBatch sb) {
		super.render(sb);
	}
}
