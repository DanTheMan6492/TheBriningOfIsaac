package general;
 import java.awt.Color;
import java.lang.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.github.strikerx3.jxinput.XInputAxes;
import com.github.strikerx3.jxinput.XInputAxesDelta;
import com.github.strikerx3.jxinput.XInputButtons;
import com.github.strikerx3.jxinput.XInputButtonsDelta;
import com.github.strikerx3.jxinput.XInputComponents;
import com.github.strikerx3.jxinput.XInputComponentsDelta;
import com.github.strikerx3.jxinput.XInputDevice;
import com.github.strikerx3.jxinput.enums.XInputAxis;
import com.github.strikerx3.jxinput.enums.XInputButton;
import com.github.strikerx3.jxinput.exceptions.XInputNotLoadedException;
import com.github.strikerx3.jxinput.listener.SimpleXInputDeviceListener;
import com.github.strikerx3.jxinput.listener.XInputDeviceListener;

import Level.Tile;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener{
	
	public static ArrayList<Bubble> bubbles = new ArrayList<Bubble>();
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static Entity isaac = new Isaac(100, 100);
	public static Tile[][] tiles = new Tile[10][8];
	static XInputDevice[] devices;
	public static double XAxis1;
	int xdir = 0;
	int ydir = 0;
	public static double YAxis1;
	public void paint(Graphics g) {

		for(int i =0 ; i < devices.length; i++) {
			XInputDevice device = devices[i];
			if (device.poll()) {
			    // Retrieve the delta
			    XInputComponentsDelta delta = device.getDelta();

			    XInputButtonsDelta buttons = delta.getButtons();
			    XInputAxesDelta axes = delta.getAxes();


			    // Retrieve button state change
			    if (buttons.isPressed(XInputButton.A)) {
			        ((Isaac)isaac).shoot();
			    }

			    // Retrieve axis state change.
			    // The class provides methods for each axis and a method for providing an XInputAxis
			    float brakeDelta = axes.getDelta(XInputAxis.LEFT_THUMBSTICK_X);
				float YDelta = axes.getDelta(XInputAxis.LEFT_THUMBSTICK_Y);
			    XAxis1 -= brakeDelta;
				YAxis1 -= YDelta;

				if(XAxis1 > 0.7){
					isaac.moveRight();
				} else if(XAxis1 > 0){
					isaac.stopMoveRight();
				}

				if(XAxis1 < -0.7){
					isaac.moveLeft();
				} else if(XAxis1 < 0){
					isaac.stopMoveLeft();
				}

				if(YAxis1 > 0.7){
					isaac.moveUp();
				} else if(YAxis1 > 0){
					isaac.stopMoveUp();
				}

				if(YAxis1 < -0.7){
					isaac.moveDown();
				} else if(YAxis1 < 0){
					isaac.stopMoveDown();
				}
			} else {
			    // Controller is not connected; display a message
			}
		}

		super.paintComponent(g);
		for(Tile[] tileArray : tiles) {
			for(Tile t : tileArray) {
				if(t != null)
					t.paint(g);
			}
		}
		for(Bubble b : bubbles) {
			b.paint(g);
		}
		for(Enemy e : enemies) {
			e.paint(g);
		}
		isaac.paint(g);
	}
	
	public static void main(String[] arg) {
		try {
			devices = XInputDevice.getAllDevices();
		} catch (XInputNotLoadedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		Frame f = new Frame();
		for(int i = 0; i < 10; i ++) {
			for(int j = 0; j < 8; j ++) {
				if(i == 0 || j == 0 || i == 9 || j == 7) {
					tiles[i][j] = new Tile(10 + i * Tile.l, 10 + j * Tile.l, true); 
				}else {
					tiles[i][j] = new Tile(10 + i * Tile.l, 10 + j * Tile.l, false); 
				}
			}
		}
	}
	
	public Frame() {
		JFrame f = new JFrame("The Brining of Isaac");
		f.setSize(new Dimension(770, 770));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		enemies.add(new Squid(100,100));
	}
	
    @Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//w is pressed
		if(arg0.getKeyCode() == 87) {
			isaac.moveUp();
		}
		
		//a is pressed
		if(arg0.getKeyCode() == 65) {
			isaac.moveLeft();
		}
		
		//s is pressed
		if(arg0.getKeyCode() == 83) {
			isaac.moveDown();
		}
		
		//d is pressed
		if(arg0.getKeyCode() == 68) {
			isaac.moveRight();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//w is released
		if(arg0.getKeyCode() == 87) {
			isaac.stopMoveUp();
		}
		
		//a is released
		if(arg0.getKeyCode() == 65) {
				isaac.stopMoveLeft();
		}
		
		//s is released
		if(arg0.getKeyCode() == 83) {
			isaac.stopMoveDown();
		}
				
		//d is released
		if(arg0.getKeyCode() == 68) {
			isaac.stopMoveRight();
		}
		
		//f is pressed
		if(arg0.getKeyCode() == 70) {
			((Isaac)isaac).shoot();
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}