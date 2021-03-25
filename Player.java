package quiz;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends Person {

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

        String playerStringInfo = Helper.readString();
        int playerIntInfo = Helper.readInt();

        for (int i = 0; i < 2; i++) {
            System.out.println("* * * * * * * * * *");
            System.out.println("*  Skapa spelare  *");
            System.out.println("* * * * * * * * * *");

            System.out.println("Namn: ");
            String name = playerStringInfo; // lagras namnet

            System.out.println("Ålder: ");
            int age = playerIntInfo; // lagras åldern

            Helper.emptyString();

            while (true) {
                System.out.println("E-mejl: ");
                String eMail = playerStringInfo; //lagras email

                if (eMail.contains("@")) {
                    playerList.add(new Player(name, age, eMail, score, playedGames));
                    break;
                }
                System.out.println("Försök igen!");
            }
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