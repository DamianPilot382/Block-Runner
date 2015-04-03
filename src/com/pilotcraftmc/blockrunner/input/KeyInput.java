/**
 * KeyInput Class
 * 
 * Listens to the keys the user types,
 * and allows them to be used in the game.
 * 
 */
package com.pilotcraftmc.blockrunner.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.pilotcraftmc.blockrunner.Game;
import com.pilotcraftmc.blockrunner.HUD;
import com.pilotcraftmc.blockrunner.Handler;
import com.pilotcraftmc.blockrunner.ID;
import com.pilotcraftmc.blockrunner.STATE;
import com.pilotcraftmc.blockrunner.entities.GameObject;
import com.pilotcraftmc.blockrunner.entities.SmartEnemy;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	Random r = new Random();
	
	public KeyInput(Handler handler){
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		if(Game.State == STATE.GAME){
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1
				
				if(key == KeyEvent.VK_W){
					tempObject.setVelY(-5);
					keyDown[0]=true;
				}
				if(key == KeyEvent.VK_S){
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
				if(key == KeyEvent.VK_D){
					tempObject.setVelX(5);
					keyDown[2] = true;
				}
				if(key == KeyEvent.VK_A){
					tempObject.setVelX(-5);
					keyDown[3] = true;
				}
				
				
				if(key == KeyEvent.VK_E){
					Game.State = STATE.GAME;
				}
				
				if(key == KeyEvent.VK_Q){
					Game.State = STATE.PAUSE;
				}
				
			}
		}
		
			if(key == KeyEvent.VK_ESCAPE){
				Game.State = STATE.GAME_OVER;
			}
			
			if(key == KeyEvent.VK_X){
				HUD.coins *= 2;
			}
			
			if(key == KeyEvent.VK_C){
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
			}
			
			if(key == KeyEvent.VK_Z){
				HUD.HEALTH = 100;
			}
		
		}
		
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				//key events for player 1
				
				if(key == KeyEvent.VK_W){
					//tempObject.setVelY(0);
					keyDown[0] = false;
				}
				if(key == KeyEvent.VK_S){
					//tempObject.setVelY(0);
					keyDown[1] = false;
				}
				if(key == KeyEvent.VK_D){
					//tempObject.setVelX(0);
					keyDown[2] = false;
				}
				if(key == KeyEvent.VK_A){
					//tempObject.setVelX(0);
					keyDown[3] = false;
				}
				
				
				//vertical movement
				if(!keyDown[0] && !keyDown[1]){
					tempObject.setVelY(0);
				}
				//horizontal movement
				if(!keyDown[2] && !keyDown[3]){
					tempObject.setVelX(0);
				}

			}
		}
		
	}
	
}