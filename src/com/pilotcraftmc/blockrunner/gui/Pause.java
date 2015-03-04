/**
 * Pause Menu
 * 
 * This menu appears during the game
 * to allow the user to pause the game.
 * 
 */
package com.pilotcraftmc.blockrunner.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.pilotcraftmc.blockrunner.Game;

public class Pause {
	
	public static Rectangle resumeButton = new Rectangle(210, 225, 200, 75);
	
	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.setColor(Color.white);
		g.drawString("Paused", Game.WIDTH /2 - 100, 75);
		
		g.setColor(Color.white);
		g2d.draw(resumeButton);
		g.setFont(new Font("arial", Font.BOLD, 40));
		g.drawString("Resume", (int)resumeButton.getX() + 23, (int)resumeButton.getY() + 50);
		
	}
	
}
