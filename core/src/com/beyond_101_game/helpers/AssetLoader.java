package com.beyond_101_game.helpers;

import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
	
	public Texture player;
	
	public void load() {
		 player = new Texture("img/player.png");	
	}
	
	public static void dispose() {
		
	}
}
