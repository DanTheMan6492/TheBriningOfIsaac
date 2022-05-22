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

public class Fish extends Enemy{
		
	public Fish(int x, int y) {
		super(x, y);
		health = 20;
		w = 31;
		h = 21;
		moveSpeed = 4;
	}
	
	public void stopMoveRight() {
		if(control == true) {
			if(vx > 0) {
				vx = 0;
			}
		}
	}
	
	public void stopMoveLeft() {
		if(control == true) {
			if(vx < 0) {
				vx = 0;
			}
		}	
	}
	
	public void stopMoveUp() {
		if(control == true) {
			if(vy < 0) {
				vy = 0;
			}
		}
	}
	
	public void stopMoveDown() {
		if(control == true) {
			if(vy > 0) {
				vy = 0;
			}
		}
	}
	
	public void follow() {
		if(Frame.isaac.x + Frame.isaac.w/2 - 5 > x + w/2){
			moveRight();
		}else if(Frame.isaac.x + Frame.isaac.w/2 + 5 < x + w/2){
			moveLeft();
		}else {
			stopMoveRight();
			stopMoveLeft();
		}
		
		if(Frame.isaac.y + Frame.isaac.h - 5 > y + h/2){
			moveDown();
		}else if(Frame.isaac.y + Frame.isaac.h + 5 < y + h/2){
			moveUp();
		}else {
			stopMoveUp();
			stopMoveDown();
		}
	}
	
	public void update() {
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				checkCollisionB(t);
			}
		}
		
		follow();
		
		x += vx;
		y += vy;
	}
}