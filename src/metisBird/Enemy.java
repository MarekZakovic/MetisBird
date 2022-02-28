package metisBird;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Trieda obsahuje funkcionalitu nepriatelov v hre. Ked sa vtacik dotkne
 * nepriatela , hra konci.
 * 
 * @author Team
 *
 */
public class Enemy {
    public static final int ENEMY_W = 50, ENEMY_H = 50; // sirka a vyska
    private BufferedImage enemyImage;

    /**
     * Bezparametricky konstruktor. Vytvara nepriatela na zaklade obrazka v
     * nahodnych y suradniciach.
     */
    public Enemy() {

    }

    /**
     * Metoda vracia obrazok nepriatela.
     * 
     * @return obrazok nepriatela
     */
    public BufferedImage getEnemyImage() {
	try {
	    URL url = MetisBird.class.getResource("/resources/enemyBird.png");
	    enemyImage = ImageIO.read(url);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	return enemyImage;
    }

}
