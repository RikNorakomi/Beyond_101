package com.beyond_101_game.entity;

import static com.beyond_101_game.helpers.Variables.DIRECTION;
import static com.beyond_101_game.helpers.Variables.PLAYER_MAXX;
import static com.beyond_101_game.helpers.Variables.PLAYER_MAXY;
import static com.beyond_101_game.helpers.Variables.PLAYER_MINX;
import static com.beyond_101_game.helpers.Variables.PLAYER_MINY;
import static com.beyond_101_game.helpers.Variables.SCROLLTRACKER_X;
import static com.beyond_101_game.helpers.Variables.SCROLLTRACKER_Y;
import static com.beyond_101_game.helpers.Variables.VIEWPORT_HEIGHT;
import static com.beyond_101_game.helpers.Variables.VIEWPORT_WIDTH;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector3;
import com.beyond_101_game.helpers.AssetLoader;

public class Player extends Entity {
	
	public Player(TiledMap map, TiledMapTileLayer layer, OrthographicCamera cam) {
		super(map, layer, cam);
		
		this.moveSpeed = 70; 
		this.sprite = AssetLoader.pDown1;
		this.sideOffset = 2;
		this.topOffset = 6; // adjustment for collisiondetection: gives a slightly "layered" 3d effect
		
		this.width = AssetLoader.pDown1.getRegionWidth();
		this.height = AssetLoader.pDown1.getRegionHeight() - topOffset;

		//System.out.println("player width + height = " + width + " , " + height);
		this.x = VIEWPORT_WIDTH / 2;
		this.y = VIEWPORT_HEIGHT / 2;

		// x = V_WIDTH /2;
		// y = V_HEIGHT /2;

		this.screenCoords = new Vector3();
		this.worldCoords = new Vector3();

		// rectangle = new Rectangle(); // for futre use collision detection with enemies
	}

	public void update(float delta) {
		
		
		handleMovement(delta);
		handleCoordinates();
		super.update(delta);
		
		DIRECTION = 0;
	}
	
	public void render(SpriteBatch sb) {
		super.render(sb);
	}

	public void handleCoordinates() {
		screenCoords.x = x;
		screenCoords.y = y;
		worldCoords.x = x + SCROLLTRACKER_X;
		worldCoords.y = y + SCROLLTRACKER_Y;
	}

	// todo:fix player direction bug
	public void handleMovement(float delta) {
		if ((DIRECTION == 1)) {
			if (y < PLAYER_MAXY)
				y += moveSpeed * delta;
			sprite = AssetLoader.pUp1;

		}
		if ((DIRECTION == 2)) {
			if (x < PLAYER_MAXX)
				x += moveSpeed * delta;
			sprite = AssetLoader.pRight1;

		}
		if ((DIRECTION == 3)) {
			if (y > PLAYER_MINY)
				y -= moveSpeed * delta;
			sprite = AssetLoader.pDown1;

		}
		if ((DIRECTION == 4)) {
			if (x >= PLAYER_MINX)
				x -= moveSpeed * delta;
			sprite = AssetLoader.pLeft1;

		}
	}
}