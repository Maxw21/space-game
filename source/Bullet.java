import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

public class Bullet {
	
	private double x, y;
	private int direction;
	BufferedImage image = null;
	MainPanel mainpanel;
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, (int)(96*.15),(int)(96*.15));
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Bullet(double x, double y, MainPanel mainPanel, int direction ){
		this.x = x;
		this.y = y;
		this.mainpanel = mainPanel;
		this.direction = direction;
	
		try {
			image = ImageIO.read(ImageIO.createImageInputStream(new ByteArrayInputStream(Base64.getDecoder().decode(BULLET))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		if(!mainpanel.isPaused()) {
			if(direction == 1){
				x += 5;
			} else if(direction == 2) {
				x += 5;
				y -= 5;
			} else if(direction == 3) {
				y -= 5;
			} else if(direction == 4) {
				x -= 5;
				y -= 5;
			} else if(direction == 5) {
				x -= 5;
			} else if(direction == 6) {
				x -= 5;
				y += 5;
			} else if(direction == 7) {
				y += 5;
			} else if(direction == 8) {
				x += 5;
				y += 5;
			}
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(image,(int) x,(int) y, (int) (96*.15),(int) (96*.15),  null);
	}
		
	
	private static final String BULLET = "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";

}