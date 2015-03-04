package com.pilotcraftmc.blockrunner;

import java.util.Random;

import com.pilotcraftmc.blockrunner.entities.BasicEnemy;
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
		
		if(scoreKeep >= 500){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			hud.addCoins(1);
			
			if(hud.getLevel() == 1){
				handler.addObject(new BasicEnemy(randomLocation(Game.WIDTH - 25), randomLocation(Game.HEIGHT - 25), ID.BasicEnemy, handler));
			}
			if(hud.getLevel() != 3 && hud.getLevel() != 5 && hud.getLevel() != 1){
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
			}
			if(hud.getLevel() == 3){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			}
			
			if(hud.getLevel() == 5){
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