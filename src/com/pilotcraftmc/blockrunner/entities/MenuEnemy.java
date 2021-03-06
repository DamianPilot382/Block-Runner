/**
 * MenuEnemy
 * 
 * Copy of the BasicEnemy,
 * it is used as a decoration
 * inside the Main Menu.
 * 
 * 
 */


package com.pilotcraftmc.blockrunner.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.pilotcraftmc.blockrunner.Game;
import com.pilotcraftmc.blockrunner.Handler;
import com.pilotcraftmc.blockrunner.ID;

public class MenuEnemy extends GameObject{
	
	private Handler handler;
	
	private Random r = new Random();

	public MenuEnemy(int x, int y, ID id, Handler handler) {
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
		
		handler.addObject(new Trail((int)x, (int)y, ID.trail, new Color(r.nextInt(256), 255, r.nextInt(256)), 16, 16, 0.1f, handler));

	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
