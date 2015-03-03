package com.pilotcraftmc.blockrunner.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.pilotcraftmc.blockrunner.Game;
import com.pilotcraftmc.blockrunner.HUD;
import com.pilotcraftmc.blockrunner.STATE;
import com.pilotcraftmc.blockrunner.gui.Credits;
import com.pilotcraftmc.blockrunner.gui.Menu;
import com.pilotcraftmc.blockrunner.gui.Pause;
import com.pilotcraftmc.blockrunner.gui.Store;

public class MouseInput implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		System.out.println("X: " + mx + ", " + "Y: " + my);

		if (Game.State == STATE.MENU) {

			// PLAY Button
			if (my >= Menu.playButton.y && my <= Menu.playButton.getMaxY()) {
				// Pressed PLAY button
				Game.State = STATE.GAME;
			}

			// CHARACTER button
			if (mx >= Menu.characterButton.x && mx <= Menu.characterButton.getMaxX()) {
				if (my >= Menu.characterButton.y && my <= Menu.characterButton.getMaxY()) {
					// Pressed CHARACTER button
					Game.State = STATE.CHARACTER;
				}
			}

			// HELP button
			if (mx >= Menu.helpButton.x && mx <= Menu.helpButton.getMaxX()) {
				if (my >= Menu.helpButton.y && my <= Menu.helpButton.getMaxY()) {
					// Pressed HELP button
					Game.State = STATE.HELP;
				}
			}

			// CREDITS button
			if (mx >= Menu.creditsButton.x && mx <= Menu.creditsButton.getMaxX()) {
				if (my >= Menu.creditsButton.y && my <= Menu.creditsButton.getMaxY()) {
					// Pressed CREDITS button
					Game.State = STATE.CREDITS;
				}
			}

			// QUIT button
			if (mx >= Menu.quitButton.x && mx <= Menu.quitButton.getMaxX()) {
				if (my >= Menu.quitButton.y && my <= Menu.quitButton.getMaxY()) {
					// Pressed QUIT button
					System.exit(0);
				}
			}

		}
		
		if(Game.State == STATE.GAME){
			// STORE button
			if (mx >= HUD.storeRectangle.x && mx <= HUD.storeRectangle.getMaxX()) {
				if (my >= HUD.storeRectangle.y && my <= HUD.storeRectangle.getMaxY()) {
					// Pressed STORE button
					Game.State = STATE.STORE;
				}
			}
		}

		if (Game.State == STATE.PAUSE) {
			// RESUME button
			if (mx >= Pause.resumeButton.x && mx <= Pause.resumeButton.getMaxX()) {
				if (my >= Pause.resumeButton.y && my <= Pause.resumeButton.getMaxY()) {
					// Pressed RESUME button
					Game.State = STATE.GAME;
				}
			}
		}

		if (Game.State == STATE.STORE) {
			// RESUME button
			if (mx >= Store.resumeRect.x && mx <= Store.resumeRect.getMaxX()) {
				if (my >= Store.resumeRect.y && my <= Store.resumeRect.getMaxY()) {
					// Pressed RESUME button
					Game.State = STATE.GAME;
				}
			}
		}
		
		if(Game.State == STATE.CREDITS){
			//BACK button
			if (mx >= Credits.backButton.x && mx <= Credits.backButton.getMaxX()) {
				if (my >= Credits.backButton.y && my <= Credits.backButton.getMaxY()) {
					// Pressed BACK button
					Game.State = STATE.MENU;
				}
			}
		}

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}