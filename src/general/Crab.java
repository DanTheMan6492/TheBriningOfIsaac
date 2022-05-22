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

public class Crab extends Enemy{
		
	public Crab(int x, int y, boolean horizontal) {
		super(x, y);
		health = 20;
		w = 21;
		h = 21;
		if(horizontal) {
			vx = 10;
			vy = 0;
		}else {
			vx = 0;
			vy = 10;
		}
	}
	
	public void update() {
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				if(checkCollisionB(t)) {
					vx *= -1;
					vy *= -1;
				}
			}
		}
		
		x += vx;
		y += vy;
	}
}