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

public class Turtle extends Enemy{
	
	public int randomTimer, moveTimer;
	public boolean invincible;
	
	public Turtle(int x, int y) {
		super(x, y);
		health = 30;
		w = 31;
		h = 21;
		control = true;
		moveSpeed = 1;
	}
	
	public void stopMoveRight() {
		if(control == true) {
			movingRight = false;
		}
	}
	
	public void stopMoveLeft() {
		if(control == true) {
			movingLeft = false;
		}	
	}
	
	public void stopMoveUp() {
		if(control == true) {
			movingUp = false;
		}
	}
	
	public void stopMoveDown() {
		if(control == true) {
			movingDown = false;
		}
	}
	
	public void moveRandom() {
		if(control) {
			moveTimer = (int) (Math.random()*30) + 30;
			vx = (int) (Math.random()*3) - 1;
			vy = (int) (Math.random()*3) - 1;
		}
	}
	
	public void update() {
		if(Frame.isaac.x / 110 != x / 110
				|| Frame.isaac.y / 110 != y / 110) {
					return;
				}
		
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				checkCollisionB(t);
			}
		}
		
		//random movement
		if(control) {
			if(randomTimer > 0 && moveTimer == 0) {
				randomTimer --;
			}
			if(randomTimer == 0) {
				moveRandom();
				randomTimer = (int)(Math.random() * 20) + 40;
			}
			
			if(moveTimer > 0) {
				moveTimer --;
			}else {
				vx = 0; 
				vy = 0;
			}
		}
		
		if(vx == 0 && vy == 0) {
			invincible = true;
		}else {
			invincible = false;
		}
		
		x += vx;
		y += vy;
	}
}