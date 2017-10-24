/*
 * Author: Maxfield Wilhoite
 * Date: 8/15/2016
 * Assignment: Galaga Game
 * Description: You control a ship that asteroids orbit. Press Enter to start the game and Space bar to fire bullets.
 */
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private MainPanel myPanel;
	public KeyboardHandler kbh;

	public MainFrame() {
		// Sets boundaries
		setSize(700,700);
		Coordinate.setMaxX(this.getWidth());
		Coordinate.setMaxY(this.getHeight());
		kbh = new KeyboardHandler();
		myPanel = new MainPanel();
		add(myPanel);
		setTitle("Galaga");
		this.addComponentListener(new WindowHandler());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addKeyListener(kbh);
		setVisible(true);
		
		myPanel.start();
		
	}



	public static void main(String[] args) {
		new MainFrame();

	}

	private class WindowHandler implements ComponentListener {

		@Override
		public void componentHidden(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			Coordinate.setMaxX(getWidth());
			Coordinate.setMaxY(getHeight());
			myPanel.locateCoordinates();
			if(myPanel.isPaused()) {
				myPanel.drawPauseMenu(getGraphics());
			}
			
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
	}
	
	public class KeyboardHandler implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			
			if(e.getKeyCode() == KeyEvent.VK_P) {
				myPanel.keyPressed(e);
				return;
			}
			
			if(myPanel.isPaused()) {
				return;
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				if(myPanel.getDirection() == 8)
					myPanel.setDirection(1);
				else
					myPanel.setDirection(myPanel.getDirection() + 1);
				if(myPanel.getKonamiCode() == 4 || myPanel.getKonamiCode() == 6)
					myPanel.setKonamiCode(myPanel.getKonamiCode() + 1);
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if(myPanel.getDirection() == 1)
					myPanel.setDirection(8);
				else
					myPanel.setDirection(myPanel.getDirection() - 1);
				if(myPanel.getKonamiCode() == 5 || myPanel.getKonamiCode() == 7)
					myPanel.setKonamiCode(myPanel.getKonamiCode() + 1);
			}
			else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				myPanel.keyPressed(e);
			}    
			else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				myPanel.keyPressed(e);
			}
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				myPanel.keyPressed(e);
			} 
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				myPanel.keyPressed(e);
			} 
			else if(e.getKeyCode() == KeyEvent.VK_B) {
				myPanel.keyPressed(e);
			} 
			else if(e.getKeyCode() == KeyEvent.VK_A) {
				myPanel.keyPressed(e);
			} 
		}

	
		
	}

}
