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

public class Enemy extends Entity{
	
	public Enemy(int x, int y) {
		super(x, y);
		Frame.enemies.add(this);
	}
	
	public void checkCollision() {
		if(Frame.isaac.x + Frame.isaac.w > x
		&& Frame.isaac.x < x + w
		&& Frame.isaac.y + Frame.isaac.h > y
		&& Frame.isaac.y < y + w) {
			Frame.isaac.takeDamage(damage);
		}
	}

	public void paint(Graphics g){
		if(Frame.isaac.x / 770 != x / 770
				|| Frame.isaac.y / 770 != y / 770) {
					return;
				}
		if(health > 0) {
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(img, tx, null);
			update();
		}
	}
}