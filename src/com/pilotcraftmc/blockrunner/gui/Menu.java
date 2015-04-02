/**
 * Menu Class
 * 
 * Shows the Main Menu, that allow the user
 * select other menus or play the game.
 */

package com.pilotcraftmc.blockrunner.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;
import com.pilotcraftmc.blockrunner.Game;

public class Menu {
		
	public static Rectangle playButton = new Rectangle(0, 245, Game.WIDTH - 7, 20);
	public static Rectangle characterButton = new Rectangle(0, 285, Game.WIDTH - 7, 20);
	public static Rectangle helpButton = new Rectangle(0, 325, Game.WIDTH - 7, 20);
	public static Rectangle creditsButton = new Rectangle(0, 364, Game.WIDTH - 7, 20);
	public static Rectangle quitButton = new Rectangle(0, 405, Game.WIDTH - 7, 20);
	
	
	Random r = new Random();
	
		
	public void render(Graphics g){
		
		Image blockLogo = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/blocklogo.png"));
		Image pcsLogo = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/pcslogo.png"));
		
		g.drawImage(blockLogo, Game.WIDTH / 2 - 150, 5, 300, 150, null);
		g.drawImage(pcsLogo, 450, 140, 175, 100, null);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.white);
								
		g.setColor(Color.white);
		g.setFont(new Font("verdana", Font.BOLD, 15));
		g.drawString("Play", 15, 260);
		g.drawString("Character", 15, 300);
		g.drawString("Help", 15, 340);
		g.drawString("Credits", 15, 380);
		g.drawString("Quit", 15, 420);
		g.setFont(new Font("arial", Font.ITALIC, 15));
		g.drawString("Version: " + Game.VERSION, 500, 445);	
		
		g2d.draw(playButton);
		g2d.draw(characterButton);
		g2d.draw(helpButton);
		g2d.draw(creditsButton);
		g2d.draw(quitButton);
		
	}
	
}