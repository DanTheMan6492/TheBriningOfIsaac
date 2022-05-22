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

public class Item{
	
	public int x, y, vx, vy, health;
	public boolean defeated;
	public String action, direction;
	public Image img; 	
	public AffineTransform tx;

	public void moveRight() {}
	
	public void moveLeft() {}
	
	public void moveUp() {}
	
	public void moveDown() {}
	
	public void stopMoveRight() {}
	
	public void stopMoveLeft() {}
	
	public void stopMoveUp() {}
	
	public void stopMoveDown() {}
	
	public void update() {}
	
	public void paint(Graphics g) {}
	
	public void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	public Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Character.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}