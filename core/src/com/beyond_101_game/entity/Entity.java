package com.beyond_101_game.entity;

import static com.beyond_101_game.helpers.Variables.DIRECTION;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector3;

public abstract class Entity {
	
	public float x, y;
	public float width, height;
	public float topOffset, sideOffset;
	
	public float moveSpeed;
	public TextureRegion sprite;
	
	public Vector3 screenCoords, worldCoords;
	
	public TiledMapTileLayer collisionLayer;
	public TiledMap map;
	public OrthographicCamera cam;
	
	public Entity(TiledMap map, TiledMapTileLayer layer, OrthographicCamera cam) {
		this.map = map;
		this.collisionLayer = layer;
		this.cam = cam;
	}
	
	public void update(float delta) {
		handleMapCollision(delta);
	}
	
	public void render(SpriteBatch sb) {
		sb.draw(this.sprite, this.x, this.y);
	}
	
	public void handleMapCollision(float delta) {
		if (DIRECTION == 1) // moving up
		{
			if (isCellBLocked(worldCoords.x + sideOffset, worldCoords.y
					+ height)
					|| isCellBLocked(worldCoords.x + width - sideOffset,
							worldCoords.y + height)) {
				System.out.println("cellBlockedTop = true in PLayer");

				y -= moveSpeed * delta;
			}
		}
		if (DIRECTION == 2) // moving right
		{
			if (isCellBLocked(worldCoords.x + width,
					worldCoords.y)
					|| isCellBLocked(worldCoords.x + width,
							worldCoords.y + height)) {
				System.out.println("cellBlockedright = true in PLayer");

				x -= moveSpeed * delta;
			}
		}

		if (DIRECTION == 3) // moving down
		{
			if (isCellBLocked(worldCoords.x + sideOffset, worldCoords.y)
					|| isCellBLocked(worldCoords.x + width - sideOffset,
							worldCoords.y)) {
				System.out.println("cellBlockedbot = true in PLayer");

				y += moveSpeed * delta;
			}
		}

		if (DIRECTION == 4) // moving left
		{
			if (isCellBLocked(worldCoords.x, worldCoords.y)
					|| isCellBLocked(worldCoords.x, worldCoords.y
							+ height)) {
				System.out.println("cellBlockedleft = true in PLayer");
				x += moveSpeed * delta;
			}
		}
	}
	
	public boolean isCellBLocked(float x, float y) {

		Cell cell = collisionLayer.getCell(
			(int) (x / (collisionLayer.getTileWidth())),
			(int) (y / (collisionLayer.getTileHeight())));

		return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey("blocked");
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
	
	public Vector3 getScreenCoords() {
		return screenCoords;
	}
	
	public Vector3 getWorldCoords() {
		return worldCoords;
	}
}