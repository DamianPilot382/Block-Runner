package com.pilotcraftmc.blockrunner.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.pilotcraftmc.blockrunner.HUD;

public class Store {
	
	//PRICES
	public static final int HEALTH_P = 5;
	public static final int DESTROY_P = 10;
	public static final int SMALL_P = 5;
	public static final int FAST_P = 5;
	
	public static Rectangle resumeRect = new Rectangle(520,410,105, 35);
	public static Rectangle healthRectangle = new Rectangle(100, 100, 100, 100);
	public static Rectangle destroyRectangle = new Rectangle(200, 200, 100, 100);
	public static Rectangle smallRectangle = new Rectangle(300, 300, 100, 100);
	public static Rectangle fastRectangle = new Rectangle(400, 400, 100, 100);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		this.drawHUD(g, g2d);
		this.health(g, g2d);
		this.destroy(g, g2d);
		this.small(g, g2d);
		
	}
	
	public void drawHUD(Graphics g, Graphics2D g2d){
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 50));
		g.drawString("Store", 250, 50);
		g.setColor(Color.white);
		g2d.draw(resumeRect);
		g.setFont(new Font("arial", Font.ITALIC, 25));
		g.drawString("Resume", resumeRect.x + 7, resumeRect.y + 25);
		g.setFont(new Font("arial", Font.BOLD, 35));
		g.drawString("Coins: " + HUD.coins, 30, 50);
	}
	
	public void health(Graphics g, Graphics2D g2d){
		g.setColor(getColor(HEALTH_P));
		g2d.draw(healthRectangle);
	}
	
	public void destroy(Graphics g, Graphics2D g2d){
		g.setColor(getColor(DESTROY_P));
		g2d.draw(destroyRectangle);
	}
	
	public void small(Graphics g, Graphics2D g2d){
		g.setColor(getColor(SMALL_P));
		g2d.draw(smallRectangle);
	}
	
	public void fast(Graphics g, Graphics2D g2d){
		g.setColor(getColor(FAST_P));
		g2d.draw(smallRectangle);
	}
	
	private Color getColor(int price){
		if(HUD.coins >= price){
			return Color.GREEN;
		}else{
			return Color.RED;
		}
	}

}