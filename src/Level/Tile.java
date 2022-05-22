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
	public static int l = 110;
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
			case 0:
			img = getImage("/imgs/Tiles/Water.png");
			solid = false;
			break;
			case 1:
			img = getImage("/imgs/Tiles/Wall.png");
			solid = true;
			breakable = false;
			case 2:
			solid = true;
			breakable = true;
			break;
		}
		tx = AffineTransform.getTranslateInstance(x-Camera.x, y-Camera.y);
	}
	
	public void update(){
		tx = AffineTransform.getTranslateInstance(x-Camera.x, y-Camera.y);
	}
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
		update();
	}
	
	public void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	public Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Tile.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}