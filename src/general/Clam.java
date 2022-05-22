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

public class Clam extends Enemy{
		
	public Clam(int x, int y) {
		super(x, y);
		w = 21;
		h = 21;
		moveSpeed = 0;
	}
	
	//will drop loot when defeated
}