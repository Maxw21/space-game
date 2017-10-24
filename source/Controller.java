import java.awt.Graphics;
import java.util.LinkedList;

public class Controller {
 
	private LinkedList<Bullet> b = new LinkedList<Bullet>();
	private LinkedList<Asteroid> a = new LinkedList<Asteroid>();
	private LinkedList<PowerUp> p = new LinkedList<PowerUp>();
	
	private int score = 0, powerUpCounter = 0, asteroidCount, bulletCount, powerUpCount = 20;
	private boolean powerUpOn;
	Audio sound;
	Bullet TempBullet;
	static Bullet collisionBullet;
	Asteroid TempAsteroid;
	PowerUp TempPowerUp;
	
	MainPanel mainPanel;
	
	public Controller(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	public void tick() {
		for(int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);
			
			if(TempBullet.getY() < 0 || TempBullet.getX() < 0 || TempBullet.getX() > mainPanel.getWidth() || TempBullet.getY() > mainPanel.getHeight())
				removeBullet(TempBullet);
			
			TempBullet.tick();
		}
		
		for(int i = 0; i < a.size(); i++) {
			TempAsteroid = a.get(i);
			
			if(a.size() > 0) {
				if(Collisions.Collision(a.get(i), mainPanel.b)) {
					a.get(i).drawDebris(mainPanel.getGraphics());
					if(p.size() < 1 && powerUpCounter == 19 && powerUpOn == false) {
						TempPowerUp = new PowerUp((int) a.get(i).getX() + 20,(int) a.get(i).getY() + 20, mainPanel);
						addPowerUp(TempPowerUp);
					}
					TempBullet = collisionBullet;
					removeBullet(TempBullet);
					removeAsteroid(a.get(i));
					sound.soundEffects(2);
					if(!powerUpOn) {
						powerUpCounter += 1;
						if( powerUpCount > 0)
							powerUpCount -= 1;
					}
					asteroidCount += 1;
					System.out.println("ASTEROID COLLISION DETECTED");
				}
			}
			
			TempAsteroid.tick();
		}
		
		for(int i = 0; i < p.size(); i++) {
			TempPowerUp = p.get(i);
			
			if(Collisions.Collision(p.get(i), mainPanel.b)) {
				TempBullet = collisionBullet;
				removeBullet(TempBullet);
				p.remove(TempPowerUp);
				sound.soundEffects(3);
				powerUpOn = true;
			}
			
			TempPowerUp.tick();
		}
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < b.size(); i++) {
			TempBullet = b.get(i);
			TempBullet.draw(g);
		}
		for(int i = 0; i < a.size(); i++) {
			TempAsteroid = a.get(i);
			TempAsteroid.draw(g);
		}
		for(int i = 0; i < p.size(); i++) {
			TempPowerUp = p.get(i);
			TempPowerUp.draw(g);
		}
	}
	
	public void addBullet(Bullet bullet) {
		if(powerUpOn == false) {
			if(b.size() < 3) {
				b.add(bullet);
				sound.soundEffects(1);
				if(mainPanel.getGameStart())
					bulletCount += 1;
			}
		}
		else if(powerUpOn == true) {
			b.add(bullet);
			sound.soundEffects(1);
			bulletCount += 1;
		}
	}
	
	public void removeBullet(Bullet bullet) {
		b.remove(bullet);
	}
	
	public void addAsteroid(Asteroid asteroid) {
		if(a.size() < 3) {
			if(Collisions.Collision(mainPanel, asteroid)) {
				System.out.println("Asteroid not added");
				return;
			} else{
				a.add(asteroid);
			}
		}	
	}
	
	public void removeAsteroid(Asteroid asteroid) {
			a.remove(asteroid);
			score += 10;
			System.out.println("A-remove");
	}
	
	public void clearAsteroid() {
		a.clear();
	}
	
	public int asteroidSize() {
		int ret;
		ret = a.size();
		return ret;
	}
	
	public void createPowerUp(int x, int y) {
		TempPowerUp = new PowerUp(x, y, mainPanel);
	}
	
	public void addPowerUp(PowerUp powerUp) {
			p.add(powerUp);
	}
	
	
	public void removePowerUp(PowerUp powerUp) {
		p.remove(powerUp);
		powerUpOn = true;
	}
	
	public void clearPowerUp() {
		p.clear();
	}
	
	public int getScore() {
		return score;
	}
	
	public LinkedList<Bullet> getBullet() {
		return b;
	}
	
	public LinkedList<Asteroid> getAsteroid() {
		return a;
	}
	
	public void setPowerUpOn(boolean powerUpOn) {
		this.powerUpOn = powerUpOn;
	}
	
	public boolean getPowerUpOn() {
		return powerUpOn;
	}
	
	public void setPowerUpCounter(int powerupcounter) {
		powerUpCounter = powerupcounter;
	}

	public int getAsteroidCount() {
		return asteroidCount;
	}

	public int getPowerUpCount() {
		return powerUpCount;
	}

	public int getBulletCount() {
		return bulletCount;
	}
	
	public void setPowerUpCount(int count) {
		powerUpCount = count;
	}
	
}
