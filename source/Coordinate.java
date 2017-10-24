import java.util.Random;

public class Coordinate {
	private int curX, curY, interval;
	private static int maxX, maxY;
	private static Random rand;
	
	public Coordinate() {
		if(rand == null) // If it's the first instance of the class
			rand = new Random();
		setX();
		setY();
		interval = rand.nextInt(3) + 1;
	}
	
	public Coordinate(int interval) {
		this();
		this.interval = interval;
	}
	
	// Accessors
	public int getX() {
		return curX;
	}
	
	public int getY() {
		return curY;
	}
	
	public static int getMaxX() {
		return maxX;
	}
	
	public static int getMaxY() {
		return maxY;
	}
	
	
	
	// Mutators
	public void moveDown() {
		setY(curY + interval);
	}
	
	public void moveUp() {
		setY(curY - interval);
	}
	
	public void moveRight() {
		setX(curX + interval);
	}
	
	public void moveLeft() {
		setX(curX - interval);
	}
	
	public void moveLeft_Down() {
		setY(curY + interval);
		setX(curX - interval);
		
	}
	
	public void moveRight_Down() {
		setY(curY + interval);
		setX(curX + interval);
	}
	
	public void moveLeft_Up() {
		setY(curY - interval);
		setX(curX - interval);
	}
	
	public void moveRight_Up() {
		setY(curY - interval);
		setX(curX + interval);
	}
	
	public void setX() {
		setX(rand.nextInt(maxX));
	}
	
	public void setY() {
		setY(rand.nextInt(maxY));
	}
	
	
	public void setY(double newY) {
		setY((int) newY);
	}

	private void setY(int newY) {
		if(newY > maxY) {
			curY = 0;
			setX();
		}
		else if(newY < 0) { // Wrap
			curY = maxY;
			setX();
		}
		else
			curY = newY;
	}
	
	
	public void setX(double newX) {
		setX((int) newX);
	}
	
	private void setX(int newX) {
		if(newX > maxX) {
			curX = 0;
			setY();
		}
		else if(newX < 0) {// Wrap
			curX = maxX;
			setY();
		}
			
		else
			curX = newX;
	}
	
	public static void setMaxX(int X) {
		if(X > 0)
			maxX = X;
	}
	
	public static void setMaxY(int Y) {
		if(Y > 0)
			maxY = Y;
	}
}
