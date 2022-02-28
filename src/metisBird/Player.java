package metisBird;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Trieda obsahuje funkcionalitu na vytvorenie hraca a implementuje interface
 * Comparable. V triede si vytvarame aj vlastny komparator na porovnavanie
 * hracov podla dosiahnuteho score v hre.
 * 
 * @author Team
 *
 */
public class Player implements Comparable<Player> {

    int score;
    String name;
    public ArrayList<Player> scoreBoard = new ArrayList<Player>();
    String fileName = "players.csv";

    /**
     * Konstruktor vytvara hraca s dvoma parametrami : hrac, score.
     * 
     * @param name  meno hraca
     * @param score nahrane score hraca
     */
    public Player(String name, int score) {
	this.name = name;
	this.score = score;
    }

    /**
     * Bezparametricky konstruktor
     */
    public Player() {
	try {
	    scoreBoard = readFile(fileName);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Collections.sort(scoreBoard);
    }

    /**
     * Metoda cita zo suboru .csv ktory obsahuje ulozene udaje o hracoch(meno,score)
     * ktory hrali a nasledne ich parsuje a vytvara objekty typu Player ktore
     * nasledne uklada to pola ArrayList.
     * 
     * @param fileName nazov csv. suboru do ktoreho sa uklada hrac
     * @return udaje o hracoch (meno,score)
     * @throws IOException
     */
    public ArrayList<Player> readFile(String fileName) throws IOException {
	this.fileName = fileName;
	scoreBoard = new ArrayList<Player>();
	BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
	try {
	    String line = br.readLine();
	    if (line == null)
		throw new IllegalArgumentException("File is empty");
	    if (!line.equals("name,score"))
		throw new IllegalArgumentException("File has wrong columns: " + line);
	    while ((line = br.readLine()) != null) {
		String[] items = line.split(",");
		try {

		    if (items.length > 4)
			throw new ArrayIndexOutOfBoundsException();
		    Player player = new Player(name, score);
		    player.setName(items[0]);
		    player.setScore(Integer.parseInt(items[1]));
		    scoreBoard.add(player);
		} catch (NullPointerException e) {

		    System.out.println("Invalid line: " + line);
		}
	    }

	    return scoreBoard;
	} finally {
	    br.close();
	}
    }

    /**
     * Metoda vracia hraca z ArrayListu podla zadaneho indexu. Navratovy typ je
     * prekonvertovany na String
     * 
     * @param index cislo indexu v ArrayListe
     * @return vracia hraca na zaklade indexu
     */
    public String getPlayerAtIndex(int index) {
	return scoreBoard.get(index).toString();
    }

    /**
     * Nastavuje score hraca ktore dosiahol v hre.
     * 
     * @param score score ktore hrac dosiahol
     */
    private void setScore(int score) {
	this.score = score;

    }

    /**
     * Nastavuje meno hracovi podla jeho zadania v nato urcenom textfielde
     * 
     * @param name meno hraca ktore zadal pred startom hry
     */
    private void setName(String name) {
	this.name = name;

    }

    @Override
    /**
     * Metoda definuje ako ma vyzerat zretazeny tvar hraca
     */
    public String toString() {
	return (this.getPlayerName() + " : " + this.getPlayerScore()

	);
    }

    /**
     * Metoda vracia score ktore hrac dosiahol v hre
     * 
     * @return vracia dosiahnute score hraca
     */
    public int getPlayerScore() {
	return score;
    }

    /**
     * Metoda vracia meno ktore si uzivatel nastavil v na to urcenom textfielde
     * 
     * @return vracia meno ktore si uzivatel zvolil
     */
    public String getPlayerName() {
	return name;
    }

    @Override
    /**
     * Comparator porovnava score jedneho hraca zo score dalsieho hraca a nasledne
     * vrati jednu z hodnot : -1 ak je score hraca mensie ako score porovnavaneho
     * hraca , 0 ak maju porovnavani hraci rovnake score, 1 ak ma hrac vacsie score
     * ako score porovnavaneho hraca
     */
    public int compareTo(Player anotherPlayer) {
	return anotherPlayer.score - this.score;
    }

}

/**
 * Trieda implementuje interface Comparator ktory porovnava objekty typu
 * <Player> .
 * 
 * @author team
 *
 */
class ScoreComparator implements Comparator<Player> {

    @Override
    /**
     * Metoda porovnava dvoch hracov podla ich dosiahnuteho score
     */
    public int compare(Player p1, Player p2) {
	return p1.getPlayerScore() - p2.getPlayerScore();
    }
}