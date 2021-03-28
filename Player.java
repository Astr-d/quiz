package quiz;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends Person implements Serializable{

    private int score;
    private int playedGames = 0;

    Quiz quiz = new Quiz();

    LinkedList<Player> playerList = new LinkedList<>();

    public Player(String name, int age, String eMail, int score, int playedGames) {
        super(name, age, eMail);
        this.score = score;
        this.playedGames = playedGames;

    }

    public Player() {
    }

    public Player(String name, int age, String eMail) {
        super(name, age, eMail);
    }

    public void newPlayer() {

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
                    playerList.add(new Player(name, age, eMail, score, playedGames));
                    break;
                }
                System.out.println("Försök igen!");
            }
        }
    }

    void writePlayer() throws Exception {
        //try {
        FileOutputStream fos = new FileOutputStream("src/quiz/Files/players.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(playerList);
        oos.flush();
        oos.close();
        //} catch (InvalidClassException e){

        //}

        System.out.println("Writeplayer success");
    }

    void readPlayer() throws Exception {

        FileInputStream fis = new FileInputStream("src/quiz/Files/players.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        playerList = (LinkedList<Player>) ois.readObject();
        ois.close();

        System.out.println("readPlayer success");

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

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", playedGames=" + playedGames +
                ", quiz=" + quiz +
                ", playerList=" + playerList +
                '}';
    }
}