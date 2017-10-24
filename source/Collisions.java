import java.util.LinkedList;

public class Collisions {
	

	public static boolean Collision(Asteroid asteroid, LinkedList<Bullet> b) {
		
		for(int i = 0; i < b.size(); i++) {
			if(asteroid.getBounds().intersects(b.get(i).getBounds())) {
				Controller.collisionBullet = b.get(i);
				return true;
			}	
		}
		return false;
	}
	
	public static boolean Collision(MainPanel Panel, Asteroid a) {
		
			if(a.getBounds().intersects(Panel.getBounds())) {
				return true;
			}	
		return false;
	}
	
public static boolean Collision(PowerUp powerUp, LinkedList<Bullet> b) {
		
		for(int i = 0; i < b.size(); i++) {
			if(powerUp.getBounds().intersects(b.get(i).getBounds())) {
				Controller.collisionBullet = b.get(i);
				return true;
			}	
		}
		return false;
	}
	
	
	
}
