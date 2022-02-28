package metisBird;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Trieda obsahuje funkcionalitu pozadia ktore bezi v hre . Obsahuje aj
 * jednotlive pozadia ktore su v hre pouzite.
 * 
 * @author Team
 *
 */
public class Background {

    Bird bird = new Bird();
    int i = 0;
    int width = getBackgroundWidth();
    int k = getBackgroundWidth();
    private BufferedImage BGimage;

    /**
     * Reprezentuje jednotlive pozadia v hre.
     * 
     * @author Team
     *
     */
    public enum BACKGROUNDS {
	BACKGROUND1, BACKGROUND2, BACKGROUND3, BACKGROUND4, BACKGROUND5, BACKGROUND6, BACKGROUND7;

    }

    static BACKGROUNDS bgType = BACKGROUNDS.BACKGROUND1;

    /**
     * Bezparametricky konstruktor. Nastavi v hre pozadie ktore si zvolil uzivatel.
     */
    public Background() {
	if (bgType == BACKGROUNDS.BACKGROUND1) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND1.png");
		BGimage = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (bgType == BACKGROUNDS.BACKGROUND2) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND2.png");
		BGimage = ImageIO.read(url);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (bgType == BACKGROUNDS.BACKGROUND3) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND3.png");
		BGimage = ImageIO.read(url);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (bgType == BACKGROUNDS.BACKGROUND4) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND4.png");
		BGimage = ImageIO.read(url);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (bgType == BACKGROUNDS.BACKGROUND5) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND5.png");
		BGimage = ImageIO.read(url);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (bgType == BACKGROUNDS.BACKGROUND6) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND6.png");
		BGimage = ImageIO.read(url);
	    } catch (IOException e) {
		e.printStackTrace();
	    }

	} else if (bgType == BACKGROUNDS.BACKGROUND7) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND7.png");
		BGimage = ImageIO.read(url);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * Nastavuje typ pozadia ktore bude bezat v hre
     * 
     * @param newBgType typ konkretneho pozadia
     */
    public void setBgType(BACKGROUNDS newBgType) {
	Background.bgType = newBgType;
    }

    /**
     * Metoda vracia typ pozadia ktore bude bezat v hre
     * 
     * @return vracia konkretny typ pozadia
     */
    public static BACKGROUNDS getBgType() {
	return bgType;
    }

    /**
     * Metoda vracia sirku konkretneho obrazka v px ktory si zvolil uzivatel
     * 
     * @return vracia sirku daneho obrazku v px ktory reprezentuje pozadie
     */
    public int getBackgroundWidth() {
	if (bgType == BACKGROUNDS.BACKGROUND1) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND1.png");
		BGimage = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }

	} else if (bgType == BACKGROUNDS.BACKGROUND2) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND2.png");
		BGimage = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }

	} else if (bgType == BACKGROUNDS.BACKGROUND3) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND3.png");
		BGimage = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }

	} else if (bgType == BACKGROUNDS.BACKGROUND4) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND4.png");
		BGimage = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }

	} else if (bgType == BACKGROUNDS.BACKGROUND5) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND5.png");
		BGimage = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }

	} else if (bgType == BACKGROUNDS.BACKGROUND6) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND6.png");
		BGimage = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }

	} else if (bgType == BACKGROUNDS.BACKGROUND7) {
	    try {
		URL url = MetisBird.class.getResource("/resources/BACKGROUND7.png");
		BGimage = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return BGimage.getWidth();
    }

    /**
     * Resetuje pozadie do povodnych suradnic
     */
    public void reset() {
	i = 0;
	k = width;
    }

    /**
     * Metoda obsahuje funkcionalitu posunu pozadia. Pozadie sa posuva v osi X z
     * prava do lava
     */
    public void physics() {
	i = i - bird.getBackgroundSpeed();
	k = k - bird.getBackgroundSpeed();

	if (i <= width * (-1)) {
	    i = width;
	}
	if (k <= width * (-1)) {
	    k = width;
	}
    }

    /**
     * Metoda vykresluje dva rovnake obrazky umiestnene vedla seba v osi X
     * 
     * @param g
     */
    public void update(Graphics g) {

	g.drawImage(BGimage, i, 0, width, MetisBird.HEIGHT, null); // vykreslenie
	g.drawImage(BGimage, k, 0, width, MetisBird.HEIGHT, null); // vykreslenie

    }

}
