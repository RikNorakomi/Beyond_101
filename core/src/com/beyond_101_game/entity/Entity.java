package com.beyond_101_game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;

public abstract class Entity {

	protected int width, height;
	
	protected int x, y, xDest, yDest;
	protected int xTile, yTile;
	
	protected boolean moving;
	protected boolean up, right, down, left;
	protected int moveSpeed;
	
	protected TiledMap tileMap;
	protected int xMap, yMap;
	
	public Entity(TiledMap tileMap) {
		this.tileMap = tileMap;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getXTile() { return xTile; }
	public int getYTile() { return yTile; }
	
	public void setPosition(int xX, int yY) {
		x = xX;
		y = yY;
		xDest = x;
		yDest = y;
	}
	
	public void update() {
		
	}
	
	public void draw(SpriteBatch sb) {
		//Draw Stuff.
	}
}
