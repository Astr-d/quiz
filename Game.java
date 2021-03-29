package quiz;

import java.io.Serializable;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class Game implements Serializable {

    Quiz quiz = new Quiz();
    Player receivePlayer = new Player();
    Main main = new Main();
    Time receiveTime = new Time();
    HighScore sendResult = new HighScore();
    static double sumTime;
    static double sumTime2;

    public void newGame() throws Exception {

        System.out.println("* * * * * * * * * * * *");
        System.out.println("*  Nu börjar spelet!  *");
        System.out.println("* * * * * * * * * * * *\n");

        receiveTime.restartTime();
        receivePlayer.playerList.get(0).clearScore();
        receivePlayer.playerList.get(1).clearScore();

        indexQuestionPlayer();
        sendResult.writeHighScore();
    }

    void indexQuestionPlayer() {

        for (int question = 0; question < 3; question++) {

            if (receivePlayer.playerList.size() <= 2 || receivePlayer.playerList.size() > 2) {
                for (int player1 = 1; player1 >= 0; player1--) {

                    Collections.shuffle(quiz.questionList);

                    System.out.println("=== " + receivePlayer.playerList.get(player1).getName() + " ===");
                    try {
                        System.out.println(quiz.questionList.get(question).getQuestion() + "\n(Svara A, B eller C) \n");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Det finns inte fler frågor");
                    }

                    receiveTime.startTime(player1);
                    validation(question, player1); // validerar om spelaren svarar rätt eller fel
                }
            }
        }

        receivePlayer.playerList.get(0).AddNewPlayedGames(true); // Hämtar spelarens playedGames och anropar addNewPlayedGames och då adderars-
        receivePlayer.playerList.get(1).AddNewPlayedGames(true); //- det för varje runda spelaren kör.

        int player1Score = receivePlayer.playerList.get(1).getScore();
        int player2Score = receivePlayer.playerList.get(0).getScore();
        String player1name = receivePlayer.playerList.get(1).getName();
        String player2name = receivePlayer.playerList.get(0).getName();
        int player1PG = receivePlayer.playerList.get(1).getPlayedGames();
        int player2PG = receivePlayer.playerList.get(0).getPlayedGames();
        int player1Age = receivePlayer.playerList.get(0).getAge();
        int player2Age = receivePlayer.playerList.get(1).getAge();
        String player1Email = receivePlayer.playerList.get(0).geteMail();
        String player2Email = receivePlayer.playerList.get(1).geteMail();

        // Ström som summerar tiderna från tidslistan
        // 9.10 + 2,78....
         sumTime = receiveTime.playerOneList.stream()
                .collect(Collectors.summingDouble(Duration::toMillis));

         System.out.println(player1name + " => " + " Tid: " + sumTime / 1000d
                 + " sekunder || " + " Antal rätt: "
                 + player1Score + "/3 || "
                 + " Antal omgångar: " + player1PG);

         sumTime2 = receiveTime.playerTwoList.stream()
                .collect(Collectors.summingDouble(Duration::toMillis));

         System.out.println(player2name + " => " + " Tid: " + sumTime2 / 1000d
                 + " sekunder || " + " Antal rätt: " + player2Score + "/3 || "
                 + " Antal omgångar: " + player2PG);


        String addTime1 = "Spelare: " + player1name +
                "   ::   Ålder: " + player1Age +
                "   ::   E-mejl: " + player1Email +
                "   ::   Antal rätt: " + player1Score + "/3 " +
                "   ::   Tid: " + sumTime/1000d + " sekunder" +
                "   ::   Antal spelade spel: " + player1PG;
        String addTime2 = "Spelare: " + player2name +
                "   ::   Ålder: " + player2Age +
                "   ::   E-mejl: " + player2Email +
                "   ::   Antal rätt: " + player2Score + "/3 " +
                "   ::   Tid: " + sumTime2/1000d + " sekunder" +
                "   ::   Antal spelade spel: " + player2PG;

        if (player1Score < player2Score) {
            //Trong har vunnit
            System.out.println("\n=======================================");
            System.out.println("    Grattis " + player2name + " du vann!     ");
            System.out.println("=======================================");
            //Här läggs vinnaren in i highscore
            sendResult.HSList.add(addTime2);
            //sendResult.HSList.add(receivePlayer.playerList.get(0));
        } else if (player2Score < player1Score) {
            //Astrid har vunnit
            System.out.println("\n=======================================");
            System.out.println("  Grattis " + player1name + " du vann!");
            System.out.println("=======================================");
            //Här läggs vinnaren in i highscore
            //Skickar in spelaren som har vunnit i listan som ska visas ut som highscore
            sendResult.HSList.add(addTime1);
            //Om både spelarna har lika många poäng
            // Denna else if är för tiden. Om båda har lika många poäng avgör tiden.
        } else if (player1Score == player2Score) {
            if (sumTime < sumTime2) {
                //Astrid har vunnit
                System.out.println("\n=======================================");
                System.out.println("    Grattis " + player1name + " du vann!     ");
                System.out.println("=======================================");
                sendResult.HSList.add(addTime1);

            } else if (sumTime2 < sumTime) {
                // Trong vunnit
                System.out.println("\n=======================================");
                System.out.println("    Grattis " + player2name + " du vann!     ");
                System.out.println("=======================================");
                sendResult.HSList.add(addTime2);

            }
        }

    }

    void validation(int questionIndex, int playerIndex) {


        String correctAnswer = quiz.questionList.get(questionIndex).getAnswer();

        //Scanner från helper som jämför med den korrekta svaren för respektive fråga.
        if (Helper.readString().equalsIgnoreCase(correctAnswer)) {

            receiveTime.endTime(playerIndex);
            System.out.println("Du svarade rätt! :) \n");

            receivePlayer.playerList.get(playerIndex).addToScore();

        } else {

            receiveTime.endTime2(playerIndex);
            System.out.println("Du svarade fel :( \n");
        }

    }

    void menuSwitch() {

        quiz.start();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sendResult.readHighScore();
        }catch(Exception e){
            e.printStackTrace();
        }

        while (true) {

            try {
                main.startMenu();

                int nr = Helper.readInt();

                Helper.readString();

                switch (nr) {
                    case 1:
                        receivePlayer.newPlayer(); //skapa spelare
                        receivePlayer.writePlayer();
                        receivePlayer.readPlayer();
                        newGame();
                        break;
                    case 2:
                        sendResult.readHighScore();
                        sendResult.printScoreBoard();
                        break;
                    case 3:
                        System.out.println("*********************");
                        System.out.println("*  Lista av frågor  *");
                        System.out.println("*********************");
                        quiz.showList();
                        break;
                    case 4:
                        quiz.addQuestion();
                        quiz.writeQuestion();
                        break;
                    case 5:
                        quiz.editQuestion();
                        quiz.writeQuestion();
                        break;
                    case 6:
                        quiz.removeQuestion();
                        quiz.writeQuestion();
                        break;
                    case 0:

                        System.exit(0);
                    default:
                        System.out.println("Ange endast siffror mellan 0 och 5");
                        break;
                }
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
