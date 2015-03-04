/**
 * Player Class
 * Creates the main character,
 * the user will be able to move with the keys
 * W, A, S, and D.
 * 
 * 
 */
package com.pilotcraftmc.blockrunner.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.pilotcraftmc.blockrunner.Game;
import com.pilotcraftmc.blockrunner.HUD;
import com.pilotcraftmc.blockrunner.Handler;
import com.pilotcraftmc.blockrunner.ID;

public class Player extends GameObject{
	
	Random r = new Random();
	Handler handler;
	
	public static boolean collidesWithHUD = false;
	public static boolean collidesWithStore = false;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 37);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		
		collision();
		
		collidesWithHUD = collidesWithHUD();
		collidesWithStore = collidesWithStore();
	}
	
	private void collision(){
		for (int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){
				if(getBounds().intersects(tempObject.getBounds())){
					//collision code
					HUD.HEALTH -= 2;
				}
			}
			
		}
	}
	
	
	private boolean collidesWithHUD(){

		if(this.x >= HUD.rectangle.x && this.x <= HUD.rectangle.getMaxX() && this.y >= HUD.rectangle.y && this.y <= HUD.rectangle.getMaxY()){
			return true;
		}
		
		return false;
		
	}
	
	private boolean collidesWithStore(){
		if(this.x >= HUD.storeRectangle.x && this.x <= HUD.storeRectangle.getMaxX() && this.y >= HUD.storeRectangle.y && this.y <= HUD.storeRectangle.getMaxY()){
			return true;
		}
		
		return false;
	}
	

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}
	
	
	
	
}
