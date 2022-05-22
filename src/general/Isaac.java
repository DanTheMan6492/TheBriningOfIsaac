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
	
	public int shotTimer, shotDelay;
	
	public Isaac(int x, int y) {
		super(x, y);
		w = 21;
		h = 30;
		moveSpeed = 10;
		shotDelay = 10;
		direction = "Down";
	}
	
	public void moveRight() {
		if(control) {
			direction = "Right";
			movingRight = true;
			if(vy == 0) {
				vx = moveSpeed;
			}else {
				vx = (int) (moveSpeed / Math.sqrt(2));
				if(vy > 0) {
					vy = (int) (moveSpeed / Math.sqrt(2));
				}else if(vy < 0) {
					vy = (int) (-moveSpeed / Math.sqrt(2));
				}
			}
		}
	}
	
	public void moveLeft() {
		if(control) {
			direction = "Left";
			movingLeft = true;
			if(vy == 0) {
				vx = -moveSpeed;
			}else {
				vx = (int) (-moveSpeed / Math.sqrt(2));
				if(vy > 0) {
					vy = (int) (moveSpeed / Math.sqrt(2));
				}else if(vy < 0) {
					vy = (int) (-moveSpeed / Math.sqrt(2));
				}
			}
		}
	}
	
	public void moveUp() {
		if(control) {
			direction = "Up";
			movingUp = true;
			if(vx == 0) {
				vy = -moveSpeed;
			}else {
				vy = (int) (-moveSpeed / Math.sqrt(2));
				if(vx > 0) {
					vx = (int) (moveSpeed / Math.sqrt(2));
				}else if(vx < 0) {
					vx = (int) (-moveSpeed / Math.sqrt(2));
				}
			}
		}
	}
	
	public void moveDown() {
		if(control) {
			direction = "Down";
			movingDown = true;
			if(vx == 0) {
				vy = moveSpeed;
			}else {
				vy = (int) (moveSpeed / Math.sqrt(2));
				if(vx > 0) {
					vx = (int) (moveSpeed / Math.sqrt(2));
				}else if(vx < 0) {
					vx = (int) (-moveSpeed / Math.sqrt(2));
				}
			}
		}
	}
	
	public void shoot() {
		if(shotTimer == 0) {
			shotTimer = shotDelay;
			switch(direction) {
			case "Right":
				Frame.bubbles.add(new Bubble(x, y, 10, 0));
				break;
							
			case "Left":
				Frame.bubbles.add(new Bubble(x, y, -10, 0));			
				break;
				
			case "Up":
				Frame.bubbles.add(new Bubble(x, y, 0, -10));
				break;
			
			case "Down":
				Frame.bubbles.add(new Bubble(x, y, 0, 10));				
				break;
			}
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
		
		if(movingDown == false && vy > 0) {
			vy --;
		}
		
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				checkCollisionB(t);
			}
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