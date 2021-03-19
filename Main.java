package quiz;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) throws Exception, NotSerializableException {
        Main main = new Main();
        main.menuSwitch();
    }

    void menuSwitch() throws Exception {

        Scanner input = new Scanner(System.in);

        Quiz quiz = new Quiz();
        Player player = new Player();


        while (true) {
            try {
                startMenu();
                int nr = input.nextInt();

                switch (nr) {
                    case 1:
                        player.player1();
                        player.player2();
                        player.writePlayer();
                        player.readPlayer();
                        player.switchPlayer();
                        break;
                    case 2:
                        System.out.println("-------------------");
                        System.out.println("Lista av frågor");
                        System.out.println("-------------------");
                        quiz.readQuestion();
                        quiz.showList();
                        break;
                    case 3:
                        //quiz.writeObject();
                        //quiz.readQuestion();
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
            } catch (NotSerializableException e) {
                System.out.println("Hello");
                player.switchPlayer();
            }
        }
    }

    static void startMenu() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println(" Tryck in en siffra för vad du vill göra");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println(" > [1] Starta spelet");
        System.out.println(" > [2] Visa en lista med frågorna");
        System.out.println(" > [3] Lägg till en fråga");
        System.out.println(" > [4] Ta bort en fråga");
        System.out.println(" > [5] Redigera en fråga");
        System.out.println(" > [0] Avsluta programmet \n");
        System.out.println("Skriv ditt val här: ");
    }
}