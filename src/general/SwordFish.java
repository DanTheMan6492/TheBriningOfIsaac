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

public class SwordFish extends Enemy{
		
	public int IBDTimer, dashTimer;
	//	In-between-dashes timer
	
	public SwordFish(int x, int y) {
		super(x, y);
		damage = 15;
		health = 15;
		w = 31;
		h = 21;
		control = true;
		moveSpeed = 20;
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
		/*
		if(Frame.isaac.x + Frame.isaac.w/2 - 20 > x + w/2){
			moveRight();
		}else if(Frame.isaac.x + Frame.isaac.w/2 + 20 < x + w/2){
			moveLeft();
		}else {
			stopMoveRight();
			stopMoveLeft();
		}
		
		if(Frame.isaac.y + Frame.isaac.h - 20 > y + h/2){
			moveDown();
		}else if(Frame.isaac.y + Frame.isaac.h + 20 < y + h/2){
			moveUp();
		}else {
			stopMoveUp();
			stopMoveDown();
		}*/
		
		int xDist = (x + w/2) - (Frame.isaac.x + Frame.isaac.w/2);
		int yDist = (y + h/2) - (Frame.isaac.y + Frame.isaac.h/2);
		
		vy = (int)(moveSpeed / (Math.sqrt(xDist * xDist / yDist / yDist + 1)));
		vx = (int)(Math.sqrt(moveSpeed * moveSpeed - vy * vy));
		
		if(xDist > 0) {
			vx *= -1;
		}
		if(yDist > 0) {
			vy *= -1;
		}
	}
	
	public void update() {
		if(Frame.isaac.x / 110 != x / 110
				|| Frame.isaac.y / 110 != y / 110) {
					return;
				}
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				if(checkCollisionB(t)) {
					vx = 0;
					vy = 0;
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
				IBDTimer = 20;
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
	}
}