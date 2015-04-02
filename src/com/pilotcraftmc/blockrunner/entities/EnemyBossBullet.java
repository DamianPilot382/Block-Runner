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
import java.util.Random;

import com.pilotcraftmc.blockrunner.Game;
import com.pilotcraftmc.blockrunner.Handler;
import com.pilotcraftmc.blockrunner.ID;

public class EnemyBossBullet extends GameObject{
	
	private Handler handler;
	
	Random r = new Random();
	
	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
				
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail((int)x, (int)y, ID.trail, Color.red, 16, 16, 0.1f, handler));

	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
