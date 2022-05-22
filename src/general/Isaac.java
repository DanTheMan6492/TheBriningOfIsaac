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

import Level.Tile;

public class Isaac extends Entity{
	
	public int shotTimer, shotDelay;
	public Image body;
	private double scle = 2.5;
	public int bodyDir;
	public AffineTransform txBody;
	
	public Isaac(int x, int y) {
		super(x, y);
		w = (int) (28*scle);
		h = (int) (36*scle);
		moveSpeed = 10;
<<<<<<< Updated upstream
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
		direction = "d";
=======
		direction = "f";
>>>>>>> Stashed changes
		bodyDir = 0;
		txBody = AffineTransform.getTranslateInstance(x+scle*4, y+scle*21);
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
		
		if(movingDown){
			direction = "f";
			bodyDir = 0;
			body = getImage("/imgs/Isaac/walkf.gif");
		} else if(movingUp){
			direction = "u";
			bodyDir = 0;
			body = getImage("/imgs/Isaac/walkf.gif");
		} else if(movingLeft){
			direction = "l";
			bodyDir = 2;
			body = getImage("/imgs/Isaac/walkl.gif");
		} else if(movingRight){
			bodyDir = 1;
			direction = "r";
			body = getImage("/imgs/Isaac/walkr.gif");
		} else{
			body = getImage("/imgs/Isaac/stand" + bodyDir + ".gif");
		}

		img = getImage("/imgs/Isaac/head" + direction + ".png");

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

		tx = AffineTransform.getTranslateInstance(x, y);
		txBody = AffineTransform.getTranslateInstance(x+scle*4, y+scle*21);
		tx.scale(scle, scle);
		txBody.scale(scle, scle);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(body, txBody, null);
		g2.drawImage(img, tx, null);
		update();
	}
}