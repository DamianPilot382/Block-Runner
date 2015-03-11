/**
 * Credits Class
 * 
 * Menu that shows the credits for the game.
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.pilotcraftmc.blockrunner.Game;

public class Credits {
	
	public static Rectangle backButton = new Rectangle(550, 400, 75, 40);
				
	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.white);
		
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("Credits", Game.WIDTH / 2 - 100, 60);
		g.setFont(new Font("arial", Font.BOLD, 20));
		g.drawString("Damian Ugalde", 10, 170);
		g.drawString("Pilotcraft Systems", 10, 215);
		g.drawString("Version: BETA 0.1", 10, 260);
		g.drawString("Special Thanks to Mr. Garrett Shorr", 10, 305);
		g2d.draw(backButton);
		g.drawString("Back", backButton.x + 15, backButton.y + 27);

	}
	
}
