/**
 * Character Class
 * 
 * Generates a menu that allows you to change
 * your player's color, name, and look at the acievements.
 * 
 */

package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.pilotcraftmc.blockrunner.Game;

public class Character {
	
	public static String playerName;
	
	public void render(Graphics g){
		g.setColor(Color.white);
		
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("Character", Game.WIDTH / 2 - 130, 75);
		
		
	}
	
}
