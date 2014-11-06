package com.beyond_101_game.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture tiles;
	public static TextureRegion grassTile;
	public static TextureRegion sandTile;
	
	public static void load() {
		tiles = new Texture(Gdx.files.internal("textures/tiles.png"));
		
		grassTile = new TextureRegion(tiles, 0, 0, 32, 32);
		sandTile = new TextureRegion(tiles, 32, 0, 32, 32);
	}
	
	public static void dispose() {
		tiles.dispose();
	}
}
