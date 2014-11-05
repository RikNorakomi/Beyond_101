package com.beyond_101_game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.beyond_101_game.BeyondGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.title = "Beyond 101";
			config.width = 800;
			config.height = 480;
		new LwjglApplication(new BeyondGame(), config);
	}
}