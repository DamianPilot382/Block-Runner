package com.pilotcraftmc.blockrunner;

 

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.pilotcraftmc.blockrunner.entities.Player;

//HEADS-UP DISPLAY
public class HUD {
	
	//Health of the Player
	public static int HEALTH = 100;
	
	//Value for the green color in the player's health bar.
	public static int greenValue = 255;
	
	//Counters for the player
	public static int score = 0;
	public static int level = 1;
	public static int coins = 1;
	
	//PAUSE BUTTON
	public static Rectangle rectangle = new Rectangle(0,0, 220, 105);
	//STORE BUTTON
	public static Rectangle storeRectangle = new Rectangle(8, 398, 100, 50);
	
	//TICK Method
	public void tick(){
		
		HEALTH = (int) Game.clamp((float)HEALTH, (float)0, (float)100);
		greenValue = (int) Game.clamp((float)greenValue, (float)0, (float)1);
		
		greenValue = HEALTH * 2;
		
		score++;
		
		if(HEALTH <= 0){
			Game.State = STATE.GAME_OVER;
		}
		
	}
	
	public void render(Graphics g){
		if(Player.collidesWithHUD){
			g.setColor(new Color((float)1, (float)1, (float)1, (float).5));
			this.drawHUD(g);
			g.setColor(Color.white);
			this.drawStore(g);
		}else if(Player.collidesWithStore){
			g.setColor(new Color((float)1, (float)1, (float)1, (float).5));
			this.drawStore(g);
			g.setColor(Color.white);
			this.drawHUD(g);
		}else{
			g.setColor(Color.white);
			this.drawHUD(g);
			this.drawStore(g);
		}
			
	}
	
	private void drawHUD(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setFont(new Font("arial", Font.BOLD, 15));
		g.drawString("Score: " + (int)score, 15, 64);
		g.drawString("Level: " + (int)level, 15, 80);
		g.drawString("Coins: " + (int)coins, 15, 97);
		g2d.draw(rectangle);
		g.drawRect(14, 14, 201, 33);
		
		
		if(Player.collidesWithHUD){ g.setColor(new Color((float)1, (float)0, (float)0, (float).5)); }else{ g.setColor(Color.red); }
		g.fillRect(15, 15, 200, 32);
		
		if(Player.collidesWithHUD){ g.setColor(new Color((float).25, (float) Game.clamp((float)greenValue, (float)0, (float)1), (float)0, (float).5)); } else{ g.setColor(new Color(75, greenValue, 0)); }

		
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.white);
	}
	
	private void drawStore(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.draw(storeRectangle);
		g.setFont(new Font("arial", Font.BOLD, 30));
		g.drawString("Store", (int)storeRectangle.getX() + 10, (int)storeRectangle.getY() + 35);
	}
	
	
	@SuppressWarnings("static-access")
	public void score(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLevel(){
		return level;
	}
	
	@SuppressWarnings("static-access")
	public void setLevel(int level){
		this.level = level;
	}
	
	@SuppressWarnings("static-access")
	public int getCoins(){
		return this.coins;
	}
	
	@SuppressWarnings("static-access")
	public void addCoins(int val){
		this.coins = this.coins + val;
	}
}
