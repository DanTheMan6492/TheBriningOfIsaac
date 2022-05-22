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

public class AutoSear extends Item{
	
	public int x, y, w, h;
	public boolean pickedUp;
	public Image img; 	
	public AffineTransform tx;

	public AutoSear(int x, int y) {
		super(x, y);
	}
	
	public void pickUp() {
		super.pickUp();
		//upgrades shot speed
		((Isaac)Frame.isaac).shotSpeed += 3;
	}
	
	public void paint(Graphics g) {
		if(pickedUp == false) {
			Graphics2D g2 = (Graphics2D) g;
			g.drawRect(x, y, w, h);
		}
	}
	
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