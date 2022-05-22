package General;

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

import Level.Tile;

public class Isaac extends Entity{
	
	public int shotTimer;
	public Image body;
	private double scle = 2.5;
	public int bodyDir;
	public AffineTransform txBody;
	
	public Isaac(int x, int y) {
		super(x, y);
		w = 21;
		h = 30;
		moveSpeed = 10;
		direction = "d";
		bodyDir = 0;
		txBody = AffineTransform.getTranslateInstance(x+scle*4, y+scle*21);
	}
	
	public void shoot() {
		if(shotTimer == 0) {
			
		}
	}
	
	public void update() {
		
		if(movingDown){
			direction = "d";
			bodyDir = 0;
			body = getImage("/imgs/Isaac/walkf.gif");
		} else if(movingUp){
			direction = "u";
			bodyDir = 0;
			body = getImage("/imgs/Isaac/walkf.gif");
		} else if(movingLeft){
			direction = "l";
			bodyDir = 2;
			body = getImage("/imgs/Isaac/walkl.gif");
		} else if(movingRight){
			bodyDir = 1;
			direction = "r";
			body = getImage("/imgs/Isaac/walkr.gif");
		} else{
			body = getImage("/imgs/Isaac/stand" + Integer.toString(bodyDir) + ".gif");
		}

		img = getImage("/imgs/Isaac/headf.png");

		x += vx;
		y += vy;
		
		if(movingRight == false && vx > 0) {
			vx --;
		}
		
		if(movingLeft == false && vx < 0) {
			vx ++;
		}
		
		if(movingUp == false && vy < 0) {
			vy ++;
		}
		
		if(movingDown == false && vy > 0) {
			vy --;
		}
		
		for(Tile[] tileArray : Frame.tiles) {
			for(Tile t : tileArray) {
				checkCollision(t);
			}
		}
		
		if(shotTimer > 0) {
			shotTimer --;
		}

		tx = AffineTransform.getTranslateInstance(x, y);
		txBody = AffineTransform.getTranslateInstance(x+scle*4, y+scle*21);
		tx.scale(scle, scle);
		txBody.scale(scle, scle);
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(body, txBody, null);
		g2.drawImage(img, tx, null);
		update();
	}
}