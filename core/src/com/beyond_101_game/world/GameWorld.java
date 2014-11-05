package com.beyond_101_game.world;

import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

	private Rectangle rect = new Rectangle(0, 0, 32, 32);
	
	public void update(float delta) {
		System.out.println(delta);
		
		rect.x++;
		if(rect.x > 480) {
			rect.x = 0;
		}
	}
	
	public Rectangle getRect() {
		return rect;
	}
}
