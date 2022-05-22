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

import Level.Level;
import Level.Room;
import Level.Tile;

public class Squid extends Enemy{
		
	public int IBDTimer, dashTimer;
	//	In-between-dashes timer
	
	public Squid(int x, int y) {
		super(x, y);
		img = getImage("/sprites/squidDirtyRight.gif");
		damage = 10;
		health = 10;
		w = 31;
		h = 21;
		control = true;
		moveSpeed = 14;
		IBDTimer = 50;
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
	
	public void dash() {
		switch((int)(Math.random() * 3)) {
		case 0:
			moveRight();
			break;
			
		case 1:
			moveLeft();
			break;
			
		case 2:
			stopMoveRight();
			stopMoveLeft();
			break;
		}
		
		switch((int)(Math.random() * 3)) {
		case 0:
			moveUp();
			break;
			
		case 1:
			moveDown();
			break;
			
		case 2:
			stopMoveUp();
			stopMoveDown();
			break;
		}
	}
	
	public void update() {
		if(Frame.isaac.x / 770 != x / 770
				|| Frame.isaac.y / 770 != y / 770) {
					return;
		}
		
		for(Room[] row : Level.level){
			for(Room room : row){
				if(room != null){
					for(Tile[] tileArray : room.layout) {
						for(Tile t : tileArray) {
							if(t != null)
								if(checkCollisionB(t)) {
									vx = 0;
									vy = 0;
								}
						}
					}
				}
			}
		}
		
		if(IBDTimer > 0 && vx == 0 && vy == 0) {
			IBDTimer --;
			stopMoveRight();
			stopMoveLeft();
			stopMoveUp();
			stopMoveDown();
			if(IBDTimer == 0) {
				dash();
				IBDTimer = 50;
				//in projectiles spawn a ink cloud
			}
		}
		
		if(vx > 0) {
			vx --;
		}
		
		if(vx < 0) {
			vx ++;
		}
		
		if(vy < 0) {
			vy ++;
		}
		
		if(vy > 0) {
			vy --;
		}
		
		x += vx;
		y += vy;

		tx = AffineTransform.getTranslateInstance(x-Camera.x, y-Camera.y);
	}
}