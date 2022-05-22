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

public class ElectricEel extends Enemy{
	
	public int electricTimer;
		
	public ElectricEel(int x, int y) {
		super(x, y);
		damage = 10;
		health = 15;
		w = 21;
		h = 21;
		moveSpeed = 5;
		moveRight();
		moveUp();
		electricTimer = 0;
	}
	
	public void update() {
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				switch(checkCollisionI(t)) {
				case 1:
					if(vx > 0) {
						moveLeft();
					}
					break;
				
				case 2:
					if(vx < 0) {
						moveRight();
					}
					break;
					
				case 3:
					if(vy > 0) {
						moveUp();
					}
					break;
					
				case 4:
					if(vy < 0) {
						moveDown();
					}
					break;
				}
			}
		}
		
		if(electricTimer > 0) {
			electricTimer --;
			if(electricTimer == 0) {
				//spawn an electric thing that is static, goes away after a while
				electricTimer = 10;
			}
		}
		
		x += vx;
		y += vy;
	}
}