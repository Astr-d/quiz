package quiz;

import java.io.*;
import java.util.LinkedList;

public class Player extends Person implements Serializable {

    private int score;
    private int playedGames = 0;

    LinkedList<Player> playerList = new LinkedList<>();

    public Player(String name, int age, String eMail, int score, int playedGames) {
        super(name, age, eMail);
        this.score = score;
        this.playedGames = playedGames;

    }

    public Player() {
    }

    public void newPlayer()   {

        int nr = Helper.numberingList();
        for (int i = 0; i < 2; i++) {
            nr++;
            System.out.println("* * * * * * * * * *");
            System.out.println("* Skapa spelare " + nr + " *");
            System.out.println("* * * * * * * * * *");

            System.out.println("Namn: ");
            String name = Helper.readString(); // lagras namnet

            System.out.println("Ålder: ");
            int age = Helper.readInt(); // lagras åldern

            Helper.readString();
            //Helper.emptyString();

            while (true) {
                System.out.println("E-mejl: ");
                String eMail = Helper.readString(); //lagras email

                if (eMail.contains("@")) {
                    playerList.addFirst(new Player(name, age, eMail, score, playedGames));
                    break;
                }
                System.out.println("Försök igen!");
            }
        }
    }

    void writePlayer() throws Exception {

        FileOutputStream fos = new FileOutputStream("src/quiz/Files/players.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(playerList);
        oos.flush();
        oos.close();


    }

    void readPlayer() throws Exception {

        try{
        FileInputStream fis = new FileInputStream("src/quiz/Files/players.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        playerList = (LinkedList<Player>) ois.readObject();
        ois.close();
         }catch (EOFException e) {
        }

    }


    public int AddNewPlayedGames(boolean played) {  // Vi skapar metod här för att plussa på playedgames per gång.
        if (played) {

            playedGames++;
        }
        return playedGames;
    }

    public void clearPlayedGames() {
        playedGames = 0;
    }


    public int addToScore() { // Denna metoden lägger till score.
        if (score <= 3) {
            score++;
        }
        return score;
    }

    public void clearScore() {
        score = 0;
    } // Denna metoden nollställer score.

    public int getScore() {
        return score;
    } // Denna metod retunerar score.

    public int getPlayedGames() {
        return playedGames;
    } // dessa getPlayedGames, setScore, setPlayedGames
    // för att kunna nå privata variablerna.

}