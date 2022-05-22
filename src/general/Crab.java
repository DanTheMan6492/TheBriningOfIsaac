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

public class Crab extends Enemy{
		
	public Crab(int x, int y, boolean horizontal) {
		super(x, y);
		damage = 5;
		health = 20;
		w = 21;
		h = 21;
		img = getImage("/sprites/output-onlinegiftools (1).gif");
		if(horizontal) {
			vx = 10;
			vy = 0;
		}else {
			vx = 0;
			vy = 10;
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
							checkCollisionB(t);
						}
					}
				}
			}
		}
		init(x, y);
		
		x += vx;
		y += vy;
	}
}