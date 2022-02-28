package metisBird;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Trieda obsahuje funkcionalitu prekazok v hre. Na vyber je 6 druhov . Ak
 * vtacik narazi do prekazky , hra konci.
 * 
 * @author Team
 *
 */
public class Pipe {
    public static final int PIPE_W = 50, PIPE_H = 30; // hrubka a vyska potrubia

    /**
     * Jednotlive potrubia 1-6
     * 
     * @author team
     *
     */
    public enum PIPES {
	PIPE1, PIPE2, PIPE3, PIPE4, PIPE5, PIPE6;
    }

    private BufferedImage pipeHead;
    private BufferedImage pipeLength;

    /**
     * Metoda vracia obrazok potrubia
     * 
     * @return obrazok potrubia
     */
    public Pipe() {

    }

    /**
     * Metoda nastavuje typ potrubia.
     * 
     * @param newPipeType typ potrubia
     */
    public void setPipeType(PIPES newPipeType) {
	Pipe.pipeType = newPipeType;
    }

    /**
     * Metoda vracia typ potrubia
     * 
     * @return typ potrubia
     */
    public PIPES getPipeType() {
	return pipeType;
    }

    /**
     * Metoda vracia obrazok koncovky potrubia podla vyberu uzivatela
     * 
     * @return obrazok koncovky potrubia
     */
    public BufferedImage getPipeHead() {

	if (pipeType == PIPES.PIPE1) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubeAquamarin.png");
		pipeHead = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE2) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubeViolet.png");
		pipeHead = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE3) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubeGold.png");
		pipeHead = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE4) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubeSilver.png");
		pipeHead = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE5) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubeGreen.png");
		pipeHead = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE6) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubeBlue.png");
		pipeHead = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	return pipeHead;

    }

    /**
     * Metoda vracia obrazok tela potrubia podla vyberu uzivatela
     * 
     * @return obrazok tela potrubia
     */
    public Image getPipeLength() {

	if (pipeType == PIPES.PIPE1) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubePartAquamarin.png");
		pipeLength = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE2) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubePartViolet.png");
		pipeLength = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE3) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubePartGold.png");
		pipeLength = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE4) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubePartSilver.png");
		pipeLength = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE5) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubePartGreen.png");
		pipeLength = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	else if (pipeType == PIPES.PIPE6) {
	    try { // podmienka pokial nebudu najdene obrazky potrubia

		URL url = MetisBird.class.getResource("/resources/TubePartBlue.png");
		pipeLength = ImageIO.read(url);

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	return pipeLength;

    }

    static PIPES pipeType = PIPES.PIPE1;

}
