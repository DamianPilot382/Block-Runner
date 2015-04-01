/**
 * Help Class
 * 
 * Menu that displays help options
 * for the user to understand the game.
 * 
 */

package com.pilotcraftmc.blockrunner.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.pilotcraftmc.blockrunner.Game;

public class Help {
	
	public void render(Graphics g){
		g.setColor(Color.white);
		
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("Help", Game.WIDTH / 2 - 150, 100);
	}
	
}
