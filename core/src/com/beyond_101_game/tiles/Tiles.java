package com.beyond_101_game.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tiles {

	public int x, y;
	public TextureRegion texture;
	
	public Tiles(int x, int y, TextureRegion texture) {
		this.x = x;
		this.y = y;
		this.texture = texture;
	}
	
	public Tiles(TextureRegion texture) {
		this(0, 0, texture);
	}
}
