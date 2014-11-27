package com.beyond_101_game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerAnimation {

	public static Texture playerTextures;
	public static Animation playerDownAnimation, playerUpAnimation,
			playerLeftAnimation, playerRightAnimation;
	public static float stateTime;
	public static SpriteBatch spriteBatch;
	public static TextureRegion currentFrame;

	// Player's width and height
	public static int PLAYER_WIDTH = 14;
	public static int PLAYER_HEIGHT = 19;

	// Multiplier variables for getting each player frame's X Co-ordinate
	// position.
	private static int DOWN_X_MULTIPLIER = 0;
	private static int UP_X_MULTIPLIER = 1;
	private static int LEFT_X_MULTIPLIER = 2;
	private static int RIGHT_X_MULTIPLIER = 3;
	
	// Player animation frame duration.
	public static float PLAYER_FRAME_DURATION = 0.20f;

	public static void load() {
		// Get Player Texture
		playerTextures = new Texture(Gdx.files.internal("entities/player.png"));
		playerTextures.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		// Load player animation for up, down, left, right directions.
		playerDownAnimation = getPlayerAnimation(DOWN_X_MULTIPLIER);
		playerUpAnimation = getPlayerAnimation(UP_X_MULTIPLIER);
		playerLeftAnimation = getPlayerAnimation(LEFT_X_MULTIPLIER);
		playerRightAnimation = getPlayerAnimation(RIGHT_X_MULTIPLIER);

		// Create a new Sprite Batch
		spriteBatch = new SpriteBatch();
		// Set initial state transition time to 0
		stateTime = 0f;
	}

	/**
	 * Load player animation with given TextureRegion
	 * 
	 * @return Animation object.
	 */
	private static Animation getPlayerAnimation(int multiplier) {
		Animation animation = new Animation(PLAYER_FRAME_DURATION, getTextureRegion(multiplier));
		return animation;
	}

	/**
	 * Get TextureRegion for each player frame.
	 * 
	 * @param multiplier
	 *            Multiplier variables for getting each player frame's X
	 *            Co-ordinate position.
	 * @return TextureRegion
	 */
	private static TextureRegion[] getTextureRegion(int multiplier) {
		TextureRegion[] region = new TextureRegion[3];
		// Set texture region of each frame.
		for (int i = 0; i < 3; i++)
			region[i] = new TextureRegion(playerTextures, PLAYER_WIDTH
					* multiplier, PLAYER_HEIGHT * i, PLAYER_WIDTH,
					PLAYER_HEIGHT);

		return region;
	}

	/**
	 * Animate player in up, down, left, right direction.
	 * 
	 * @param animation
	 *            This parameter takes animation object for Up, down, left and
	 *            right direction.<br>
	 *            Use these static animation variables as an argument for
	 *            movement <B>PlayerAnimation.playerDownAnimation,
	 *            PlayerAnimation.playerLeftAnimation,
	 *            PlayerAnimation.playerRightAnimation,
	 *            PlayerAnimation.playerUpAnimation</B>
	 * @param x
	 * @param y
	 */
	public static void animatePlayer(Animation animation, float x, float y) {
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
		spriteBatch.begin();
		spriteBatch.draw(currentFrame, x, y);
		spriteBatch.end();
	}

	public static void dispose() {
		playerTextures.dispose();
	}
}