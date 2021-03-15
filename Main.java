package quiz;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.menuSwitch();
    }

    void menuSwitch() throws Exception {

        Scanner input = new Scanner(System.in);

        Quiz quiz = new Quiz();

        while (true) {
            try {
                startMenu();
                int nr = input.nextInt();

                switch (nr) {
                    case 1:
                        quiz.playGame();
                        break;
                    case 2:
                        System.out.println("-------------------");
                        System.out.println("Lista av frågor");
                        System.out.println("-------------------");
                        quiz.readObject();
                        quiz.showList();
                        break;
                    case 3:
                        //quiz.writeObject();
                        quiz.readObject();
                        quiz.addQuestion();
                        quiz.writeObject();
                        break;
                    case 4:
                        quiz.readObject();
                        quiz.removeQuestion();
                        quiz.writeObject();
                        break;
                    case 5:
                        quiz.readObject();
                        quiz.editQuestion();
                        quiz.writeObject();
                        break;
                    case 0:
                        quiz.writeObject();
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