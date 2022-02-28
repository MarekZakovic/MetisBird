
package metisBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Trieda obsahuje funkcionalitu vtacika v hre. Na vyber je 6 druhov, kazdy ma
 * inu rychlost a vahu
 * 
 * @author Team
 *
 */
public class Bird {
    public float x, y, vx, vy;
    public static final int RADIUS = 40; // polomer vtacika
    private BufferedImage img;
    private int backgroundSpeed;
    private int pipesSpeed;
    private int scrollSpeed;
    private double YMovementValue;

    /**
     * Reprezentuje jednotlive vtaciky ktore su v hre na vyber.
     * 
     * @author team
     *
     */
    public enum BIRD {
	BIRD1, BIRD2, BIRD3, BIRD4, BIRD5, BIRD6

    }

    static BIRD birdType = BIRD.BIRD1;

    /**
     * Bezparametricky konstruktor. Vytvara vtacika podla vyberu uzivatela, nasledne
     * nastavi jeho obrazok , rychlost a vahu.
     */
    public Bird() {
	x = MetisBird.WIDTH / 2; // poloha vtacika v ose x
	y = MetisBird.HEIGHT / 2; // poloha vtacika v ose y

	if (birdType == BIRD.BIRD1) {
	    backgroundSpeed = 2;
	    pipesSpeed = 4;
	    scrollSpeed = 10;
	    YMovementValue = 0.5;
	    try {
		URL url = MetisBird.class.getResource("/resources/bird1.png");
		img = ImageIO.read(url); // nacita obrazok vtacika1

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (birdType == BIRD.BIRD2) {
	    backgroundSpeed = 2;
	    pipesSpeed = 6;
	    scrollSpeed = 25;
	    YMovementValue = 0.3;
	    try {
		URL url = MetisBird.class.getResource("/resources/bird2.png");
		img = ImageIO.read(url); // nacita obrazok vtacika2
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (birdType == BIRD.BIRD3) {
	    backgroundSpeed = 3;
	    pipesSpeed = 8;
	    scrollSpeed = 40;
	    YMovementValue = 0.5;
	    try {
		URL url = MetisBird.class.getResource("/resources/bird3.png");
		img = ImageIO.read(url); // nacita obrazok vtacika3
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (birdType == BIRD.BIRD4) {
	    backgroundSpeed = 3;
	    pipesSpeed = 10;
	    scrollSpeed = 60;
	    YMovementValue = 0.7;
	    try {
		URL url = MetisBird.class.getResource("/resources/bird4.png");
		img = ImageIO.read(url); // nacita obrazok vtacika4
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (birdType == BIRD.BIRD5) {
	    backgroundSpeed = 4;
	    pipesSpeed = 12;
	    scrollSpeed = 50;
	    YMovementValue = 0.5;
	    try {
		URL url = MetisBird.class.getResource("/resources/bird5.png");
		img = ImageIO.read(url); // nacita obrazok vtacika5
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	} else if (birdType == BIRD.BIRD6) {
	    backgroundSpeed = 6;
	    pipesSpeed = 16;
	    scrollSpeed = 100;
	    YMovementValue = 0.7;
	    try {
		URL url = MetisBird.class.getResource("/resources/bird6.png");
		img = ImageIO.read(url); // nacita obrazok vtacika6
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

    }

    /**
     * Nastavuje druh vtacika
     * 
     * @param newBirdType druh vtacika
     */
    public void setBirdType(BIRD newBirdType) {
	Bird.birdType = newBirdType;

    }

    /**
     * Metoda vracia cislo ktore reprezentuje rychlost posunu prekazok v hre
     * 
     * @return Vracia rychlost posunu prekazok v hre (potrubia)
     */
    public int getPipeSpeed() {
	return pipesSpeed;
    }

    /**
     * Metoda vracia cislo ktore reprezentuje rychlost posunu pozadia v hre
     * 
     * @return vracia rychlost posunu pozadia
     */
    public int getBackgroundSpeed() {
	return backgroundSpeed;
    }

    /**
     * Metoda vracia typ zvoleneho vtacika
     * 
     * @return vracia typ vtacika
     */
    public BIRD getBirdType() {
	return Bird.birdType;
    }

    /**
     * Metoda obsahuje funkcionalitu pohybu vtacika v hre
     */
    public void physics() {
	x += vx;
	y += vy;
	vy += YMovementValue; // rychlost pohybu v y osi
    }

    /**
     * Metoda vykresluje vtacika v hre
     * 
     * @param g
     */
    public void update(Graphics g) {
	g.setColor(Color.GREEN);
	g.drawImage(img, Math.round(x - RADIUS), Math.round(y - RADIUS), 2 * RADIUS, 2 * RADIUS, null); // vykreslenie
													// vtacika
    }

    /**
     * Metoda obsahuje funkcionalitu vyletenia vtacika po stlaceni klavesu
     */
    public void jump() {
	vy = -8; // velkost skoku
    }

    /**
     * Resetuje vtacika v hre do povodnej polohy x,y
     */
    public void reset() {
	x = MetisBird.WIDTH / 2;
	y = MetisBird.HEIGHT / 2;
	vx = vy = 0;
    }

    public int getScrollSpeed() {
	return scrollSpeed;
    }

}
