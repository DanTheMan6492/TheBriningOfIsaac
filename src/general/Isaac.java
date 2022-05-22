package general;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;

public class Isaac extends Entity{
	
	public int shotTimer;
	
	public Isaac(int x, int y) {
		super(x, y);
		w = 21;
		h = 30;
		moveSpeed = 10;
	}
	
	public void shoot() {
		if(shotTimer == 0) {
			
		}
	}
	
	public void update() {
		
		x += vx;
		y += vy;
		
		if(movingRight == false && vx > 0) {
			vx --;
		}
		
		if(movingLeft == false && vx < 0) {
			vx ++;
		}
		
		if(movingUp == false && vy < 0) {
			vy ++;
		}
		
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				checkCollision(t);
			}
		}
		
		if(movingDown == false && vy > 0) {
			vy --;
		}
		
		if(shotTimer > 0) {
			shotTimer --;
		}
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g.fillRect(x, y, w, h);
		g.fillRect(x, y, w, h);
		update();
	}
}