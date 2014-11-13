package com.beyond_101_game.desktop;
import static com.beyond_101_game.helpers.Variables.*;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.beyond_101_game.BeyondGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.title = "Beyond 101";
			config.width = V_WIDTH;
			config.height = V_HEIGHT;
		new LwjglApplication(new BeyondGame(), config);
	}
}