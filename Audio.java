import sun.audio.*;
import java.io.*;

import javax.swing.JOptionPane;

public class Audio {
	AudioStream introBackgroundMusic;
	
	public void stopMusic() {
		if(introBackgroundMusic != null) {
			AudioPlayer.player.stop(introBackgroundMusic);
		}
	}
	
	public void introMusic() {
		AudioPlayer backgroundPlayer = AudioPlayer.player;
	
		try {
			InputStream introMusic = new FileInputStream("IntroMusic.wav");
			introBackgroundMusic = new AudioStream(introMusic);
			
				AudioPlayer.player.start(introBackgroundMusic);
		
        } catch(IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void mainMusic() {
		AudioPlayer backgroundPlayer = AudioPlayer.player;
		AudioStream mainBackgroundMusic;
	
		try {
			InputStream mainMusic = new FileInputStream("MainMusic.wav");
			mainBackgroundMusic = new AudioStream(mainMusic);
			
				AudioPlayer.player.start(mainBackgroundMusic);

        } catch(IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void secretMusic() {
		AudioPlayer backgroundPlayer = AudioPlayer.player;
		AudioStream secretBackgroundMusic;
	
		try {
			InputStream mainMusic = new FileInputStream("SecretMusic.wav");
			secretBackgroundMusic = new AudioStream(mainMusic);
			
				AudioPlayer.player.start(secretBackgroundMusic);

        } catch(IOException e) {
        	e.printStackTrace();
        }
	}
	
	
	public static void soundEffects(int Control) {       
		AudioPlayer MGP = AudioPlayer.player;
		AudioStream audio;

		try {        	 
			InputStream bulletSound = new FileInputStream("BulletSound.wav");
			InputStream asteroidSound = new FileInputStream("AsteroidSound.wav");
			InputStream powerUpSound = new FileInputStream("PowerUpSound.wav");
			InputStream powerDownSound = new FileInputStream("PowerDownSound.wav");

			if(Control == 1) {
				audio = new AudioStream(bulletSound);
				AudioPlayer.player.start(audio);
			}
			else if(Control == 2) {
				audio = new AudioStream(asteroidSound);
				AudioPlayer.player.start(audio);
			}
			else if(Control == 3) {
				audio = new AudioStream(powerUpSound);
				AudioPlayer.player.start(audio);
			}
			else if(Control == 4) {
				audio = new AudioStream(powerDownSound);
				AudioPlayer.player.start(audio);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}


