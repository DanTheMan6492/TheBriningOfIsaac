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

public class Entity{
	
	public int x, y, w, h, vx, vy, moveSpeed;
	public double health;
	public boolean control, defeated, movingRight, movingLeft, movingUp, movingDown;
	public String action, direction;
	public Image img; 	
	public AffineTransform tx;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
		control = true;
		tx = AffineTransform.getTranslateInstance(x, y );
	}
	
	public void moveRight() {
		if(control) {
			movingRight = true;
			if(vy == 0) {
				vx = moveSpeed;
			}else {
				vx = (int) (moveSpeed / Math.sqrt(2));
				if(vy > 0) {
					vy = (int) (moveSpeed / Math.sqrt(2));
				}else if(vy < 0) {
					vy = (int) (-moveSpeed / Math.sqrt(2));
				}
			}
		}
	}
	
	public void moveLeft() {
		if(control) {
			movingLeft = true;
			if(vy == 0) {
				vx = -moveSpeed;
			}else {
				vx = (int) (-moveSpeed / Math.sqrt(2));
				if(vy > 0) {
					vy = (int) (moveSpeed / Math.sqrt(2));
				}else if(vy < 0) {
					vy = (int) (-moveSpeed / Math.sqrt(2));
				}
			}
		}
	}
	
	public void moveUp() {
		if(control) {
			movingUp = true;
			if(vx == 0) {
				vy = -moveSpeed;
			}else {
				vy = (int) (-moveSpeed / Math.sqrt(2));
				if(vx > 0) {
					vx = (int) (moveSpeed / Math.sqrt(2));
				}else if(vx < 0) {
					vx = (int) (-moveSpeed / Math.sqrt(2));
				}
			}
		}
	}
	
	public void moveDown() {
		if(control) {
			movingDown = true;
			if(vx == 0) {
				vy = moveSpeed;
			}else {
				vy = (int) (moveSpeed / Math.sqrt(2));
				if(vx > 0) {
					vx = (int) (moveSpeed / Math.sqrt(2));
				}else if(vx < 0) {
					vx = (int) (-moveSpeed / Math.sqrt(2));
				}
			}
		}
	}
	
	public void stopMoveRight() {
		if(control) {
			movingRight = false;
		}
	}
	
	public void stopMoveLeft() {
		if(control) {
			movingLeft = false;
		}
	}
	
	public void stopMoveUp() {
		if(control) {
			movingUp = false;
		}
	}
	
	public void stopMoveDown() {
		if(control) {
			movingDown = false;
		}
	}
	
	public boolean checkCollision(Tile t) {
		boolean result = false;
		
		if(t.solid == true) {
			if(x + w > t.x
			&& x + w < t.x + t.l
			&& y + h > t.y
	    	&& y < t.y + t.l
	    	&& y + h - 10 > t.y
	    	&& y + 10 < t.y + t.l) {
				result = true;
	    		while(x + w > t.x) {
	    			x --;
	    		}
	    	}
	    	if(x < t.x + t.l
	    	&& x > t.x
	  		&& y + h > t.y
	   	    && y < t.y + t.l
	        && y + h - 10 > t.y
	        && y + 10 < t.y + t.l) {
	    		result = true;
	    		while(x < t.x + t.l) {
	    			x ++;
	   		   	}
	    	}
			    	
	    	if(y + h > t.y
	    	&& y + h < t.y + t.l
	    	&& x + w > t.x
	    	&& x < t.x + t.l
	    	&& x + w - 10 > t.x
	    	&& x + 10 < x + t.l) {
	    		result = true;
	    		while(y + h > t.y) {
	    			y --;
	    		}
	    	}

			    	
	    	if(y < t.y + t.l
	    	&& y > t.y
	    	&& x + w > x
	    	&& x < t.x + t.l
	    	&& x + w - 10 > t.x
	    	&& x + 10 < t.x + t.l) {
	    		result = true;
	    		while(y < t.y + t.l) {
	    			y ++;
	    		}
	    	}
		}
		return result;
	}
	
	public void update() {
		
	}
	
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