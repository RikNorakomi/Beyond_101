package com.beyond_101_game.graphics;

import static com.beyond_101_game.helpers.Variables.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.beyond_101_game.BeyondGame;
import com.beyond_101_game.entity.Player;

public class GameScreen implements Screen {
	
	BeyondGame game;
	
	private Player player;
	
	public static TiledMap map;
	public TiledMapTileLayer tilelayer;
	private OrthogonalTiledMapRenderer mapRenderer;
	private OrthographicCamera cam;
	private BitmapFont font;
	private SpriteBatch sb;

	public GameScreen(BeyondGame game) {
		this.game = game;
	}
	
	//Called once when this Becomes the Main Screen of the Game.
	@Override
	public void show() {
		createElements();
		font = new BitmapFont();
			font.setScale(0.8f);
			font.setColor(Color.BLACK);
		
		sb = new SpriteBatch();
		sb.setProjectionMatrix(cam.combined);
		tilelayer = (TiledMapTileLayer) map.getLayers().get("Player");
		player = new Player(tilelayer, map);
		
		//Gdx.input.setInputProcessor(new InputHandler(this, player));
	}

	@Override
	public void render(float delta) {
	//	System.out.println(delta);
		Gdx.gl.glClearColor(25f, 25f, 35f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		keyboardInput();
		renderMap();
		//sb.setProjectionMatrix(cam.combined);
		// if you combine camera players coordinates become world coordinates and not screen coordinates
			sb.begin();
				font.draw(sb, "FPS: " + Gdx.graphics.getFramesPerSecond(), 5, 175);
				font.draw(sb, "Player (x): " + (int)player.getX(), 5, 150);
				font.draw(sb, "Player (y): " + (int)player.getY(), 5, 135);
				sb.draw(player.getSprite(), player.getX(), player.getY());
			sb.end();
		update(delta);
	}
	
	private void update(float delta) {
		player.update(delta);
		cam.update();
	}
	
	private void keyboardInput() {
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			DIRECTION = 4;
		} else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			DIRECTION = 3;
		} else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			DIRECTION = 2;
		} else if(Gdx.input.isKeyPressed(Keys.UP)) {
			DIRECTION = 1;
		} else DIRECTION = 0;
	}
	
	private void renderMap() {
		mapRenderer.setView(cam);
		mapRenderer.render();
		
		
		// ToDO: cam translation should be made be made relative (not absolute)
		// to take care ofdifferent screensizes
		if((player.getX() >= PLAYER_MAXX) && (DIRECTION == 2)) {
			cam.translate(1f, 0);
		}
		if((player.getX() <= PLAYER_MINX) && (DIRECTION == 4)) {
			cam.translate(-1f, 0);
		}
		if((player.getY() >= PLAYER_MAXY) && (DIRECTION == 1)) {
			cam.translate(0, 1f);
		}
		if((player.getY() <= PLAYER_MINY) && (DIRECTION == 3)) {
			cam.translate(0, -1f);
		}
	}
	
	//Creating the Camera and the Map.
	private void createElements() {
		//Camera-
		cam = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		cam.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
	//	cam.position.set(cam.viewportWidth/2, cam.viewportHeight/2,0);
		
		//Map-
		map = new TmxMapLoader().load("island_map.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);
	}
	
	@Override
	public void resize(int width, int height) {
		// Gdx.app.log("Beyond", "Resizing");
	}

	@Override
	public void hide() {
		// Gdx.app.log("Beyond", "HIDE");
	}

	@Override
	public void pause() {
		// Gdx.app.log("Beyond", "PAUSE");
	}

	@Override
	public void resume() {
		// Gdx.app.log("Beyond", "RESUME");
	}

	@Override
	public void dispose() {
		// Gdx.app.log("Beyond", "DISPOSE");
	}
}