package com.pilotcraftmc.blockrunner;

/**
 * Spawn Class
 * 
 * Creates the enemies in each level,
 * updates the level and coins variables in HUD Class,
 * and checks the player's health.
 * 
 */

 

import java.util.Random;

import com.pilotcraftmc.blockrunner.entities.BasicEnemy;
import com.pilotcraftmc.blockrunner.entities.EnemyBoss;
import com.pilotcraftmc.blockrunner.entities.FastEnemy;
import com.pilotcraftmc.blockrunner.entities.SmartEnemy;


public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public static int scoreKeep = 0;
	
	public Spawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick(){		
		scoreKeep++;
		
		if(scoreKeep >= 400){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			hud.addCoins(1);
			
			if(hud.getLevel() == 2){
				handler.addObject(new BasicEnemy(randomLocation(Game.WIDTH - 25), randomLocation(Game.HEIGHT - 25), ID.BasicEnemy, handler));
			}
			if(hud.getLevel() != 3 && hud.getLevel() != 5 && hud.getLevel() != 1 && hud.getLevel() != 2 && hud.getLevel() != 10 && hud.getLevel() != 11 && hud.getLevel() != 12){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			if(hud.getLevel() == 3){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			}
			if(hud.getLevel() == 5){
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
			}
			if(hud.getLevel() == 10){
				handler.clearEnemies();
				handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler));
			}
			if(hud.getLevel() == 13){
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(randomLocation(Game.WIDTH - 25), randomLocation(Game.HEIGHT - 25), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(randomLocation(Game.WIDTH - 25), randomLocation(Game.HEIGHT - 25), ID.BasicEnemy, handler));
				handler.addObject(new BasicEnemy(randomLocation(Game.WIDTH - 25), randomLocation(Game.HEIGHT - 25), ID.BasicEnemy, handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));

			}
			
		}
		
		
	}
	
	private int randomLocation(int max){
		int s = r.nextInt(max);
		s = s + r.nextInt(max);
		s /= 2;
		return s;
	}
	
	
}