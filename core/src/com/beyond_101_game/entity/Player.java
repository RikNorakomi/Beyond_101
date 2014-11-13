package com.beyond_101_game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.beyond_101_game.helpers.AssetLoader;

import static com.beyond_101_game.helpers.Variables.*;

public class Player {

	private TiledMapTileLayer collisionlayer;
	private TiledMap map;

	public static float x;
	public static float y;
	private float movementSpeed = 70;

	private TextureRegion sprite;
	
	public Player(TiledMapTileLayer layer, TiledMap map) {
		this.map = map;
		this.collisionlayer = layer;
		sprite = AssetLoader.pDown1;

		x = Gdx.graphics.getWidth() / 2;
		y = Gdx.graphics.getHeight() / 2;

		
		// rectangle = new Rectangle(); // for futre use collision detection
		// with enemies
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public TextureRegion getSprite() {
		return sprite;
	}

	public void update(float delta) {
		handleMovement(delta);
	}
	
	public void handleMovement(float delta) {
		if ((DIRECTION == 1) && (y <= 380)) {
			y += movementSpeed * delta;
			sprite = AssetLoader.pUp1;
			DIRECTION = 0;
		}
		if ((DIRECTION == 2) && (x <= 650)) {
			x += movementSpeed * delta;
			sprite = AssetLoader.pRight1;
			DIRECTION = 0;
		}
		if ((DIRECTION == 3) && (y > 100)) {
			y -= movementSpeed* delta;
			sprite = AssetLoader.pDown1;
			DIRECTION = 0;
		}
		if ((DIRECTION == 4) && (x >= 150)) {
			x -= movementSpeed* delta;
			sprite = AssetLoader.pLeft1;
			DIRECTION = 0;
		}
	}
}
