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

public class Bubble extends Entity{
	
	public int damage;
	public boolean active;
	
	public Bubble(int x, int y, int vx, int vy) {
		super(x, y);
		this.vx = vx;
		this.vy = vy;
		damage = 5;
		w = 10;
		active = true;
		img = getImage("/sprites/bubble.png");
	}
	
	public void checkCollition(Enemy e) {
		if(e.x + e.w > x
		&& e.x < x + w
		&& e.y + e.h > y
		&& e.y < y + w) {
			active = false;
			e.takeDamage(damage);
		}
	}
	
	public void update() {
		for(Room[] row : Level.level){
			for(Room room : row){
				if(room != null){
					for(Tile[] tileArray : room.layout) {
						for(Tile t : tileArray) {
							if(t != null)
								if(checkCollisionB(t)) {
									active = false;
								}
						}
					}
				}
			}
		}
		
		for(Room[] row : Level.level){
			for(Room room : row){
				if(room != null){
					for(Enemy e : room.enemies) {
						checkCollition(e);
					}
				}
			}
		}
		
		x += vx;
		y += vy;
		
		init(x, y);
	}
	
	public void paint(Graphics g) {
		if(active) {
			Graphics2D g2 = (Graphics2D) g;
			update();
			g2.drawImage(img, tx, null);
		}
	}
}