/**
 * GameObject Abstract Class
 * 
 * Abstract class to create a GameObject,
 * that can interact with other GameObjects
 * inside the game.
 * 
 * 
 */

package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.pilotcraftmc.blockrunner.ID;

public abstract class GameObject {

	protected float x;
	protected float y;
	protected ID id;
	protected float velX;
	protected float velY;

	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public ID getId() {
		return id;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public float getVelX() {
		return velX;
	}

	public float getVelY() {
		return velY;
	}

}
