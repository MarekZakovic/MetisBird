
package metisBird;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Hlavna trieda aplikacie obsahuje stavy aplikacie, funkcionalitu na pohyb
 * objektov v hre a actionlisteners ktore reaguju na podnet uzivatela.
 * 
 * @author Team
 *
 */
public class MetisBird implements ActionListener, KeyListener {

    public static final int FPS = 60, WIDTH = 1400, HEIGHT = 800;

    private Bird bird;
    Player player = new Player();
    private Background background;
    Window menu = new Window(WIDTH, HEIGHT, "Menu");
    AudioPlayer audioPlayer = new AudioPlayer();
    private JFrame frame;
    private JPanel panel;
    private ArrayList<Rectangle> rects;
    private ArrayList<Rectangle> ovals;
    private ArrayList<Rectangle> enemies;
    private int time, scroll;
    private Timer t;
    private static String name;
    private boolean paused;
    boolean game = true;

    /**
     * Jednotlive stavy aplikacie podla ktorych sa vykonava proces
     * 
     * @author team
     *
     */
    public enum STATE {
	MENU1, MENU2, OPTIONS, HIGHSCORE, GAME, BIRD_SELECT, SCENERY_SELECT, PIPES_SELECT, NAME_SELECT
    };

    STATE state = STATE.MENU1;

    private int score;

    /**
     * Metoda nastavuje stav aplikacie.
     * 
     * @param newState novy stav aplikacie
     */
    public void setState(STATE newState) {
	this.state = newState;
	go();

    }

    /**
     * Metoda spusta aplikaciu podla toho v akom stave sa aktualne nachadza
     */
    public void go() {
	if (state == STATE.MENU1) {
	    menu.runMenu1();
	} else if (state == STATE.SCENERY_SELECT) {
	    menu.runScenerySelect();
	} else if (state == STATE.BIRD_SELECT) {
	    menu.runBirdSelect();
	} else if (state == STATE.PIPES_SELECT) {
	    menu.runPipesSelect();
	} else if (state == STATE.NAME_SELECT) {
	    menu.runNameSelect();
	} else if (state == STATE.OPTIONS) {
	    menu.runOptions();
	} else if (state == STATE.HIGHSCORE) {
	    menu.runHighscore();
	} else if (state == STATE.GAME) {
	    frame = new JFrame("Flappy Bird");
	    bird = new Bird();
	    background = new Background();

	    rects = new ArrayList<Rectangle>();
	    ovals = new ArrayList<Rectangle>();
	    enemies = new ArrayList<Rectangle>();

	    panel = new GamePanel(this, bird, background, rects, ovals, enemies);
	    frame.add(panel);

	    frame.setSize(WIDTH, HEIGHT);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.addKeyListener(this);

	    paused = true;

	    t = new Timer(100 / FPS, this);
	    t.start();
	}

    }

    public static void main(String[] args) {

	new MetisBird().go();

    }

    @SuppressWarnings("deprecation")
    @Override
    /**
     * Metoda je zodpovedna za objekty a ich pohyb v hre , tieto objekty su ulozene
     * v Arralistoch ktore vymaze ak je hra skoncena
     */
    public void actionPerformed(ActionEvent e) {
	ArrayList<Rectangle> toRemove = new ArrayList<Rectangle>();

	panel.repaint();
	if (!paused) {
	    bird.physics();
	    background.physics();
	    if (scroll % 1000 == 0) {

		Rectangle r = new Rectangle(WIDTH, 0, Pipe.PIPE_W,
			(int) ((Math.random() * HEIGHT) / 5f + (0.2f) * HEIGHT));
		int h2 = (int) ((Math.random() * HEIGHT) / 5f + (0.2f) * HEIGHT);
		Rectangle r2 = new Rectangle(WIDTH, HEIGHT - h2, Pipe.PIPE_W, h2);
		rects.add(r);
		rects.add(r2);
		score++;
		// nahodna y-suradnica pre bonus a nepriatelov
		int yRandom = ThreadLocalRandom.current().nextInt(100, HEIGHT - 100);
		Rectangle c = new Rectangle(WIDTH + 100, yRandom, Coin.COIN_W, Coin.COIN_H);
		Rectangle en = new Rectangle(WIDTH + 1000, yRandom, Enemy.ENEMY_W, Enemy.ENEMY_H); // pozicia a velkost
												   // nepriatelov
		ovals.add(c);
		enemies.add(en);

	    }
	    boolean game = true;
	    for (Rectangle r : rects) {
		r.x -= bird.getPipeSpeed(); // posun
		if (r.x + r.width <= 0) {
		    toRemove.add(r);

		}

		if (r.contains(bird.x, bird.y) || bird.y >= HEIGHT) {
		    audioPlayer.playSound("crash1.wav");
		    JOptionPane.showMessageDialog(frame, "You lose!\n" + "Your score was: " + score + ".");
		    game = false;
		    try {
			String file = "players.csv";
			FileWriter pw = new FileWriter(file, true);
			pw.write(name + "," + score + "\n");
			pw.close();
		    } catch (FileNotFoundException ex) {
			ex.printStackTrace();
		    } catch (IOException ex) {
			ex.printStackTrace();
		    }

		    background.reset();
		    break;
		}

	    }

	    for (Rectangle c : ovals) {
		c.x -= bird.getPipeSpeed();
		if (c.x + c.width <= 0) {
		    toRemove.add(c);
		}
		if (c.contains(bird.x, bird.y)) {
		    c.resize(0, 0);
		    score += 3;
		    audioPlayer.playSound("coin_sound1.wav");

		}
	    }
	    for (Rectangle en : enemies) {
		en.x -= bird.getPipeSpeed() + 2;
		if (en.x + en.width <= 0) {
		    toRemove.add(en);
		}
		if (en.contains(bird.x, bird.y)) {
		    audioPlayer.playSound("crash1.wav");
		    JOptionPane.showMessageDialog(frame, "You lose!\n" + "Your score was: " + score + ".");
		    game = false;
		    try {
			String file = "players.csv";
			FileWriter pw = new FileWriter(file, true);
			pw.write(name + "," + score + "\n");
			pw.close();
		    } catch (FileNotFoundException ex) {
			ex.printStackTrace();
		    } catch (IOException ex) {
			ex.printStackTrace();
		    }
		    background.reset();
		    break;

		}
	    }

	    rects.removeAll(toRemove);
	    ovals.removeAll(toRemove);
	    enemies.removeAll(toRemove);
	    time++;
	    scroll += bird.getScrollSpeed();

	    if (bird.y > HEIGHT || bird.y + Bird.RADIUS < 0) {
		game = false;
	    }

	    if (!game) {
		rects.clear();
		ovals.clear();
		bird.reset();
		enemies.clear();
		time = 0;
		score = 0;
		scroll = 0;
		paused = true;
	    }
	} else {

	}

    }

    /**
     * Metoda vracia aktualne score hraca
     * 
     * @return score
     */
    public int getScore() {
	return score;
    }

    /**
     * Metoda reaguje na stlacenie klavesnice a nasledne vykonava urcenu akciu
     */
    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_UP) {
	    bird.jump();
	} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	    paused = false;
	}
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    /**
     * Matoda vracia hodnotu true/false podla aktualneho stavu hry(hra/pauza)
     * 
     * @return vracia true/false podla toho ci je hra pauznuta
     */
    public boolean paused() {
	return paused;
    }

    /**
     * Nastavuje meno hraca
     * 
     * @param name meno hraca
     */
    public void setName(String name) {
	MetisBird.name = name;
    }

}
