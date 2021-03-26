package quiz;

import java.io.Serializable;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;


public class Game implements Serializable {

    public static String helper;
    Scanner userInput = new Scanner(System.in);

    Quiz quiz = new Quiz();
    Player player = new Player();
    Main main = new Main();

    public void newGame() throws Exception {

        quiz.readQuestion();

        System.out.println("* * * * * * * * * * * *");
        System.out.println("*  Nu börjar spelet!  *");
        System.out.println("* * * * * * * * * * * *");

        player.playerList.get(0).clearScore();
        player.playerList.get(1).clearScore();


        new Time().start();

        test();

        new Time().stop1();


        player.playerList.get(0).AddNewPlayedGames(true); // Hämtar spelarens playedGames och anropar addNewPlayedGames och då adderars-
        player.playerList.get(1).AddNewPlayedGames(true); //- det för varje runda spelaren kör.


        System.out.println(player.playerList.get(0).getName() + " " + player.playerList.get(0).getScore() + "/3, " + player.playerList.get(0).getPlayedGames());
        System.out.println(player.playerList.get(1).getName() + " " + player.playerList.get(1).getScore() + "/3, " + player.playerList.get(1).getPlayedGames());

    }

    void validation(int questionIndex, int playerIndex) {

        helper = userInput.nextLine();

        String correctAnswer = quiz.questionList.get(questionIndex).getAnswer();

        if (helper.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Du svarade rätt! :) \n");
            player.playerList.get(playerIndex).addToScore();

        } else {
            System.out.println("Du svarade fel :( \n");
        }

    }

    void test() throws Exception{
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 2; j++) {

                Thread.sleep(1000);
                System.out.println(player.playerList.get(j).getName() + "\n");
                try {
                    System.out.println(quiz.questionList.get(i).getQuestion() + "\n");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Det finns inte fler frågor");
                }
                validation(i, j);

                //new Time().stop1();

            }
        }
    }

    void menuSwitch() {

        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                main.startMenu();
                int nr = input.nextInt();

                switch (nr) {
                    case 1:
                        player.newPlayer(); //skapa spelare
                        player.writePlayer();
                        player.readPlayer();
                        newGame();
                        break;
                    case 2:
                        System.out.println("*********************");
                        System.out.println("*  Lista av frågor  *");
                        System.out.println("*********************");
                        quiz.readQuestion();
                        quiz.showList();
                        break;
                    case 3:
                        quiz.readQuestion();
                        quiz.addQuestion();
                        quiz.writeQuestion();
                        break;
                    case 4:
                        quiz.readQuestion();
                        quiz.removeQuestion();
                        quiz.writeQuestion();
                        break;
                    case 5:
                        quiz.readQuestion();
                        quiz.editQuestion();
                        quiz.writeQuestion();
                        break;
                    case 0:
                        //serialize.writeQuestion();
                        System.exit(0);
                    default:
                        System.out.println("Ange endast siffror mellan 0 och 5");
                        break;
                }
                quiz.pause();
            } catch (InputMismatchException e) {
                System.out.println("Ange endast siffror mellan 0 och 5");
                input.next();
                quiz.pause();
            } /*catch (NotSerializableException e) {
                System.out.println("Hello");
                //input.next();

            }*/ catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
