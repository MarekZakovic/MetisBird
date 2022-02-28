/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metisBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Trieda vykresluje jednotlive komponenty a casti hry.
 * 
 * @author team
 */
public class GamePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private MetisBird fb;
    private Bird bird;
    private Pipe pipe = new Pipe();
    private Coin coin = new Coin();
    private Enemy enemy = new Enemy();
    private Background background;

    private ArrayList<Rectangle> rects; // obdlzniky reprezentujuce prekazky
    private ArrayList<Rectangle> ovals; // obdlzniky reprezentujuce bonusy
    private ArrayList<Rectangle> enemies; // obdlzniky prezentujuce nepriatelov

    private Font scoreFont, pauseFont; // font score
    public static Color bgColor = new Color(0, 158, 158); // farba pozadia

    private Image enemyImage = enemy.getEnemyImage();
    private Image coinImage = coin.getCoinImage();
    private Image pipeHead = pipe.getPipeHead();
    private Image pipeLength = pipe.getPipeLength();

    /**
     * Konstruktor
     * 
     * @param fb         objekt main triedy
     * @param bird       objekt reprezentuje vtacika v hre
     * @param background objekt reprezentuje pozadie v hre
     * @param rects      Arraylist v ktorom sa nachadzaju obdlzniky reprezentujuce
     *                   prekazky
     * @param ovals      Arraylist v ktorom sa nachadzaju obdlzniky reprezentujuce
     *                   bonusy
     * @param enemies    Arraylist v ktorom sa nchadzaju obdlzniky reprezentujuce
     *                   nepriatelov
     */
    public GamePanel(MetisBird fb, Bird bird, Background background, ArrayList<Rectangle> rects,
	    ArrayList<Rectangle> ovals, ArrayList<Rectangle> enemies) {
	this.fb = fb;
	this.bird = bird;
	this.rects = rects;
	this.ovals = ovals;
	this.enemies = enemies;
	this.background = background;

	scoreFont = new Font("Comic Sans MS", Font.BOLD, 18); // font score zobrazeny pocas hry
	pauseFont = new Font("Arial", Font.BOLD, 48);// text zobrazeny pri pauze
    }

    /**
     * Bezparametricky konstruktor
     */
    public GamePanel() {

    }

    /**
     * Metoda vracia farbu pozadia
     * 
     * @return vracia farbu pozadia
     */
    public static Color getBackroundColor() {
	return bgColor;
    }

    @Override
    /**
     * Metoda zodpovedna za vykreslovanie grafiky do hry
     */
    public void paintComponent(Graphics g) {

	g.setColor(bgColor);
	g.fillRect(0, 0, MetisBird.WIDTH, MetisBird.HEIGHT);
	background.update(g);
	bird.update(g); // update vykreslenia vtacika

	for (Rectangle r : rects) {
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(Color.WHITE);
	    AffineTransform old = g2d.getTransform();
	    g2d.translate(r.x + Pipe.PIPE_W / 2, r.y + Pipe.PIPE_H / 2 - 10);

	    if (r.y < MetisBird.HEIGHT / 2) {
		g2d.translate(0, r.height - 10);
		g2d.rotate(Math.PI);
	    }
	    g2d.drawImage(pipeHead, -Pipe.PIPE_W / 2, -Pipe.PIPE_H / 2 + 15, Pipe.PIPE_W, Pipe.PIPE_H, null);
	    g2d.drawImage(pipeLength, -Pipe.PIPE_W / 2, Pipe.PIPE_H / 2, Pipe.PIPE_W, r.height, null);

	    g2d.setTransform(old);
	}

	for (Rectangle o : ovals) {
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.drawImage(coinImage, o.x, o.y, o.width, o.height, null);
	    AffineTransform old = g2d.getTransform();
	    g2d.setTransform(old);
	}
	for (Rectangle en : enemies) {
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setColor(Color.RED);
	    g2d.drawImage(enemyImage, en.x, en.y, en.width, en.height, null);
	    AffineTransform old = g2d.getTransform();
	    g2d.setTransform(old);
	}
	g.setFont(scoreFont);
	g.setColor(Color.BLACK);
	g.drawString("Score: " + fb.getScore(), 10, 20);

	if (fb.paused()) {
	    g.setFont(pauseFont);
	    g.setColor(new Color(0, 0, 0, 170));
	    g.drawString("PRESS SPACE TO BEGIN", MetisBird.WIDTH / 2 - 300, MetisBird.HEIGHT / 2 + 50);

	}

    }

}
