package quiz;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;


public class Game implements Serializable {

    Quiz quiz = new Quiz();
    Player receivePlayer = new Player();
    Main main = new Main();

    public static LocalTime playerOneStart;
    public static LocalTime playerTwoStart;

    public static List<Duration> playerOneList = new ArrayList<>();
    public static List<Duration> playerTwoList = new ArrayList<>();

    public void newGame() throws Exception {

        quiz.readQuestion();

        System.out.println("* * * * * * * * * * * *");
        System.out.println("*  Nu börjar spelet!  *");
        System.out.println("* * * * * * * * * * * *\n");

        receivePlayer.playerList.get(0).clearScore();
        receivePlayer.playerList.get(1).clearScore();

        indexQuestionPlayer();

    }

    void validation(int questionIndex, int playerIndex) {


        String correctAnswer = quiz.questionList.get(questionIndex).getAnswer();

        if (Helper.readString().equalsIgnoreCase(correctAnswer)) {

            if (playerIndex == 0) {

                LocalTime playOneStop = LocalTime.now();

                Duration playOneLapsed = Duration.between(playerOneStart, playOneStop);

                playerOneList.add(playOneLapsed);

                System.out.println(playOneLapsed.toMillis() / 1000d + " sekunder.");

            } else if (playerIndex == 1) {

                LocalTime playTwoStop = LocalTime.now();
                Duration playerTwoLapsed = Duration.between(playerTwoStart, playTwoStop);
                playerTwoList.add(playerTwoLapsed);
                System.out.println(playerTwoLapsed.toMillis() / 1000d + " sekunder.");

            }

            System.out.println("Du svarade rätt! :) \n");

            receivePlayer.playerList.get(playerIndex).addToScore();

        } else {

            if (playerIndex == 0) {

                LocalTime playOneStop = LocalTime.now();
                Duration playOneLapsed = Duration.between(playerOneStart, playOneStop);

                playerOneList.add(playOneLapsed);
                System.out.println(playOneLapsed.toMillis() / 1000d + " sekunder");


            } else if (playerIndex == 1) {

                LocalTime playTwoStop = LocalTime.now();
                Duration playerTwoLapsed = Duration.between(playerTwoStart, playTwoStop);
                playerTwoList.add(playerTwoLapsed);
                System.out.println(playerTwoLapsed.toMillis() / 1000d + " sekunder");

            }
            System.out.println("Du svarade fel :( \n");
        }

    }

    void indexQuestionPlayer() {

        for (int question = 0; question < 3; question++) {

            for (int player = 0; player < 2; player++) {
                Collections.shuffle(quiz.questionList);

                System.out.println("=== " + receivePlayer.playerList.get(player).getName() + " ===");
                try {
                    System.out.println(quiz.questionList.get(question).getQuestion() + "\n(Svara A, B eller C) \n");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Det finns inte fler frågor");
                }
                if (player == 0) {
                    playerOneStart = LocalTime.now();
                } else if (player == 1) {
                    playerTwoStart = LocalTime.now();
                }
                validation(question, player);
            }
        }

        int player1Score = receivePlayer.playerList.get(0).getScore();
        int player2Score = receivePlayer.playerList.get(1).getScore();
        String player1name = receivePlayer.playerList.get(0).getName();
        String player2name = receivePlayer.playerList.get(1).getName();
        int player1PG = receivePlayer.playerList.get(0).getPlayedGames();
        int player2PG = receivePlayer.playerList.get(1).getPlayedGames();

        receivePlayer.playerList.get(0).AddNewPlayedGames(true); // Hämtar spelarens playedGames och anropar addNewPlayedGames och då adderars-
        receivePlayer.playerList.get(1).AddNewPlayedGames(true); //- det för varje runda spelaren kör.


        double sum = playerOneList.stream()
                .collect(Collectors.summingDouble(Duration::toMillis));
        System.out.println(player1name + " => " + " Tid: " + sum / 1000d + " sekunder || " + " Antal rätt: " + player1Score + "/3 || "
                + " Antal omgångar: " + player1PG);

        double sum2 = playerTwoList.stream()
                .collect(Collectors.summingDouble(Duration::toMillis));
        System.out.println(player2name + " => " + " Tid: " + sum2 / 1000d + " sekunder || " + " Antal rätt: " + player2Score + "/3 || "
                + " Antal omgångar: " + player2PG);


        if (player1Score < player2Score) {
            //Trong har vunnit
            System.out.println("\n=======================================");
            System.out.println("    Grattis " + player2name + " du vann!     ");
            System.out.println("=======================================");
        } else if (player2Score < player1Score) {
            //Astrid har vunnit
            System.out.println("\n=======================================");
            System.out.println("  Grattis " + player1name + " du vann!");
            System.out.println("=======================================");
        } else if (player1Score == player2Score) {
            if (sum < sum2) {
                //Astrid har vunnit
                System.out.println("\n=======================================");
                System.out.println("    Grattis " + player1name + " du vann!     ");
                System.out.println("=======================================");
            } else if (sum2 < sum) {
                // Trong vunnit
                System.out.println("\n=======================================");
                System.out.println("    Grattis " + player2name + " du vann!     ");
                System.out.println("=======================================");
            }
        }
    }

    void menuSwitch() {

        while (true) {
            try {
                main.startMenu();
                int nr = Helper.readInt();

                switch (nr) {
                    case 1:
                        receivePlayer.newPlayer(); //skapa spelare
                        receivePlayer.writePlayer();
                        receivePlayer.readPlayer();
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
                //time.wait();
                quiz.pause();
            } catch (InputMismatchException e) {
                System.out.println("Ange endast siffror mellan 0 och 5");
                Helper.emptyString();
                quiz.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
