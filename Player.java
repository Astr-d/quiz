package quiz;

import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends Person implements Serializable {


    int score;
    int playedGames;

    Scanner scanPlayer = new Scanner(System.in);

    LinkedList<String> playerList = new LinkedList<String>();

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


    public void player1() {

        System.out.println("* * * * * * * * * *");
        System.out.println("* Skapa spelare 1 *");
        System.out.println("* * * * * * * * * *");

        System.out.println("Namn: ");
        String name = scanPlayer.nextLine();
        playerList.add(name);
        System.out.println("Ålder: ");
        String age = scanPlayer.nextLine();
        playerList.add(age);

        while (true) {
            System.out.println("E-mejl: ");
            String eMail = scanPlayer.nextLine();

            if (eMail.contains("@")) {
                playerList.add(eMail);
                break;
            }
            System.out.println("Försök igen!");
        }

    }


    public void player2() {

        System.out.println("* * * * * * * * * *");
        System.out.println("* Skapa spelare 2 *");
        System.out.println("* * * * * * * * * *");

        System.out.println("Namn: ");
        String name2 = scanPlayer.nextLine();
        playerList.add(name2);

        System.out.println("Ålder: ");
        String age2 = scanPlayer.nextLine();
        playerList.add(age2);

        while (true) {

            System.out.println("E-mejl: ");
            String eMail = scanPlayer.nextLine();

            if (eMail.contains("@")) {
                playerList.add(eMail);
                break;
            }
            System.out.println("Försök igen!");

        }

    }

    void writePlayer() throws Exception {

        FileOutputStream fos = new FileOutputStream("src/quiz/Files/players.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(playerList);
        oos.flush();
        oos.close();

    }

    void readPlayer() throws Exception { // if (questList.length() <= )

        FileInputStream fis = new FileInputStream("src/quiz/Files/players.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        playerList = (LinkedList<String>) ois.readObject();
        ois.close();

    }
}
