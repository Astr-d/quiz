package quiz;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;


public class Game implements Serializable {

    Quiz quiz = new Quiz();
    Player player = new Player();
    Main main = new Main();

    public void newGame() throws Exception{
        quiz.readQuestion();

        Scanner scanPlayer = new Scanner(System.in);

        //readPlayer();
        System.out.println("* * * * * * * * * * * *");
        System.out.println("*  Nu börjar spelet!  *");
        System.out.println("* * * * * * * * * * * *");


        int idCounter = 0;
        //nollställa score

        for (int i = 0; i < 3; i ++) {
            Collections.shuffle(quiz.questionList);

            //idCounter++;
            System.out.println(player.playerList.get(0).getName() + "\n");

            System.out.println(quiz.questionList.get(i).getQuestion() + "\n");

            //new Time("game-thread").start(); // Här ska tiden börja räknas

            String userInput = scanPlayer.nextLine();

            // tråden ska stoppas

            if (userInput.equalsIgnoreCase(quiz.questionList.get(i).getAnswer())) {
                System.out.println("Du svarade rätt! :) \n");
                player.playerList.get(0).addToScore();

            } else {
                System.out.println("Du svarade fel :( \n");
            }

            Collections.shuffle(quiz.questionList);
            System.out.println( player.playerList.get(1).getName() + "\n");
            System.out.println(quiz.questionList.get(i).getQuestion() + "\n");
            //tiden startar f�r spelare 2
            String userInput2 = scanPlayer.nextLine();

            if (userInput2.equalsIgnoreCase(quiz.questionList.get(i).getAnswer())) {
                System.out.println("Du svarade rätt! :) \n");
                player.playerList.get(1).addToScore();
            } else {
                System.out.println("Du svarade fel :( \n");
            }

        }

        System.out.println(player.playerList.get(0).getName() + " " + player.playerList.get(0).getScore() + "/3");
        System.out.println(player.playerList.get(1).getName() + " " + player.playerList.get(1).getScore() + "/3");


        // Grattis ****** vann!
        // Player 1: 2/3 r�tt Tid: 7.3s
        // Player 2: 3/3 r�tt Tid: 6.3s

       //System.out.println("Score for player 1: " + playerList.get(0).score + "/" + playerList.size());
        // System.out.println("Score for player 2: " + playerList.get(1).score);

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

                        //Start time
                        newGame();
                        //End time
                        break;
                    case 2:
                        quiz.readQuestion();
                        System.out.println("-------------------");
                        System.out.println("Lista av frågor");
                        System.out.println("-------------------");
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
                        quiz.writeQuestion();
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

            }*/catch (Exception e){
                e.printStackTrace();
            }
        }
    }





}
