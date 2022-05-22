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

public class chips extends Item{
	
	public int x, y, w, h;
	public boolean pickedUp;
	public Image img; 	
	public AffineTransform tx;

	public chips(int x, int y) {
		super(x, y);
	}
	
	public void pickUp() {
		super.pickUp();
		switch((int)(Math.random() * 9)) {
		case 0:
			//upgrades damage
			Frame.isaac.damage += 5;
			break;
		case 1:
			//upgrades speed
			Frame.isaac.moveSpeed += 5;
			break;
					
		case 2:
			//upgrades shot speed
			((Isaac)Frame.isaac).shotSpeed += 3;
			break;
			
		case 3:
			//upgrades shot frequency
			if(((Isaac)Frame.isaac).shotDelay - 3 >= 0){
				((Isaac)Frame.isaac).shotDelay -= 3;
			}
			break;
			
		case 4:
			//upgrades dive duration
			((Isaac)Frame.isaac).diveDuration += 120;
			break;
			
		case 5:
			//decreases damage
			if(Frame.isaac.damage - 5 > 1) {
				Frame.isaac.damage -= 5;
			}
			break;
		case 6:
			//decreases speed
			if(Frame.isaac.moveSpeed - 5 > 1) {
				Frame.isaac.moveSpeed -= 5;
			}
			break;
					
		case 7:
			//decreases shot speed
			if(((Isaac)Frame.isaac).shotSpeed - 3 > 1) {
				((Isaac)Frame.isaac).shotSpeed -= 3;
			}
			break;
			
		case 8:
			//decreases shot frequency
			((Isaac)Frame.isaac).shotDelay += 3;
			break;
			
		case 9:
			//decreases dive duration
			if(((Isaac)Frame.isaac).diveDuration - 120 > 120) {
				((Isaac)Frame.isaac).diveDuration -= 120;
			}
			break;
		}
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