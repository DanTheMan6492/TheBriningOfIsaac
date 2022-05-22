package Level;

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

import general.Camera;

public class Tile{
	
	public int x, y;
	public static int l = 30;
	public boolean solid, breakable;
	public Image img;
	public AffineTransform tx;
	
	//type 1: water tiles
	//type 2: solid wall
	//type 3: Trash
	public Tile(int x, int y, int type) {
		this.x = x;
		this.y = y;
		switch(type){
			case 1:
			solid = false;
			break;
			case 2:
			solid = true;
			breakable = false;
			case 3:
			solid = true;
			breakable = true;
			break;
		}
	}
	
	public void paint(Graphics g) {
		if(solid) {
			g.drawRect(x-(int)Camera.x, y-(int)Camera.y, l, l);
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