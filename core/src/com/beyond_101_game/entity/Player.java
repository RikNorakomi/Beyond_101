package com.beyond_101_game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.beyond_101_game.helpers.AssetLoader;

import static com.beyond_101_game.helpers.Variables.*;

public class Player {

	private TiledMapTileLayer collisionlayer;
	private TiledMap map;
	private OrthographicCamera cam;

	public static float x;
	public static float y;
	public static float playerWidth, playerHeight;
	public static float movementSpeed = 70; // needs to be made screen
											// independant to
	private boolean rightTileBlocked, leftTileBLocked, topTileBlocked,
			bottomTileBlocked;
	private TextureRegion sprite;

	private Vector3 screencoordinates, worldcoordinates;

	public Player(TiledMapTileLayer layer, TiledMap map, OrthographicCamera cam) {
		this.map = map;
		this.cam = cam;
		this.collisionlayer = layer;
		sprite = AssetLoader.pDown1;

		playerWidth = AssetLoader.pDown1.getRegionWidth();
		playerHeight = AssetLoader.pDown1.getRegionHeight();

		System.out.println("player width + height = " + playerWidth + " , "
				+ playerHeight);
		x = VIEWPORT_WIDTH / 2;
		y = VIEWPORT_HEIGHT / 2;

		// x = V_WIDTH /2;
		// y = V_HEIGHT /2;

		screencoordinates = new Vector3();
		worldcoordinates = new Vector3();

		// rectangle = new Rectangle(); // for futre use collision detection
		// with enemies
	}

	public void update(float delta) {

		handleMovement(delta);
		handleCoordinates();
		handleMapCollision(delta);

		// reset Direction
		DIRECTION = 0;
	}

	public void handleCoordinates() {
		screencoordinates.x = x;
		screencoordinates.y = y;
		worldcoordinates.x = x + SCROLLTRACKER_X;
		worldcoordinates.y = y + SCROLLTRACKER_Y;

	}

	public Vector3 getWorldcoordinates() {
		return worldcoordinates;
	}

	public Vector3 getScreencoordinates() {
		return screencoordinates;
	}

	public void handleMapCollision(float delta) {
		topTileBlocked = false;
		bottomTileBlocked = false;
		leftTileBLocked = false;
		rightTileBlocked = false;

		if (DIRECTION == 1) // moving up
		{
			if (isCellBLocked(worldcoordinates.x, worldcoordinates.y
					+ playerHeight)
					|| isCellBLocked(worldcoordinates.x + playerWidth,
							worldcoordinates.y + playerHeight)) {
				System.out.println("cellBlockedTop = true in PLayer");

				y -= movementSpeed * delta;
			}
		}
		if (DIRECTION == 2) // moving right
		{
			if (isCellBLocked(worldcoordinates.x + playerWidth,
					worldcoordinates.y)
					|| isCellBLocked(worldcoordinates.x + playerWidth,
							worldcoordinates.y + playerHeight)) {
				System.out.println("cellBlockedright = true in PLayer");

				x -= movementSpeed * delta;
			}
		}

		if (DIRECTION == 3) // moving down
		{
			if (isCellBLocked(worldcoordinates.x, worldcoordinates.y)
					|| isCellBLocked(worldcoordinates.x + playerWidth,
							worldcoordinates.y)) {
				System.out.println("cellBlockedbot = true in PLayer");

				y += movementSpeed * delta;
			}
		}

		if (DIRECTION == 4) // moving left
		{
			if (isCellBLocked(worldcoordinates.x, worldcoordinates.y)
					|| isCellBLocked(worldcoordinates.x,
							worldcoordinates.y + playerHeight)) {
				System.out.println("cellBlockedleft = true in PLayer");
			x += movementSpeed * delta;
		}}

	}

	// todo:fix player direction bug
	public void handleMovement(float delta) {
		if ((DIRECTION == 1)) {
			if (y < PLAYER_MAXY) y += movementSpeed * delta;
			sprite = AssetLoader.pUp1;

		}
		if ((DIRECTION == 2) ) {
			if  (x < PLAYER_MAXX) x += movementSpeed * delta;
			sprite = AssetLoader.pRight1;

		}
		if ((DIRECTION == 3)) {
			if (y > PLAYER_MINY) y -= movementSpeed * delta;
			sprite = AssetLoader.pDown1;

		}
		if ((DIRECTION == 4) ) {
			if (x >= PLAYER_MINX) x -= movementSpeed * delta;
			sprite = AssetLoader.pLeft1;

		}
	}

	public boolean isCellBLocked(float x, float y) {

		Cell cell = collisionlayer.getCell(
				(int) (x / (collisionlayer.getTileWidth())),
				(int) (y / (collisionlayer.getTileHeight())));

		return cell != null && cell.getTile() != null
				&& cell.getTile().getProperties().containsKey("blocked");
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
}
