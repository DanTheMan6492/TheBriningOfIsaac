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

public class Tile{
	
	public int x, y;
	public static int l = 30;
	public boolean solid, breakable;
	public Image img;
	public AffineTransform tx;
	
	public Tile(int x, int y, boolean solid) {
		this.x = x;
		this.y = y;
		this.solid = solid;
	}
	
	public void paint(Graphics g) {
		if(solid) {
			g.drawRect(x, y, l, l);
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