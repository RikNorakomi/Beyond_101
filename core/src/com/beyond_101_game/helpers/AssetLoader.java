package com.beyond_101_game.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	
	public static Texture playerTextures;
	public static Animation playerAnimation;
	public static TextureRegion pDown1, pDown2, pDown3,
								pUp1, pUp2, pUp3,
								pLeft1, pLeft2, pLeft3,
								pRight1, pRight2, pRight3;
	
	public static Texture enemies;
	public static TextureRegion crab;
	
	public void load() {
		playerTextures = new Texture(Gdx.files.internal("entities/player.png"));
			playerTextures.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
			
		enemies = new Texture(Gdx.files.internal("entities/crab.png"));
			enemies.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
			
		pDown1 = new TextureRegion(playerTextures, 0, 0, 14, 19);
			pDown2 = new TextureRegion(playerTextures, 0, 19, 14, 19);
			pDown3 = new TextureRegion(playerTextures, 0, 38, 14, 19);
		pUp1 = new TextureRegion(playerTextures, 14, 0, 14, 19);
		pLeft1 = new TextureRegion(playerTextures, 28, 0, 14, 19);
		pRight1 = new TextureRegion(playerTextures, 42, 0, 14, 19);
		
		TextureRegion[] playerDown = { pDown1, pDown2, pDown3 };
			playerAnimation = new Animation(0.06f, playerDown); 
			
		crab = new TextureRegion(enemies, 0, 0, 16, 16);
	}
	
	public static void dispose() {
		playerTextures.dispose();
		enemies.dispose();
	}
}
