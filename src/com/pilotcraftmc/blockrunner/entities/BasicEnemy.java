/**
 * BasicEnemy
 * 
 * Object for the first basic enemy,
 * this enemy will follow a straight line,
 * bouncing when it reaches the walls of the screen,
 * with a medium speed.
 * 
 * 
 */

package com.pilotcraftmc.blockrunner.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.pilotcraftmc.blockrunner.Game;
import com.pilotcraftmc.blockrunner.Handler;
import com.pilotcraftmc.blockrunner.ID;

public class BasicEnemy extends GameObject{
	
	private Handler handler;
	
	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 5;
		velY = 5;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.trail, Color.orange, 16, 16, 0.1f, handler));

	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
