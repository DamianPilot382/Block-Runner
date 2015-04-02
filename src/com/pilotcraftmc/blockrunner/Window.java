package com.pilotcraftmc.blockrunner;

/**
 * Window Class
 * 
 * Generates the main JFrame,
 * that will display the contents of the game.
 * 
 * 
 */
 

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	public JFrame frame;

	private static final long serialVersionUID = 1003642461191986390L;
	
	public Window(int width, int height, String title, Game game){
		
		frame = new JFrame(title + " | " + Game.VERSION);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/blockicon.png")));
	
		frame.add(game);
		frame.setVisible(true);
		game.start();		
	}
	
}
