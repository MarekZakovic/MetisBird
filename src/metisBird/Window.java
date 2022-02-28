package metisBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metisBird.Background.BACKGROUNDS;
import metisBird.Bird.BIRD;
import metisBird.MetisBird.STATE;
import metisBird.Pipe.PIPES;

/**
 * Trieda zahrna obsah ktory sa ma zobrazit v jednotlivych oknach aplikacie.
 * Tieto okna su zaroven aj stavy aplikacie v ktorych sa momentalne nachadza.
 * 
 * MENU1 - Prve okno ktore sa zobrazi po spusetni.
 * 
 * SCENERY_SELECT - Okno kde si uzivatel vyberie prostredie.
 * 
 * BIRD_SELECT - Okno v ktorom si uzivatel vyberie vtacika s ktorym chce hrat.
 * 
 * PIPE_SELECT - Okno v ktorom si uzivatel vyberie potrubie ktore chce mat v hre
 * zobrazene ako prekazku
 * 
 * NAME_SELECT - Okno v ktorom si uzivatel nastavuje svoje meno
 * 
 * OPTIONS - Okno v ktorom sa nachadzaju nastavenia hry.
 * 
 * HIGHSCORE - Okno v ktorom je zobrazeny rebricek top 10 najlepsich score.
 * 
 * 
 * @author Team
 * 
 */
public class Window extends JFrame {

    private static final long serialVersionUID = -3983653561724584816L;

    private static int WIDTH = MetisBird.WIDTH;
    private static int HEIGHT = MetisBird.HEIGHT;
    private String title;
    private JFrame frame = new JFrame();
    private Bird bird = new Bird();
    private Pipe pipe = new Pipe();
    Player player = new Player();

    private JPanel panel;
    Color fontColor = new Color(91, 55, 20);
    private JTextField textField = new JTextField("YOUR NAME");
    JDialog dialog = new JDialog();
    private String playerName;

    private JButton playButton;
    private static int BUTTON_SIZE_X = 400;
    private static int BUTTON_SIZE_Y = 130;
    private static int PLAYBUTTON_LOCATION_X = (WIDTH / 2) - (BUTTON_SIZE_X / 2);
    private static int PLAYBUTTON_LOCATION_Y = 325;
    private JButton optionsButton;
    private static int OPTIONSBUTTON_LOCATION_X = (WIDTH / 2) - (BUTTON_SIZE_X / 2);
    private static int OPTIONSBUTTON_LOCATION_Y = 450;
    private JButton statsButton;
    private static int STATSBUTTON_LOCATION_X = (WIDTH / 2) - (BUTTON_SIZE_X / 2);
    private static int STATSBUTTON_LOCATION_Y = 575;

    private JButton quitButton;
    private static int QUITBUTTON_SIZE_X = 100;
    private static int QUITBUTTON_SIZE_Y = 100;
    private static int QUITBUTTON_LOCATION_X = 20;
    private static int QUITBUTTON_LOCATION_Y = HEIGHT - QUITBUTTON_SIZE_Y - 50;

    private JButton nextButton;
    private static int NEXTBUTTON_SIZE_X = 100;
    private static int NEXTBUTTON_SIZE_Y = 100;
    private static int NEXTBUTTON_LOCATION_X = WIDTH - 35 - NEXTBUTTON_SIZE_X;
    private static int NEXTBUTTON_LOCATION_Y = HEIGHT - NEXTBUTTON_SIZE_Y - 50;

    private JButton birdSelectButton;
    private static int BIRDSELECTBUTTON_LOCATION_X = (WIDTH / 2) - (BUTTON_SIZE_X / 2);
    private static int BIRDSELECTBUTTON_LOCATION_Y = 225;
    private JButton scenerySelectButton;
    private static int SCENERYSELECTBUTTON_LOCATION_X = (WIDTH / 2) - (BUTTON_SIZE_X / 2);
    private static int SCENERYSELECTBUTTON_LOCATION_Y = 350;
    private JButton pipesSelectButton;
    private static int PIPESSELECTBUTTON_LOCATION_X = (WIDTH / 2) - (BUTTON_SIZE_X / 2);
    private static int PIPESSELECTBUTTON_LOCATION_Y = 475;

    private JButton left;
    private static int LEFT_RIGHT_BUTTON_SIZE_X = 100;
    private static int LEFT_RIGHT_BUTTON_SIZE_Y = 150;
    private static int LEFTBUTTON_LOCATION_X = WIDTH / 2 - LEFT_RIGHT_BUTTON_SIZE_X / 2 - 600;
    private static int LEFTBUTTON_LOCATION_Y = HEIGHT / 2 - LEFT_RIGHT_BUTTON_SIZE_Y / 2;
    private JButton right;
    private static int RIGHTBUTTON_LOCATION_X = WIDTH / 2 - LEFT_RIGHT_BUTTON_SIZE_X / 2 + 600;
    private static int RIGHTBUTTON_LOCATION_Y = HEIGHT / 2 - LEFT_RIGHT_BUTTON_SIZE_Y / 2;

    JLabel titleTableLabel;
    JLabel menuBirdLabel;
    JLabel table;
    JLabel scoreTable;
    JLabel menuTableLabel;
    JLabel bar1;
    JLabel bar2;
    JLabel bar3;
    JLabel bar4;
    JLabel bar5;
    JLabel bar6;
    JLabel goldMedal;
    JLabel silverMedal;
    JLabel bronzeMedal;

    private static int BAR_SIZE_X = 250;
    private static int BAR_SIZE_Y = 80;

    private int TABLE_SIZE_X = WIDTH - 280;
    private int TABLE_SIZE_Y = HEIGHT - 170;
    private int TABLE_LOCATION_X = WIDTH / 2 - TABLE_SIZE_X / 2 - 10;
    private int TABLE_LOCATION_Y = 30;

    private int SCORETABLE_SIZE_X = WIDTH - 200;
    private int SCORETABLE_SIZE_Y = HEIGHT - 130;
    private int SCORETABLE_LOCATION_X = WIDTH / 2 - SCORETABLE_SIZE_X / 2 - 50;
    private int SCORETABLE_LOCATION_Y = 50;

    private JButton birdButton1;
    private JButton birdButton2;
    private JButton birdButton3;
    private JButton birdButton4;
    private JButton birdButton5;
    private JButton birdButton6;
    private Color birdButtonColorBeforeClickOn = (new JButton().getBackground());
    private Color birdButtonAfterClickOn = new Color(85, 221, 255);
    private static final int BIRDBUTTON_SIZE_X = 80;
    private static final int BIRDBUTTON_SIZE_Y = 80;

    private JButton pipeButton1;
    private JButton pipeButton2;
    private JButton pipeButton3;
    private JButton pipeButton4;
    private JButton pipeButton5;
    private JButton pipeButton6;

    private Color pipeButtonColorBeforeClickOn = (new JButton().getBackground());
    private Color pipeButtonAfterClickOn = Color.RED;

    private JButton bgButton1;
    private JButton bgButton2;
    private JButton bgButton3;
    private JButton bgButton4;
    private JButton bgButton5;
    private JButton bgButton6;

    /**
     * Reprezentuje jednotlive druhy pozadia
     * 
     * @author team
     *
     */
    public enum BACKROUND_ICON {
	BG_ICON1, BG_ICON2, BG_ICON3, BG_ICON4, BG_ICON5, BG_ICON6, BG_ICON7
    }

    static BACKROUND_ICON bg = BACKROUND_ICON.BG_ICON1;
    URL urlBgIcon;
    ImageIcon bgIcon;

    JLabel backgroundIcon;
    JLabel menuBackground;
    JLabel menuBird;

    URL urlm = MetisBird.class.getResource("/resources/menuBackground.png");
    ImageIcon menuImage = new ImageIcon(
	    new ImageIcon(urlm).getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));

    /**
     * Konstruktor vytvara okno
     * 
     * @param WIDTH  sirka
     * @param HEIGHT vyska
     * @param title  nadpis
     */

    public Window(int WIDTH, int HEIGHT, String title) {
	Window.WIDTH = WIDTH;
	Window.HEIGHT = HEIGHT;
	this.title = title;

    }

//=============================================================================
//=================================== MENU1 ===================================
//=============================================================================
    /**
     * Spusta menu ktore je spustene ako prve okno po nastartovani aplikacie
     */
    public void runMenu1() {
	final MetisBird flappy = new MetisBird();

	openWindow(frame);
	panel = new JPanel();
	panel.setLayout(null);
	frame.add(panel);

	try {
	    BufferedImage buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/woodButton1.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(BUTTON_SIZE_X, BUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "PLAY";
	    playButton = new JButton(text, new ImageIcon(newImage));
	    playButton.setFont(new Font("Monospaced", Font.BOLD, 45));
	    playButton.setForeground(fontColor);
	    playButton.setVerticalTextPosition(SwingConstants.CENTER);
	    playButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    playButton.setOpaque(false);
	    playButton.setFocusPainted(false);
	    playButton.setBorderPainted(false);
	    playButton.setContentAreaFilled(false);
	    playButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    playButton.setBounds(PLAYBUTTON_LOCATION_X, PLAYBUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y);
	    panel.add(playButton);
	    playButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.NAME_SELECT);
		    frame.dispose();
		    ;
		}
	    });
	    playButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    playButton.setForeground(Color.white);
		}
	    });
	    playButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    playButton.setForeground(fontColor);
		}
	    });

	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    BufferedImage buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/woodButton2.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(BUTTON_SIZE_X, BUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "OPTIONS";
	    optionsButton = new JButton(text, new ImageIcon(newImage));
	    optionsButton.setFont(new Font("Monospaced", Font.BOLD, 45));
	    optionsButton.setForeground(fontColor);
	    optionsButton.setVerticalTextPosition(SwingConstants.CENTER);
	    optionsButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    optionsButton.setOpaque(false);
	    optionsButton.setFocusPainted(false);
	    optionsButton.setBorderPainted(false);
	    optionsButton.setContentAreaFilled(false);
	    optionsButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    optionsButton.setBounds(OPTIONSBUTTON_LOCATION_X, OPTIONSBUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y);
	    panel.add(optionsButton);
	    optionsButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.OPTIONS);
		    frame.dispose();
		    System.out.println("OPTIONS");
		    System.out.println(bird.getBirdType());
		    System.out.println(pipe.getPipeType());
		}
	    });
	    optionsButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    optionsButton.setForeground(Color.white);
		}
	    });
	    optionsButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    optionsButton.setForeground(fontColor);
		}
	    });
	} catch (

	IOException e1) {
	    e1.printStackTrace();
	}
	try {
	    Image buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/woodButton3.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(BUTTON_SIZE_X, BUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = " HIGHSCORE";
	    statsButton = new JButton(text, new ImageIcon(newImage));
	    statsButton.setFont(new Font("Monospaced", Font.BOLD, 45));
	    statsButton.setForeground(fontColor);
	    statsButton.setVerticalTextPosition(SwingConstants.CENTER);
	    statsButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    statsButton.setOpaque(false);
	    statsButton.setFocusPainted(false);
	    statsButton.setBorderPainted(false);
	    statsButton.setContentAreaFilled(false);
	    statsButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    statsButton.setBounds(STATSBUTTON_LOCATION_X, STATSBUTTON_LOCATION_Y, BUTTON_SIZE_X, BUTTON_SIZE_Y);
	    panel.add(statsButton);
	    statsButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.HIGHSCORE);
		    frame.dispose();
		    System.out.println("HIGHSCORE");
		    System.out.println(bird.getBirdType());
		    System.out.println(pipe.getPipeType());
		}
	    });
	    statsButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    statsButton.setForeground(Color.white);
		}
	    });
	    statsButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    statsButton.setForeground(fontColor);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    Image buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/backButton.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(QUITBUTTON_SIZE_X, QUITBUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "×";
	    quitButton = new JButton(text, new ImageIcon(newImage));
	    quitButton.setFont(new Font("SansSerif", Font.BOLD, 70));
	    quitButton.setForeground(Color.RED);
	    quitButton.setVerticalTextPosition(SwingConstants.CENTER);
	    quitButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    quitButton.setOpaque(false);
	    quitButton.setFocusPainted(false);
	    quitButton.setBorderPainted(false);
	    quitButton.setContentAreaFilled(false);
	    quitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    quitButton.setBounds(QUITBUTTON_LOCATION_X, QUITBUTTON_LOCATION_Y, QUITBUTTON_SIZE_X, QUITBUTTON_SIZE_Y);
	    panel.add(quitButton);
	    quitButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    frame.dispose();
		}
	    });
	    quitButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    quitButton.setForeground(Color.BLACK);
		}
	    });
	    quitButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    quitButton.setForeground(Color.RED);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	URL urlMenuBird = MetisBird.class.getResource("/resources/menuBird.png");
	ImageIcon menuBird = new ImageIcon(
		new ImageIcon(urlMenuBird).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH));
	menuBirdLabel = new JLabel(menuBird);
	menuBirdLabel.setBounds(WIDTH / 2 - 60, 223, 120, 120);
	menuBirdLabel.setLayout(null);
	panel.add(menuBirdLabel);

	URL urlMenuTable = MetisBird.class.getResource("/resources/metis.png");
	ImageIcon menuTable = new ImageIcon(
		new ImageIcon(urlMenuTable).getImage().getScaledInstance(700, 480, Image.SCALE_SMOOTH));
	menuTableLabel = new JLabel(menuTable);
	menuTableLabel.setBounds(WIDTH / 2 - 350, -100, 700, 480);
	menuTableLabel.setLayout(null);
	panel.add(menuTableLabel);

	menuBackground = new JLabel(menuImage);
	menuBackground.setSize(WIDTH, HEIGHT);
	menuBackground.setBounds(0, 0, WIDTH, HEIGHT);
	menuBackground.setLayout(null);
	panel.add(menuBackground);
	frame.setVisible(true);

    }

    // =============================================================================
    // ============================== SCENERY_SELECT ===============================
    // =============================================================================
    /**
     * Spusta okno v ktorom si uzivatel zvoli druh pozadia do hry
     */
    public void runScenerySelect() {
	final MetisBird flappy = new MetisBird();
	openWindow(frame);
	panel = new JPanel();
	panel.setLayout(null);
	frame.add(panel);
	try {
	    BufferedImage buttonIcon;
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/left.png");
	    buttonIcon = ImageIO.read(urlButtonIcon);
	    Image newImage = buttonIcon.getScaledInstance(LEFT_RIGHT_BUTTON_SIZE_X, LEFT_RIGHT_BUTTON_SIZE_Y,
		    Image.SCALE_SMOOTH);
	    String text = " ";
	    left = new JButton(text, new ImageIcon(newImage));
	    left.setVerticalTextPosition(SwingConstants.CENTER);
	    left.setHorizontalTextPosition(SwingConstants.CENTER);
	    left.setOpaque(false);
	    left.setFocusPainted(false);
	    left.setBorderPainted(false);
	    left.setContentAreaFilled(false);
	    left.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    left.setBounds(LEFTBUTTON_LOCATION_X, LEFTBUTTON_LOCATION_Y, LEFT_RIGHT_BUTTON_SIZE_X,
		    LEFT_RIGHT_BUTTON_SIZE_Y);
	    panel.add(left);
	    left.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setBackgroundIcon(1);
		    backgroundIcon.setIcon(getBackgroundIcon());
		}
	    });
	    left.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    left.setBounds(LEFTBUTTON_LOCATION_X - 10, LEFTBUTTON_LOCATION_Y, LEFT_RIGHT_BUTTON_SIZE_X,
			    LEFT_RIGHT_BUTTON_SIZE_Y);
		}
	    });
	    left.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    left.setBounds(LEFTBUTTON_LOCATION_X, LEFTBUTTON_LOCATION_Y, LEFT_RIGHT_BUTTON_SIZE_X,
			    LEFT_RIGHT_BUTTON_SIZE_Y);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    BufferedImage buttonIcon;
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/right.png");
	    buttonIcon = ImageIO.read(urlButtonIcon);
	    Image newImage = buttonIcon.getScaledInstance(LEFT_RIGHT_BUTTON_SIZE_X, LEFT_RIGHT_BUTTON_SIZE_Y,
		    Image.SCALE_SMOOTH);
	    String text = " ";
	    right = new JButton(text, new ImageIcon(newImage));
	    right.setVerticalTextPosition(SwingConstants.CENTER);
	    right.setHorizontalTextPosition(SwingConstants.CENTER);
	    right.setOpaque(false);
	    right.setFocusPainted(false);
	    right.setBorderPainted(false);
	    right.setContentAreaFilled(false);
	    right.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    right.setBounds(RIGHTBUTTON_LOCATION_X, RIGHTBUTTON_LOCATION_Y, LEFT_RIGHT_BUTTON_SIZE_X,
		    LEFT_RIGHT_BUTTON_SIZE_Y);
	    panel.add(right);
	    right.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setBackgroundIcon(2);
		    backgroundIcon.setIcon(getBackgroundIcon());
		}
	    });

	    right.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    right.setBounds(RIGHTBUTTON_LOCATION_X + 10, RIGHTBUTTON_LOCATION_Y, LEFT_RIGHT_BUTTON_SIZE_X,
			    LEFT_RIGHT_BUTTON_SIZE_Y);
		}
	    });
	    right.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    right.setBounds(RIGHTBUTTON_LOCATION_X, RIGHTBUTTON_LOCATION_Y, LEFT_RIGHT_BUTTON_SIZE_X,
			    LEFT_RIGHT_BUTTON_SIZE_Y);
		}
	    });
	} catch (

	IOException e1) {
	    e1.printStackTrace();
	}

	JLabel title = new JLabel("SELECT SCENERY");
	title.setLayout(null);
	title.setFont(new Font("Monospaced", Font.BOLD, 45));
	title.setForeground(fontColor);
	title.setSize(1000, 200);
	title.setLocation(WIDTH / 2 - 200, 0);
	panel.add(title);

	backgroundIcon = new JLabel(getBackgroundIcon());
	backgroundIcon.setLocation(0, -20);
	backgroundIcon.setSize(WIDTH, HEIGHT);
	backgroundIcon.setLayout(null);
	panel.add(backgroundIcon);

	URL urlImageIcon = MetisBird.class.getResource("/resources/table.png");
	ImageIcon imageIcon = new ImageIcon(new ImageIcon(urlImageIcon).getImage().getScaledInstance(TABLE_SIZE_X,
		TABLE_SIZE_Y, Image.SCALE_SMOOTH));
	table = new JLabel(imageIcon);
	table.setBounds(TABLE_LOCATION_X, TABLE_LOCATION_Y, TABLE_SIZE_X, TABLE_SIZE_Y);
	table.setLayout(null);
	panel.add(table);

	try {
	    BufferedImage buttonIcon;
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/backButton.png");
	    buttonIcon = ImageIO.read(urlButtonIcon);
	    Image newImage = buttonIcon.getScaledInstance(NEXTBUTTON_SIZE_X, NEXTBUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "✔";
	    nextButton = new JButton(text, new ImageIcon(newImage));
	    nextButton.setFont(new Font("SansSerif", Font.BOLD, 55));
	    nextButton.setForeground(Color.GREEN);
	    nextButton.setVerticalTextPosition(SwingConstants.CENTER);
	    nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    nextButton.setOpaque(false);
	    nextButton.setFocusPainted(false);
	    nextButton.setBorderPainted(false);
	    nextButton.setContentAreaFilled(false);
	    nextButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    nextButton.setBounds(NEXTBUTTON_LOCATION_X, NEXTBUTTON_LOCATION_Y, NEXTBUTTON_SIZE_X, NEXTBUTTON_SIZE_Y);
	    panel.add(nextButton);
	    nextButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.OPTIONS);
		    frame.dispose();

		}
	    });
	    nextButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    nextButton.setForeground(Color.BLACK);
		}
	    });
	    nextButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    nextButton.setForeground(Color.GREEN);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();

	}

	menuBackground = new JLabel(menuImage);
	menuBackground.setSize(WIDTH, HEIGHT);
	menuBackground.setBounds(0, 0, WIDTH, HEIGHT);
	menuBackground.setLayout(null);
	panel.add(menuBackground);
	frame.setVisible(true);
    }

    // =============================================================================
    // ============================== BIRD_SELECT ===============================
    // =============================================================================
    /**
     * Spusta okno v ktorom si uzivatel vybera druh vtacika s ktorym bude hrat
     */
    public void runBirdSelect() {
	final MetisBird flappy = new MetisBird();
	openWindow(frame);
	panel = new JPanel();
	panel.setLayout(null);
	frame.add(panel);

	JLabel title = new JLabel("SELECT YOUR BIRD");
	title.setLayout(null);
	title.setFont(new Font("Monospaced", Font.BOLD, 45));
	title.setForeground(fontColor);
	title.setSize(1000, 200);
	title.setLocation(WIDTH / 2 - 220, 0);
	panel.add(title);

	JLabel easy = new JLabel("EASY");
	easy.setLayout(null);
	easy.setFont(new Font("Monospaced", Font.BOLD, 30));
	easy.setForeground(new Color(17, 97, 17));
	easy.setBounds(370, 110, 200, 200);
	panel.add(easy);

	JLabel medium = new JLabel("MEDIUM");
	medium.setLayout(null);
	medium.setFont(new Font("Monospaced", Font.BOLD, 30));
	medium.setForeground(new Color(173, 102, 34));
	medium.setBounds(650, 110, 200, 200);
	panel.add(medium);

	JLabel hard = new JLabel("HARD");
	hard.setLayout(null);
	hard.setFont(new Font("Monospaced", Font.BOLD, 30));
	hard.setForeground(new Color(150, 36, 36));
	hard.setBounds(950, 110, 200, 200);
	panel.add(hard);
	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/bird1_button.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    birdButton1 = new JButton(new ImageIcon(buttonIcon));
	    birdButton1.setBounds(370, 250, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(birdButton1);
	    birdButton1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(birdButton1);

		    bird.setBirdType(BIRD.BIRD1);
		    System.out.println(bird.getBirdType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/bird2_button.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    birdButton2 = new JButton(new ImageIcon(buttonIcon));
	    birdButton2.setBounds(370, 440, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(birdButton2);
	    birdButton2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(birdButton2);
		    bird.setBirdType(BIRD.BIRD2);
		    System.out.println(bird.getBirdType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/bird3_button.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    birdButton3 = new JButton(new ImageIcon(buttonIcon));
	    birdButton3.setBounds(660, 250, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(birdButton3);
	    birdButton3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(birdButton3);
		    bird.setBirdType(BIRD.BIRD3);
		    System.out.println(bird.getBirdType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/bird4_button.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    birdButton4 = new JButton(new ImageIcon(buttonIcon));
	    birdButton4.setBounds(660, 440, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(birdButton4);
	    birdButton4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(birdButton4);
		    bird.setBirdType(BIRD.BIRD4);
		    System.out.println(bird.getBirdType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/bird5_button.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    birdButton5 = new JButton(new ImageIcon(buttonIcon));
	    birdButton5.setBounds(950, 250, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(birdButton5);
	    birdButton5.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(birdButton5);
		    bird.setBirdType(BIRD.BIRD5);
		    System.out.println(bird.getBirdType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/bird6_button.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    birdButton6 = new JButton(new ImageIcon(buttonIcon));
	    birdButton6.setBounds(950, 440, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(birdButton6);
	    birdButton6.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(birdButton6);
		    bird.setBirdType(BIRD.BIRD6);
		    System.out.println(bird.getBirdType());

		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	URL urlBarIcon1 = MetisBird.class.getResource("/resources/bar1.png");
	ImageIcon barIcon1 = new ImageIcon(
		new ImageIcon(urlBarIcon1).getImage().getScaledInstance(BAR_SIZE_X, BAR_SIZE_Y, Image.SCALE_SMOOTH));
	bar1 = new JLabel(barIcon1);
	bar1.setBounds(280, 340, BAR_SIZE_X, BAR_SIZE_Y);
	bar1.setLayout(null);
	panel.add(bar1);

	URL urlBarIcon2 = MetisBird.class.getResource("/resources/bar2.png");
	ImageIcon barIcon2 = new ImageIcon(
		new ImageIcon(urlBarIcon2).getImage().getScaledInstance(BAR_SIZE_X, BAR_SIZE_Y, Image.SCALE_SMOOTH));
	bar2 = new JLabel(barIcon2);
	bar2.setBounds(280, 530, BAR_SIZE_X, BAR_SIZE_Y);
	bar2.setLayout(null);
	panel.add(bar2);

	URL urlBarIcon3 = MetisBird.class.getResource("/resources/bar3.png");
	ImageIcon barIcon3 = new ImageIcon(
		new ImageIcon(urlBarIcon3).getImage().getScaledInstance(BAR_SIZE_X, BAR_SIZE_Y, Image.SCALE_SMOOTH));
	bar3 = new JLabel(barIcon3);
	bar3.setBounds(570, 340, BAR_SIZE_X, BAR_SIZE_Y);
	bar3.setLayout(null);
	panel.add(bar3);

	URL urlBarIcon4 = MetisBird.class.getResource("/resources/bar4.png");
	ImageIcon barIcon4 = new ImageIcon(
		new ImageIcon(urlBarIcon4).getImage().getScaledInstance(BAR_SIZE_X, BAR_SIZE_Y, Image.SCALE_SMOOTH));
	bar4 = new JLabel(barIcon4);
	bar4.setBounds(570, 530, BAR_SIZE_X, BAR_SIZE_Y);
	bar4.setLayout(null);
	panel.add(bar4);

	URL urlBarIcon5 = MetisBird.class.getResource("/resources/bar5.png");
	ImageIcon barIcon5 = new ImageIcon(
		new ImageIcon(urlBarIcon5).getImage().getScaledInstance(BAR_SIZE_X, BAR_SIZE_Y, Image.SCALE_SMOOTH));
	bar5 = new JLabel(barIcon5);
	bar5.setBounds(860, 340, BAR_SIZE_X, BAR_SIZE_Y);
	bar5.setLayout(null);
	panel.add(bar5);

	URL urlBarIcon6 = MetisBird.class.getResource("/resources/bar6.png");
	ImageIcon barIcon6 = new ImageIcon(
		new ImageIcon(urlBarIcon6).getImage().getScaledInstance(BAR_SIZE_X, BAR_SIZE_Y, Image.SCALE_SMOOTH));
	bar6 = new JLabel(barIcon6);
	bar6.setBounds(860, 530, BAR_SIZE_X, BAR_SIZE_Y);
	bar6.setLayout(null);
	panel.add(bar6);

	URL urlImageIcon = MetisBird.class.getResource("/resources/table2.png");
	ImageIcon imageIcon = new ImageIcon(new ImageIcon(urlImageIcon).getImage().getScaledInstance(TABLE_SIZE_X,
		TABLE_SIZE_Y, Image.SCALE_SMOOTH));
	table = new JLabel(imageIcon);
	table.setBounds(TABLE_LOCATION_X, TABLE_LOCATION_Y, TABLE_SIZE_X, TABLE_SIZE_Y);
	table.setLayout(null);
	panel.add(table);

	try {
	    BufferedImage buttonIcon;
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/backButton.png");
	    buttonIcon = ImageIO.read(urlButtonIcon);
	    Image newImage = buttonIcon.getScaledInstance(NEXTBUTTON_SIZE_X, NEXTBUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "✔";
	    nextButton = new JButton(text, new ImageIcon(newImage));
	    nextButton.setFont(new Font("SansSerif", Font.BOLD, 55));
	    nextButton.setForeground(Color.GREEN);
	    nextButton.setVerticalTextPosition(SwingConstants.CENTER);
	    nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    nextButton.setOpaque(false);
	    nextButton.setFocusPainted(false);
	    nextButton.setBorderPainted(false);
	    nextButton.setContentAreaFilled(false);
	    nextButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    nextButton.setBounds(NEXTBUTTON_LOCATION_X, NEXTBUTTON_LOCATION_Y, NEXTBUTTON_SIZE_X, NEXTBUTTON_SIZE_Y);
	    panel.add(nextButton);
	    nextButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.OPTIONS);
		    frame.dispose();

		}
	    });
	    nextButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    nextButton.setForeground(Color.BLACK);
		}
	    });
	    nextButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    nextButton.setForeground(Color.GREEN);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();

	}

	menuBackground = new JLabel(menuImage);
	menuBackground.setSize(WIDTH, HEIGHT);
	menuBackground.setBounds(0, 0, WIDTH, HEIGHT);
	menuBackground.setLayout(null);
	panel.add(menuBackground);
	frame.setVisible(true);
    }

    // =============================================================================
    // ============================== PIPES_SELECT ===============================
    // =============================================================================
    /**
     * Spusta okno v ktorom si uzivatel vybera aky druh prekazok chce mat v hre
     */
    public void runPipesSelect() {
	final MetisBird flappy = new MetisBird();
	openWindow(frame);
	panel = new JPanel();
	panel.setLayout(null);
	frame.add(panel);

	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/TubeAquamarin.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    pipeButton1 = new JButton(new ImageIcon(buttonIcon));
	    pipeButton1.setBounds(370, 250, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(pipeButton1);
	    pipeButton1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(pipeButton1);

		    pipe.setPipeType(PIPES.PIPE1);
		    System.out.println(pipe.getPipeType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/TubeViolet.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    pipeButton2 = new JButton(new ImageIcon(buttonIcon));
	    pipeButton2.setBounds(370, 440, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(pipeButton2);
	    pipeButton2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(pipeButton2);

		    pipe.setPipeType(PIPES.PIPE2);
		    System.out.println(pipe.getPipeType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/TubeGold.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    pipeButton3 = new JButton(new ImageIcon(buttonIcon));
	    pipeButton3.setBounds(660, 250, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(pipeButton3);
	    pipeButton3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(pipeButton3);

		    pipe.setPipeType(PIPES.PIPE3);
		    System.out.println(pipe.getPipeType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/TubeSilver.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    pipeButton4 = new JButton(new ImageIcon(buttonIcon));
	    pipeButton4.setBounds(660, 440, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(pipeButton4);
	    pipeButton4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(pipeButton4);

		    pipe.setPipeType(PIPES.PIPE4);
		    System.out.println(pipe.getPipeType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/TubeGreen.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    pipeButton5 = new JButton(new ImageIcon(buttonIcon));
	    pipeButton5.setBounds(950, 250, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(pipeButton5);
	    pipeButton5.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(pipeButton5);

		    pipe.setPipeType(PIPES.PIPE5);
		    System.out.println(pipe.getPipeType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/TubeBlue.png");
	    BufferedImage buttonIcon = ImageIO.read(urlButtonIcon);
	    System.out.println("IMPUT ok");
	    pipeButton6 = new JButton(new ImageIcon(buttonIcon));
	    pipeButton6.setBounds(950, 440, BIRDBUTTON_SIZE_X, BIRDBUTTON_SIZE_Y);
	    panel.add(pipeButton6);
	    pipeButton6.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    setButtonColorAfterClickOn(pipeButton6);

		    pipe.setPipeType(PIPES.PIPE6);
		    System.out.println(pipe.getPipeType());
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	JLabel title = new JLabel("SELECT PIPES COLOR");
	title.setLayout(null);
	title.setFont(new Font("Monospaced", Font.BOLD, 45));
	title.setForeground(fontColor);
	title.setSize(1000, 200);
	title.setLocation(WIDTH / 2 - 245, 0);
	panel.add(title);

	URL urlImageIcon = MetisBird.class.getResource("/resources/table.png");
	ImageIcon imageIcon = new ImageIcon(new ImageIcon(urlImageIcon).getImage().getScaledInstance(TABLE_SIZE_X,
		TABLE_SIZE_Y, Image.SCALE_SMOOTH));
	table = new JLabel(imageIcon);
	table.setBounds(TABLE_LOCATION_X, TABLE_LOCATION_Y, TABLE_SIZE_X, TABLE_SIZE_Y);
	table.setLayout(null);
	panel.add(table);

	try {
	    BufferedImage buttonIcon;
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/backButton.png");
	    buttonIcon = ImageIO.read(urlButtonIcon);
	    Image newImage = buttonIcon.getScaledInstance(NEXTBUTTON_SIZE_X, NEXTBUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "✔";
	    nextButton = new JButton(text, new ImageIcon(newImage));
	    nextButton.setFont(new Font("SansSerif", Font.BOLD, 55));
	    nextButton.setForeground(Color.GREEN);
	    nextButton.setVerticalTextPosition(SwingConstants.CENTER);
	    nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    nextButton.setOpaque(false);
	    nextButton.setFocusPainted(false);
	    nextButton.setBorderPainted(false);
	    nextButton.setContentAreaFilled(false);
	    nextButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    nextButton.setBounds(NEXTBUTTON_LOCATION_X, NEXTBUTTON_LOCATION_Y, NEXTBUTTON_SIZE_X, NEXTBUTTON_SIZE_Y);
	    panel.add(nextButton);
	    nextButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.OPTIONS);
		    frame.dispose();

		}
	    });
	    nextButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    nextButton.setForeground(Color.BLACK);
		}
	    });
	    nextButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    nextButton.setForeground(Color.GREEN);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();

	}

	menuBackground = new JLabel(menuImage);
	menuBackground.setSize(WIDTH, HEIGHT);
	menuBackground.setBounds(0, 0, WIDTH, HEIGHT);
	menuBackground.setLayout(null);
	panel.add(menuBackground);
	frame.setVisible(true);
    }

    // =============================================================================
    // ================================== NAME_SELECT ==========================
    // =============================================================================
    /**
     * Spusta okno v ktorom uzivatel zadava svoje meno
     */
    public void runNameSelect() {
	final MetisBird flappy = new MetisBird();
	openWindow(frame);
	panel = new JPanel();
	panel.setLayout(null);
	frame.add(panel);

	textField.setFont(new Font("Monospaced", Font.CENTER_BASELINE, 50));
	textField.setBounds(WIDTH / 2 - 220, HEIGHT / 2 - 155, 400, 150);
	textField.setForeground(fontColor);
	textField.setBackground(new Color(252, 177, 120));
	textField.setHorizontalAlignment(JTextField.CENTER);
	textField.addFocusListener(new FocusListener() {
	    public void focusGained(FocusEvent e) {
		// textField.setText("");
	    }

	    public void focusLost(FocusEvent e) {
	    }
	});
	panel.add(textField);

	URL urlImageIcon = MetisBird.class.getResource("/resources/nameTable.png");
	ImageIcon imageIcon = new ImageIcon(
		new ImageIcon(urlImageIcon).getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH));
	table = new JLabel(imageIcon);
	table.setBounds(WIDTH / 2 - 350, TABLE_LOCATION_Y + 60, 700, 500);
	table.setLayout(null);
	panel.add(table);
	try {
	    BufferedImage buttonIcon;
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/backButton.png");
	    buttonIcon = ImageIO.read(urlButtonIcon);
	    Image newImage = buttonIcon.getScaledInstance(NEXTBUTTON_SIZE_X, NEXTBUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "✔";
	    nextButton = new JButton(text, new ImageIcon(newImage));
	    nextButton.setFont(new Font("SansSerif", Font.BOLD, 55));
	    nextButton.setForeground(Color.GREEN);
	    nextButton.setVerticalTextPosition(SwingConstants.CENTER);
	    nextButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    nextButton.setOpaque(false);
	    nextButton.setFocusPainted(false);
	    nextButton.setBorderPainted(false);
	    nextButton.setContentAreaFilled(false);
	    nextButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    nextButton.setBounds(NEXTBUTTON_LOCATION_X, NEXTBUTTON_LOCATION_Y, NEXTBUTTON_SIZE_X, NEXTBUTTON_SIZE_Y);
	    panel.add(nextButton);
	    nextButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    playerName = textField.getText();
		    flappy.setName(playerName);
		    flappy.setState(STATE.GAME);
		    frame.dispose();

		}
	    });
	    nextButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    nextButton.setForeground(Color.BLACK);
		}
	    });
	    nextButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    nextButton.setForeground(Color.GREEN);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();

	}
	try {
	    Image buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/backButton.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(QUITBUTTON_SIZE_X, QUITBUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "×";
	    quitButton = new JButton(text, new ImageIcon(newImage));
	    quitButton.setFont(new Font("SansSerif", Font.BOLD, 70));
	    quitButton.setForeground(Color.RED);
	    quitButton.setVerticalTextPosition(SwingConstants.CENTER);
	    quitButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    quitButton.setOpaque(false);
	    quitButton.setFocusPainted(false);
	    quitButton.setBorderPainted(false);
	    quitButton.setContentAreaFilled(false);
	    quitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    quitButton.setBounds(QUITBUTTON_LOCATION_X, QUITBUTTON_LOCATION_Y, QUITBUTTON_SIZE_X, QUITBUTTON_SIZE_Y);
	    panel.add(quitButton);
	    quitButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.MENU1);
		    frame.dispose();
		}
	    });
	    quitButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    quitButton.setForeground(Color.BLACK);
		}
	    });
	    quitButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    quitButton.setForeground(Color.RED);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	menuBackground = new JLabel(menuImage);
	menuBackground.setSize(WIDTH, HEIGHT);
	menuBackground.setBounds(0, 0, WIDTH, HEIGHT);
	menuBackground.setLayout(null);
	panel.add(menuBackground);
	frame.setVisible(true);
    }

    // =============================================================================
    // ================================== OPTIONS ==================================
    // =============================================================================
    /**
     * Spusta okno v ktorom sa nachadzaju nastavenia hry
     */
    public void runOptions() {
	final MetisBird flappy = new MetisBird();
	openWindow(frame);
	panel = new JPanel();
	panel.setLayout(null);
	frame.add(panel);

	JLabel title = new JLabel("OPTIONS");
	title.setLayout(null);
	title.setFont(new Font("Monospaced", Font.ITALIC, 45));
	title.setForeground(fontColor);
	title.setBounds(WIDTH / 2 - 100, -12, 200, 100);
	panel.add(title);

	URL urlTitleTable = MetisBird.class.getResource("/resources/woodTable.png");
	ImageIcon titleTable = new ImageIcon(
		new ImageIcon(urlTitleTable).getImage().getScaledInstance(500, 60, Image.SCALE_SMOOTH));
	titleTableLabel = new JLabel(titleTable);
	titleTableLabel.setBounds(WIDTH / 2 - 250, 10, 500, 60);
	titleTableLabel.setLayout(null);
	panel.add(titleTableLabel);

	try {
	    BufferedImage buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/woodButton6.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(BUTTON_SIZE_X, BUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "BIRD";
	    birdSelectButton = new JButton(text, new ImageIcon(newImage));
	    birdSelectButton.setFont(new Font("Monospaced", Font.BOLD, 45));
	    birdSelectButton.setForeground(fontColor);
	    birdSelectButton.setVerticalTextPosition(SwingConstants.CENTER);
	    birdSelectButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    birdSelectButton.setOpaque(false);
	    birdSelectButton.setFocusPainted(false);
	    birdSelectButton.setBorderPainted(false);
	    birdSelectButton.setContentAreaFilled(false);
	    birdSelectButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    birdSelectButton.setBounds(BIRDSELECTBUTTON_LOCATION_X, BIRDSELECTBUTTON_LOCATION_Y, BUTTON_SIZE_X,
		    BUTTON_SIZE_Y);
	    panel.add(birdSelectButton);
	    birdSelectButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.BIRD_SELECT);
		    frame.dispose();

		}
	    });
	    birdSelectButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    birdSelectButton.setForeground(Color.white);
		}
	    });
	    birdSelectButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    birdSelectButton.setForeground(fontColor);
		}
	    });

	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    BufferedImage buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/woodButton4.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(BUTTON_SIZE_X, BUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "SCENERY";
	    scenerySelectButton = new JButton(text, new ImageIcon(newImage));
	    scenerySelectButton.setFont(new Font("Monospaced", Font.BOLD, 45));
	    scenerySelectButton.setForeground(fontColor);
	    scenerySelectButton.setVerticalTextPosition(SwingConstants.CENTER);
	    scenerySelectButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    scenerySelectButton.setOpaque(false);
	    scenerySelectButton.setFocusPainted(false);
	    scenerySelectButton.setBorderPainted(false);
	    scenerySelectButton.setContentAreaFilled(false);
	    scenerySelectButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    scenerySelectButton.setBounds(SCENERYSELECTBUTTON_LOCATION_X, SCENERYSELECTBUTTON_LOCATION_Y, BUTTON_SIZE_X,
		    BUTTON_SIZE_Y);
	    panel.add(scenerySelectButton);
	    scenerySelectButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.SCENERY_SELECT);
		    frame.dispose();
		}
	    });
	    scenerySelectButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    scenerySelectButton.setForeground(Color.white);
		}
	    });
	    scenerySelectButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    scenerySelectButton.setForeground(fontColor);
		}
	    });
	} catch (

	IOException e1) {
	    e1.printStackTrace();
	}
	try {
	    Image buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/woodButton5.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(BUTTON_SIZE_X, BUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "PIPES";
	    pipesSelectButton = new JButton(text, new ImageIcon(newImage));
	    pipesSelectButton.setFont(new Font("Monospaced", Font.BOLD, 45));
	    pipesSelectButton.setForeground(fontColor);
	    pipesSelectButton.setVerticalTextPosition(SwingConstants.CENTER);
	    pipesSelectButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    pipesSelectButton.setOpaque(false);
	    pipesSelectButton.setFocusPainted(false);
	    pipesSelectButton.setBorderPainted(false);
	    pipesSelectButton.setContentAreaFilled(false);
	    pipesSelectButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    pipesSelectButton.setBounds(PIPESSELECTBUTTON_LOCATION_X, PIPESSELECTBUTTON_LOCATION_Y, BUTTON_SIZE_X,
		    BUTTON_SIZE_Y);
	    panel.add(pipesSelectButton);
	    pipesSelectButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.PIPES_SELECT);
		    frame.dispose();

		}
	    });
	    pipesSelectButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    pipesSelectButton.setForeground(Color.white);
		}
	    });
	    pipesSelectButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    pipesSelectButton.setForeground(fontColor);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}

	try {
	    Image buttonIcon;
	    URL url = MetisBird.class.getResource("/resources/backButton.png");
	    buttonIcon = ImageIO.read(url);
	    Image newImage = buttonIcon.getScaledInstance(QUITBUTTON_SIZE_X, QUITBUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "×";
	    quitButton = new JButton(text, new ImageIcon(newImage));
	    quitButton.setFont(new Font("SansSerif", Font.BOLD, 70));
	    quitButton.setForeground(Color.RED);
	    quitButton.setVerticalTextPosition(SwingConstants.CENTER);
	    quitButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    quitButton.setOpaque(false);
	    quitButton.setFocusPainted(false);
	    quitButton.setBorderPainted(false);
	    quitButton.setContentAreaFilled(false);
	    quitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    quitButton.setBounds(QUITBUTTON_LOCATION_X, QUITBUTTON_LOCATION_Y, QUITBUTTON_SIZE_X, QUITBUTTON_SIZE_Y);
	    panel.add(quitButton);
	    quitButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.MENU1);
		    frame.dispose();
		}
	    });
	    quitButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    quitButton.setForeground(Color.BLACK);
		}
	    });
	    quitButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    quitButton.setForeground(Color.RED);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();
	}
	menuBackground = new JLabel(menuImage);
	menuBackground.setSize(WIDTH, HEIGHT);
	menuBackground.setBounds(0, 0, WIDTH, HEIGHT);
	menuBackground.setLayout(null);
	panel.add(menuBackground);
	frame.setVisible(true);

    }

    // ==========================================================================
    // =================================== HIGHSCORE ============================
    // ==========================================================================
    /**
     * Spusta okno v ktorom sa nachadza rebricek 10 najlepsich hracov hry
     */
    public void runHighscore() {
	final MetisBird flappy = new MetisBird();
	openWindow(frame);
	panel = new JPanel();
	panel.setLayout(null);
	frame.add(panel);

	JLabel title = new JLabel("HIGHSCORE");
	title.setLayout(null);
	title.setFont(new Font("Monospaced", Font.ITALIC, 45));
	title.setForeground(fontColor);
	title.setBounds(WIDTH / 2 - 125, -12, 250, 100);
	panel.add(title);

	URL urlTitleTable = MetisBird.class.getResource("/resources/woodTable.png");
	ImageIcon titleTable = new ImageIcon(
		new ImageIcon(urlTitleTable).getImage().getScaledInstance(500, 60, Image.SCALE_SMOOTH));
	titleTableLabel = new JLabel(titleTable);
	titleTableLabel.setBounds(WIDTH / 2 - 250, 10, 500, 60);
	titleTableLabel.setLayout(null);
	panel.add(titleTableLabel);

	try {
	    BufferedImage buttonIcon;
	    URL urlButtonIcon = MetisBird.class.getResource("/resources/backButton.png");
	    buttonIcon = ImageIO.read(urlButtonIcon);
	    Image newImage = buttonIcon.getScaledInstance(QUITBUTTON_SIZE_X, QUITBUTTON_SIZE_Y, Image.SCALE_SMOOTH);
	    String text = "×";
	    quitButton = new JButton(text, new ImageIcon(newImage));
	    quitButton.setFont(new Font("SansSerif", Font.BOLD, 70));
	    quitButton.setForeground(Color.RED);
	    quitButton.setVerticalTextPosition(SwingConstants.CENTER);
	    quitButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    quitButton.setOpaque(false);
	    quitButton.setFocusPainted(false);
	    quitButton.setBorderPainted(false);
	    quitButton.setContentAreaFilled(false);
	    quitButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    quitButton.setBounds(QUITBUTTON_LOCATION_X, QUITBUTTON_LOCATION_Y, QUITBUTTON_SIZE_X, QUITBUTTON_SIZE_Y);
	    panel.add(quitButton);
	    quitButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		    flappy.setState(STATE.MENU1);
		    frame.dispose();

		}
	    });
	    quitButton.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
		    quitButton.setForeground(Color.BLACK);
		}
	    });
	    quitButton.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent arg0) {
		    quitButton.setForeground(Color.RED);
		}
	    });
	} catch (IOException e1) {
	    e1.printStackTrace();

	}
	URL urlGoldMedalIcon = MetisBird.class.getResource("/resources/gold.png");
	ImageIcon goldMedalIcon = new ImageIcon(
		new ImageIcon(urlGoldMedalIcon).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	goldMedal = new JLabel(goldMedalIcon);
	goldMedal.setBounds(WIDTH / 2 - 270, 140, 50, 50);
	goldMedal.setLayout(null);
	panel.add(goldMedal);

	URL urlSilverMedalIcon = MetisBird.class.getResource("/resources/silver.png");
	ImageIcon silverMedalIcon = new ImageIcon(
		new ImageIcon(urlSilverMedalIcon).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	silverMedal = new JLabel(silverMedalIcon);
	silverMedal.setBounds(WIDTH / 2 - 270, 189, 50, 50);
	silverMedal.setLayout(null);
	panel.add(silverMedal);

	URL urlBronzeMedalIcon = MetisBird.class.getResource("/resources/bronze.png");
	ImageIcon bronzeMedalIcon = new ImageIcon(
		new ImageIcon(urlBronzeMedalIcon).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	bronzeMedal = new JLabel(bronzeMedalIcon);
	bronzeMedal.setBounds(WIDTH / 2 - 270, 238, 50, 50);
	bronzeMedal.setLayout(null);
	panel.add(bronzeMedal);
	JLabel score1 = new JLabel("1. " + player.getPlayerAtIndex(0));
	score1.setLayout(null);
	score1.setFont(new Font("Monospaced", Font.BOLD, 35));
	score1.setForeground(fontColor);
	score1.setBounds(WIDTH / 2 - 200, 140, 1000, 40);
	panel.add(score1);

	JLabel score2 = new JLabel("2. " + player.getPlayerAtIndex(1));
	score2.setLayout(null);
	score2.setFont(new Font("Monospaced", Font.BOLD, 35));
	score2.setForeground(fontColor);
	score2.setBounds(WIDTH / 2 - 200, 189, 1000, 40);
	panel.add(score2);

	JLabel score3 = new JLabel("3. " + player.getPlayerAtIndex(2));
	score3.setLayout(null);
	score3.setFont(new Font("Monospaced", Font.BOLD, 35));
	score3.setForeground(fontColor);
	score3.setBounds(WIDTH / 2 - 200, 238, 1000, 40);
	panel.add(score3);

	JLabel score4 = new JLabel("4. " + player.getPlayerAtIndex(3));
	score4.setLayout(null);
	score4.setFont(new Font("Monospaced", Font.TRUETYPE_FONT, 35));
	score4.setForeground(fontColor);
	score4.setBounds(WIDTH / 2 - 200, 287, 1000, 40);
	panel.add(score4);

	JLabel score5 = new JLabel("5. " + player.getPlayerAtIndex(4));
	score5.setLayout(null);
	score5.setFont(new Font("Monospaced", Font.TRUETYPE_FONT, 35));
	score5.setForeground(fontColor);
	score5.setBounds(WIDTH / 2 - 200, 336, 1000, 40);
	panel.add(score5);

	JLabel score6 = new JLabel("6. " + player.getPlayerAtIndex(5));
	score6.setLayout(null);
	score6.setFont(new Font("Monospaced", Font.TRUETYPE_FONT, 35));
	score6.setForeground(fontColor);
	score6.setBounds(WIDTH / 2 - 200, 385, 1000, 40);
	panel.add(score6);

	JLabel score7 = new JLabel("7. " + player.getPlayerAtIndex(6));
	score7.setLayout(null);
	score7.setFont(new Font("Monospaced", Font.TRUETYPE_FONT, 35));
	score7.setForeground(fontColor);
	score7.setBounds(WIDTH / 2 - 200, 434, 1000, 40);
	panel.add(score7);

	JLabel score8 = new JLabel("8. " + player.getPlayerAtIndex(7));
	score8.setLayout(null);
	score8.setFont(new Font("Monospaced", Font.TRUETYPE_FONT, 35));
	score8.setForeground(fontColor);
	score8.setBounds(WIDTH / 2 - 200, 483, 1000, 40);
	panel.add(score8);

	JLabel score9 = new JLabel("9. " + player.getPlayerAtIndex(8));
	score9.setLayout(null);
	score9.setFont(new Font("Monospaced", Font.TRUETYPE_FONT, 35));
	score9.setForeground(fontColor);
	score9.setBounds(WIDTH / 2 - 200, 532, 1000, 40);
	panel.add(score9);

	JLabel score10 = new JLabel("10. " + player.getPlayerAtIndex(9));
	score10.setLayout(null);
	score10.setFont(new Font("Monospaced", Font.TRUETYPE_FONT, 35));
	score10.setForeground(fontColor);
	score10.setBounds(WIDTH / 2 - 220, 581, 1000, 40);
	panel.add(score10);

	URL urlImageIcon = MetisBird.class.getResource("/resources/scoreTable.png");
	ImageIcon imageIcon = new ImageIcon(new ImageIcon(urlImageIcon).getImage().getScaledInstance(SCORETABLE_SIZE_X,
		SCORETABLE_SIZE_Y, Image.SCALE_SMOOTH));
	table = new JLabel(imageIcon);
	table.setBounds(SCORETABLE_LOCATION_X, SCORETABLE_LOCATION_Y, SCORETABLE_SIZE_X, SCORETABLE_SIZE_Y);
	table.setLayout(null);
	panel.add(table);

	menuBackground = new JLabel(menuImage);
	menuBackground.setSize(WIDTH, HEIGHT);
	menuBackground.setBounds(0, 0, WIDTH, HEIGHT);
	menuBackground.setLayout(null);
	panel.add(menuBackground);
	frame.setVisible(true);

    }

    /**
     * Nastavuje obrazok pozadia v menu
     * 
     * @param i hodnota podla ktorej sa nastavuje pozadie do hry . Ak i=1 tak sa
     *          nastavi predchadzajuce pozadie , ak i=2 tak sa nastavi dalsie
     *          pozadie v poradi.
     */
    public void setBackgroundIcon(int i) {
	// 1=previus
	// 2=next
	if (i == 2) {
	    if (bg == BACKROUND_ICON.BG_ICON1) {
		bg = BACKROUND_ICON.BG_ICON2;
		Background.bgType = BACKGROUNDS.BACKGROUND2;
	    } else if (bg == BACKROUND_ICON.BG_ICON2) {
		bg = BACKROUND_ICON.BG_ICON3;
		Background.bgType = BACKGROUNDS.BACKGROUND3;
	    } else if (bg == BACKROUND_ICON.BG_ICON3) {
		bg = BACKROUND_ICON.BG_ICON4;
		Background.bgType = BACKGROUNDS.BACKGROUND4;
	    } else if (bg == BACKROUND_ICON.BG_ICON4) {
		bg = BACKROUND_ICON.BG_ICON5;
		Background.bgType = BACKGROUNDS.BACKGROUND5;
	    } else if (bg == BACKROUND_ICON.BG_ICON5) {
		bg = BACKROUND_ICON.BG_ICON6;
		Background.bgType = BACKGROUNDS.BACKGROUND6;
	    } else if (bg == BACKROUND_ICON.BG_ICON6) {
		bg = BACKROUND_ICON.BG_ICON7;
		Background.bgType = BACKGROUNDS.BACKGROUND7;
	    } else if (bg == BACKROUND_ICON.BG_ICON7) {
		bg = BACKROUND_ICON.BG_ICON1;
		Background.bgType = BACKGROUNDS.BACKGROUND1;
	    }

	} else if (i == 1) {
	    if (bg == BACKROUND_ICON.BG_ICON1) {
		bg = BACKROUND_ICON.BG_ICON7;
		Background.bgType = BACKGROUNDS.BACKGROUND7;
	    } else if (bg == BACKROUND_ICON.BG_ICON2) {
		bg = BACKROUND_ICON.BG_ICON1;
		Background.bgType = BACKGROUNDS.BACKGROUND1;
	    } else if (bg == BACKROUND_ICON.BG_ICON3) {
		bg = BACKROUND_ICON.BG_ICON2;
		Background.bgType = BACKGROUNDS.BACKGROUND2;
	    } else if (bg == BACKROUND_ICON.BG_ICON4) {
		bg = BACKROUND_ICON.BG_ICON3;
		Background.bgType = BACKGROUNDS.BACKGROUND3;
	    } else if (bg == BACKROUND_ICON.BG_ICON5) {
		bg = BACKROUND_ICON.BG_ICON4;
		Background.bgType = BACKGROUNDS.BACKGROUND4;
	    } else if (bg == BACKROUND_ICON.BG_ICON6) {
		bg = BACKROUND_ICON.BG_ICON5;
		Background.bgType = BACKGROUNDS.BACKGROUND5;
	    } else if (bg == BACKROUND_ICON.BG_ICON7) {
		bg = BACKROUND_ICON.BG_ICON6;
		Background.bgType = BACKGROUNDS.BACKGROUND6;
	    }

	}
    }

    /**
     * Metoda vracia obrazok pozadia podla aktualneho stavu
     * 
     * @return vracia obrazok pozadia
     */
    public ImageIcon getBackgroundIcon() {

	if (bg == BACKROUND_ICON.BG_ICON1) {
	    urlBgIcon = MetisBird.class.getResource("/resources/BACKGROUND1.png");
	    bgIcon = new ImageIcon(new ImageIcon(urlBgIcon).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH));
	    return bgIcon;
	} else if (bg == BACKROUND_ICON.BG_ICON2) {
	    urlBgIcon = MetisBird.class.getResource("/resources/BACKGROUND2.png");
	    bgIcon = new ImageIcon(new ImageIcon(urlBgIcon).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH));
	    return bgIcon;
	} else if (bg == BACKROUND_ICON.BG_ICON3) {
	    urlBgIcon = MetisBird.class.getResource("/resources/BACKGROUND3.png");
	    bgIcon = new ImageIcon(new ImageIcon(urlBgIcon).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH));
	    return bgIcon;
	} else if (bg == BACKROUND_ICON.BG_ICON4) {
	    urlBgIcon = MetisBird.class.getResource("/resources/BACKGROUND4.png");
	    bgIcon = new ImageIcon(new ImageIcon(urlBgIcon).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH));
	    return bgIcon;
	} else if (bg == BACKROUND_ICON.BG_ICON5) {
	    urlBgIcon = MetisBird.class.getResource("/resources/BACKGROUND5.png");
	    bgIcon = new ImageIcon(new ImageIcon(urlBgIcon).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH));
	    return bgIcon;
	} else if (bg == BACKROUND_ICON.BG_ICON6) {
	    urlBgIcon = MetisBird.class.getResource("/resources/BACKGROUND6.png");
	    bgIcon = new ImageIcon(new ImageIcon(urlBgIcon).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH));
	    return bgIcon;
	} else if (bg == BACKROUND_ICON.BG_ICON7) {
	    urlBgIcon = MetisBird.class.getResource("/resources/BACKGROUND7.png");
	    bgIcon = new ImageIcon(new ImageIcon(urlBgIcon).getImage().getScaledInstance(800, 400, Image.SCALE_SMOOTH));
	    return bgIcon;
	}
	return bgIcon;

    }

    /**
     * Metoda otvara okno , zahrna deafultne metody ktore sa pouzivaju pri vytvarani
     * okna
     * 
     * @param thisFrame okno
     */
    private void openWindow(JFrame thisFrame) {
	thisFrame.setTitle(title);

	// thisFrame.setVisible(true);
	thisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	thisFrame.setSize(WIDTH, HEIGHT);
	thisFrame.setLocationRelativeTo(null);
	thisFrame.setResizable(false);

    }

    /**
     * Metoda zmeni farbu tlacidla na ktory sa klikne a ostatnym tlacidlam vrati
     * povodnu farbu.
     * 
     * @param clickedButton button na ktory sa kliklo
     */
    private void setButtonColorAfterClickOn(JButton clickedButton) {
	if (clickedButton == birdButton1 || clickedButton == birdButton2 || clickedButton == birdButton3
		|| clickedButton == birdButton4 || clickedButton == birdButton5 || clickedButton == birdButton6) {
	    birdButton1.setBackground(birdButtonColorBeforeClickOn);
	    birdButton2.setBackground(birdButtonColorBeforeClickOn);
	    birdButton3.setBackground(birdButtonColorBeforeClickOn);
	    birdButton4.setBackground(birdButtonColorBeforeClickOn);
	    birdButton5.setBackground(birdButtonColorBeforeClickOn);
	    birdButton6.setBackground(birdButtonColorBeforeClickOn);
	    clickedButton.setBackground(birdButtonAfterClickOn);
	} else if (clickedButton == pipeButton1 || clickedButton == pipeButton2 || clickedButton == pipeButton3
		|| clickedButton == pipeButton4 || clickedButton == pipeButton5 || clickedButton == pipeButton6) {
	    pipeButton1.setBackground(pipeButtonColorBeforeClickOn);
	    pipeButton2.setBackground(pipeButtonColorBeforeClickOn);
	    pipeButton3.setBackground(pipeButtonColorBeforeClickOn);
	    pipeButton4.setBackground(pipeButtonColorBeforeClickOn);
	    pipeButton5.setBackground(pipeButtonColorBeforeClickOn);
	    pipeButton6.setBackground(pipeButtonColorBeforeClickOn);
	    clickedButton.setBackground(pipeButtonAfterClickOn);
	}

    }

}
