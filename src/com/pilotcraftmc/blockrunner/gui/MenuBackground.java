package com.pilotcraftmc.blockrunner.gui;

import java.awt.Graphics;
import java.util.Random;

import com.pilotcraftmc.blockrunner.Game;
import com.pilotcraftmc.blockrunner.Handler;
import com.pilotcraftmc.blockrunner.ID;
import com.pilotcraftmc.blockrunner.entities.MenuEnemy;

public class MenuBackground {
	
	private static Handler menuHandler;
	private static Random r = new Random();
	
	public void render(Graphics g, Handler menuHandler){
		MenuBackground.menuHandler = menuHandler;		
	}
	
	public static void addMenu(){
		Game.menuHandler.addObject(new MenuEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.menuEnemy, menuHandler));
	}

}