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

public class Bubble extends Entity{
	
	public int damage;
	public boolean active;
	
	public Bubble(int x, int y) {
		super(x, y);
		moveSpeed = 10;
	}
	
	public void update() {
		x += vx;
		y += vy;
	}
	
	public void paint(Graphics g) {}
}