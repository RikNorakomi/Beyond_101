package com.beyond_101_game.helpers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.beyond_101_game.entity.Player;
import com.beyond_101_game.graphics.GameScreen;

public class InputHandler implements InputProcessor {

	//															//
	// I was Testing if I could Handle the Player Inputs here.	//
	//	    Just some more Testing and it should be Good.		//
	
	//private Player player;
	
	public InputHandler(GameScreen gameScreen, Player player) {
		//this.player = player;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
			case Keys.UP:
				//Move UP
				break;
			case Keys.DOWN:
				//Move DOWN
				break;
			case Keys.RIGHT:
				//Move RIGHT
				break;
			case Keys.LEFT:
				//Move LEFT
				break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
