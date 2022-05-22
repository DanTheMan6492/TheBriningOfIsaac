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

public class Bubble extends Entity{
	
	public int damage;
	public boolean active;
	
	public Bubble(int x, int y, int vx, int vy) {
		super(x, y);
		this.vx = vx;
		this.vy = vy;
		damage = 5;
		w = 10;
		h = 10;
		active = true;
	}
	
	public void checkCollition(Enemy e) {
		if(e.x + e.w > x
		&& e.x < x + w
		&& e.y + e.h > y
		&& e.y < y + h) {
			active = false;
			e.takeDamage(damage);
		}
	}
	
	public void update() {
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				if(checkCollisionB(t)) {
					active = false;
				}
			}
		}
		
		for(Enemy e : Frame.enemies) {
			checkCollition(e);
		}
		
		x += vx;
		y += vy;
	}
	
	public void paint(Graphics g) {
		if(active) {
			Graphics2D g2 = (Graphics2D) g;
			update();
			g.drawOval(x - w/2, y - h/2, w, h);
		}
	}
}