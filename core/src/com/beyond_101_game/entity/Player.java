package com.beyond_101_game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static com.beyond_101_game.helpers.Variables.*;

public class Player {

	private TiledMapTileLayer collisionlayer;
	private TiledMap map;

	private int width;
	private int height;
	private Vector2 position;

	public static float x;
	public static float y;

	private float movementSpeed = 1;

	public Player(TiledMapTileLayer layer, TiledMap map) {
		this.map = map;
		this.collisionlayer = layer;

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

	public void update(float delta) {
		handleMovement();
	}
	
	public void handleMovement() {
		if ((DIRECTION == 1) && (y <= 380)) {
			y += movementSpeed;
			DIRECTION = 0;
		}
		if ((DIRECTION == 2) && (x <= 650)) {
			x += movementSpeed;
			DIRECTION = 0;
		}
		if ((DIRECTION == 3) && (y > 100)) {
			y -= movementSpeed;
			DIRECTION = 0;
		}
		if ((DIRECTION == 4) && (x >= 150)) {
			x -= movementSpeed;
			DIRECTION = 0;
		}
	}
}
