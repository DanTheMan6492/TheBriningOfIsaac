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

public class Jellyfish extends Enemy{
		
	public Jellyfish(int x, int y) {
		super(x, y);
		img = getImage("/sprites/jellyfishClean.gif");
		damage = 15;
		health = 10;
		w = 21;
		h = 21;
		moveSpeed = 0;
	}
	
	public void update() {
		//will detect collision from the player, will poison them if they touch
	}
}