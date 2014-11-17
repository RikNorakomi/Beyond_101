package com.beyond_101_game.graphics;

import static com.beyond_101_game.helpers.Variables.DEBUG;
import static com.beyond_101_game.helpers.Variables.DIRECTION;
import static com.beyond_101_game.helpers.Variables.PLAYER_MAXX;
import static com.beyond_101_game.helpers.Variables.PLAYER_MAXY;
import static com.beyond_101_game.helpers.Variables.PLAYER_MINX;
import static com.beyond_101_game.helpers.Variables.PLAYER_MINY;
import static com.beyond_101_game.helpers.Variables.SCROLLTRACKER_X;
import static com.beyond_101_game.helpers.Variables.SCROLLTRACKER_Y;
import static com.beyond_101_game.helpers.Variables.STARTOFFSET_X;
import static com.beyond_101_game.helpers.Variables.STARTOFFSET_Y;
import static com.beyond_101_game.helpers.Variables.VIEWPORT_HEIGHT;
import static com.beyond_101_game.helpers.Variables.VIEWPORT_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.beyond_101_game.BeyondGame;
import com.beyond_101_game.entity.Player;

public class GameScreencopy implements Screen {

	BeyondGame game;

	private Player player;

	public static TiledMap map;
	public TiledMapTileLayer tilelayer;
	private OrthogonalTiledMapRenderer mapRenderer;
	private OrthographicCamera cam;
	private BitmapFont font;
	private SpriteBatch sb;
<<<<<<< HEAD
	//private int camScrollSpeed =80;
	
	
	
=======
	private int camScrollSpeed = 80;

>>>>>>> origin/master
	Viewport viewport;

	public GameScreen(BeyondGame game) {
		this.game = game;
	}

	// Called once when this Becomes the Main Screen of the Game.
	@Override
	public void show() {
		DEBUG = true;
		createElements();
		font = new BitmapFont();
			font.setScale(0.5f);
			font.setColor(Color.BLACK);

		sb = new SpriteBatch();
			sb.setProjectionMatrix(cam.combined);
		tilelayer = (TiledMapTileLayer) map.getLayers().get("Ground");
		player = new Player(tilelayer, map, cam);

		// Gdx.input.setInputProcessor(new InputHandler(this, player));
	}

	@Override
	public void render(float delta) {
		// System.out.println(delta);
		Gdx.gl.glClearColor(25f, 25f, 35f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		keyboardInput();
		renderMap(delta);
		// sb.setProjectionMatrix(cam.combined);
		// if you combine camera players coordinates become world coordinates
		// and not screen coordinates
		sb.begin();
			if (DEBUG) showDebugInfo();
			sb.draw(player.getSprite(), player.getX(), player.getY());
		sb.end();
		
		update(delta);
	}

	private void update(float delta) {
		player.update(delta);
		cam.update();
	}

	public void showDebugInfo() {
		// System.out.println("test");
		font.draw(sb, "F9 = Debug HUD ON/OFF ", 5, 235);
		font.draw(sb, "FPS: " + Gdx.graphics.getFramesPerSecond(), 5, 215);
		font.draw(sb, "Player Screen(x): " + (int) player.getScreencoordinates().x, 5, 195);
		font.draw(sb, "Player Screen(y): " + (int) player.getScreencoordinates().y, 5, 185);
		font.draw(sb, "Player World(x): " + (int) player.getWorldcoordinates().x, 5, 170);
		font.draw(sb, "Player World(y): " + (int) player.getWorldcoordinates().y, 5, 160);
		font.draw(sb, " Scroll Tracker x/y: " + (int) SCROLLTRACKER_X + " , " + (int) SCROLLTRACKER_Y, 5, 140);
		TiledMapTileLayer.Cell cell = tilelayer.getCell
			((int) player.getWorldcoordinates().x / (int) tilelayer.getTileWidth(),
			(int) player.getWorldcoordinates().y / (int) tilelayer.getTileHeight());
		font.draw(sb, "Player on Tile ID#: " + cell.getTile().getId(), 5, 130);
	}

	private void keyboardInput() {
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			DIRECTION = 4;
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			DIRECTION = 3;
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			DIRECTION = 2;
		} else if (Gdx.input.isKeyPressed(Keys.UP)) {
			DIRECTION = 1;
		} else
			DIRECTION = 0;

		if (Gdx.input.isKeyJustPressed(Keys.F9)) {
			if (DEBUG) {
				DEBUG = false;
			} else
				DEBUG = true;
		}
	}

	private void renderMap(float delta) {
		// ToDO: cam translation should be made be made relative (not absolute)
		// to take care ofdifferent screensizes
		// Todo: probably add delta multiplication to preven jitter in
		// cam.translate
		
		if ((player.getX() >= PLAYER_MAXX) && (DIRECTION == 2)) {
			cam.translate(Player.movementSpeed * delta, 0);
			SCROLLTRACKER_X += Player.movementSpeed * delta;
		}
		if ((player.getX() <= PLAYER_MINX) && (DIRECTION == 4)) {
			cam.translate(-Player.movementSpeed * delta, 0);
			SCROLLTRACKER_X -= Player.movementSpeed * delta;
		}
		if ((player.getY() >= PLAYER_MAXY) && (DIRECTION == 1)) {
			cam.translate(0, Player.movementSpeed * delta);
			SCROLLTRACKER_Y += Player.movementSpeed * delta;
		}
		if ((player.getY() <= PLAYER_MINY) && (DIRECTION == 3)) {
			cam.translate(0, -Player.movementSpeed * delta);
			SCROLLTRACKER_Y -= Player.movementSpeed * delta;
		}

		mapRenderer.setView(cam);
		mapRenderer.render();
	}

	// Creating the Camera and the Map.
	private void createElements() {
		// Camera-
		// cam = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		// cam.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		// cam.position.set(cam.viewportWidth, cam.viewportHeight,0);

		cam = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		cam.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);

		// set starting position player
<<<<<<< HEAD
				STARTOFFSET_X = VIEWPORT_WIDTH/2;
				STARTOFFSET_Y = VIEWPORT_HEIGHT/2;
		
		// VIEWPORT DIMENSIONS / 2 sets camera origin to match map origin (0,0 coordinate)
		// STARTOFFSET_X / Y determine actual starting position on map from origin
		cam.position.set(VIEWPORT_WIDTH/2 + STARTOFFSET_X , VIEWPORT_HEIGHT/2 + STARTOFFSET_Y ,0);
		
		
		
		// set starting variables for scrolltrackers
=======
		STARTOFFSET_X = VIEWPORT_WIDTH / 2;
		STARTOFFSET_Y = VIEWPORT_HEIGHT / 2;

		// VIEWPORT DIMENSIONS / 2 sets camera origin to match map origin (0,0
		// coordinate)
		// STARTOFFSET_X / Y determine actual starting position on map from
		// origin
		cam.position.set(VIEWPORT_WIDTH / 2 + STARTOFFSET_X, VIEWPORT_HEIGHT / 2 + STARTOFFSET_Y, 0);

		// sets stating variables for scrolltracker
>>>>>>> origin/master
		SCROLLTRACKER_X += STARTOFFSET_X;
		SCROLLTRACKER_Y += STARTOFFSET_Y;

		// Map-
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