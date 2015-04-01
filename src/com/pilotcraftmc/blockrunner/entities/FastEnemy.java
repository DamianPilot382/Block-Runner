/**
 * FastEnemy
 * 
 * Second Enemy,
 * will bounce when it reaches the walls and
 * moves at a high speed.
 * 
 * 
 */

package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.pilotcraftmc.blockrunner.Game;
import com.pilotcraftmc.blockrunner.Handler;
import com.pilotcraftmc.blockrunner.ID;

public class FastEnemy extends GameObject{
	
	private Handler handler;
	
	private Random r = new Random();

	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 4;
		velY = 9;
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, ID.trail, new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)), 16, 16, 0.05f, handler));

	}

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
