package metisBird;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Trieda obsahuje funkcionalitu na spustenie konkretneho zvuku pocas hry
 * 
 * @author Team
 *
 */
public class AudioPlayer {
    /**
     * Bezparametricky konstruktor
     */
    public AudioPlayer() {

    }

    /**
     * Metoda spusta konkretny zvuk podla zadania URL
     * 
     * @param url Odkaz na meno suboru ktory sa spusti , napr. crashSound.wav
     */
    public void playSound(final String url) {
	new Thread(new Runnable() {

	    public void run() {
		try {
		    Clip clip = AudioSystem.getClip();
		    AudioInputStream inputStream = AudioSystem
			    .getAudioInputStream(MetisBird.class.getResourceAsStream("/resources/" + url));
		    clip.open(inputStream);
		    clip.start();
		} catch (Exception e) {
		    System.err.println(e.getMessage());
		}
	    }
	}).start();
    }

}