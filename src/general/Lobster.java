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

public class Lobster extends Enemy{
		
	public Lobster(int x, int y) {
		super(x, y);
		img = getImage("/sprites/lobsterDirtyRight.gif");
		damage = 10;
		health = 20;
		w = 21;
		h = 21;
		moveSpeed = 5;
		moveRight();
		moveDown();
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
				}
			}
		}
		
		x += vx;
		y += vy;

		tx = AffineTransform.getTranslateInstance(x-Camera.x, y-Camera.y);
	}
}