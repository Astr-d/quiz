package quiz;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends Person implements Serializable {


    int score = 0;
    int playedGames = 0;


    Quiz quiz = new Quiz();

    //Scanner scanPlayer = new Scanner(System.in);

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

    public void player1() {

        Scanner scanPlayer = new Scanner(System.in);

        System.out.println("* * * * * * * * * *");
        System.out.println("* Skapa spelare 1 *");
        System.out.println("* * * * * * * * * *");

        System.out.println("Namn: ");
        String name = scanPlayer.nextLine(); // lagras namnet
        // playerList.addFirst(name); //Trong hamnar på element 0
        System.out.println("Ålder: ");
        int age = scanPlayer.nextInt(); // lagras åldern
        //playerList.add(age);
        scanPlayer.nextLine();

        while (true) {
            System.out.println("E-mejl: ");
            String eMail = scanPlayer.nextLine(); //lagras email

            if (eMail.contains("@")) {
                playerList.add(new Player(name,age,eMail, score, playedGames));
                break;
            }
            System.out.println("Försök igen!");
        }

    }


    public void player2() {
        Scanner scanPlayer = new Scanner(System.in);

        System.out.println("* * * * * * * * * *");
        System.out.println("* Skapa spelare 2 *");
        System.out.println("* * * * * * * * * *");

        System.out.println("Namn: ");
        String name2 = scanPlayer.nextLine();
        //playerList.addFirst(name2); // Johan, hamna på element 0 och Trong element 3

        System.out.println("Ålder: ");
        int age2 = scanPlayer.nextInt();
        //playerList.add(age2);
        scanPlayer.nextLine();

        // While-loopen låter oss komma tillbaka så vi kan skriva in e-posten igen

        while (true) {

            System.out.println("E-mejl: ");
            String eMail2 = scanPlayer.nextLine();

            if (eMail2.contains("@")) {
                playerList.add(new Player(name2, age2, eMail2, score, playedGames));
                break;
            }
            System.out.println("Försök igen!");
        }
    }

    public void switchPlayer() throws Exception{
        Scanner scanPlayer = new Scanner(System.in);
        Time time = new Time();
        quiz.readQuestion();
        //readPlayer();

        System.out.println("\n* * * * * * * * * * * *");
        System.out.println("Nu börjar spelet!");
        System.out.println("* * * * * * * * * * * *");

        int idCounter = 0;


        for (int i = 0; i < quiz.questionList.size(); i ++) {
            Collections.shuffle(quiz.questionList);
            idCounter++;
            System.out.println("Gör dig redo " + playerList.get(0).name);
            System.out.println(idCounter + ". " + quiz.questionList.get(i).question);
            //tiden startar på spelare 1
            time.start();
            String userInput = scanPlayer.nextLine();

            // Vad gör 'equalsIgnoreCase'?
            if (userInput.equalsIgnoreCase(quiz.questionList.get(i).answer)) {
                System.out.println("Du svarade rätt! :) \n");
                //playerList.get(0).score++;

            } else {
                System.out.println("Du svarade fel :( \n");
            }
            Collections.shuffle(quiz.questionList);
            System.out.println("Gör dig redo " + playerList.get(1).name);
            System.out.println(idCounter + ". " + quiz.questionList.get(i).question);
            //tiden startar för spelare 2
            String userInput2 = scanPlayer.nextLine();

            if (userInput2.equalsIgnoreCase(quiz.questionList.get(i).answer)) {
                System.out.println("Du svarade rätt! :) \n");
                //playerList.get(1).score++;
            } else {
                System.out.println("Du svarade fel :( \n");
            }

        }

        // Grattis ****** vann!
        // Player 1: 2/3 rätt Tid: 7.3s
        // Player 2: 3/3 rätt Tid: 6.3s

        System.out.println("Score for player 1: " + playerList.get(0).score + "/" + playerList.size());
        System.out.println("Score for player 2: " + playerList.get(1).score);

    }


    void writePlayer() throws Exception, NotSerializableException, WriteAbortedException {

        FileOutputStream fos = new FileOutputStream("src/quiz/Files/players.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(playerList);
        oos.flush();
        oos.close();

        System.out.println("Writeplayer success");

    }

    void readPlayer() throws Exception { // if (questList.length() <= )

        FileInputStream fis = new FileInputStream("src/quiz/Files/players.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        playerList = (LinkedList<Player>) ois.readObject();
        ois.close();
        System.out.println("readPlayer success");

    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eMail='" + eMail + '\'' +
                ", score=" + score +
                ", playedGames=" + playedGames ;
    }
}