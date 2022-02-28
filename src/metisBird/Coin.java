package metisBird;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Trieda obsahuje funkcionalitu bonusov v hre. Ked vtacik zoberie mincu , prida
 * mu k score +3.
 * 
 * @author Team
 *
 */
public class Coin {
    public static final int COIN_W = 40, COIN_H = 40; // vyska a sirka
    private BufferedImage coinImage;

    /**
     * Bezparametricky konstruktor. Vytvara mincu na zaklade obrazka v nahodnych y
     * suradniciach.
     */
    public Coin() {
    }

    /**
     * Metoda vracia obrazok mince
     * 
     * @return obrazok mince
     */
    public BufferedImage getCoinImage() {
	try {
	    URL url = MetisBird.class.getResource("/resources/coin.png");
	    coinImage = ImageIO.read(url);
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	return coinImage;
    }

}
