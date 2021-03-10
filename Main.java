package quiz;

import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    Scanner input = new Scanner(System.in);

    Quiz quiz = new Quiz("Hur många får äger Johan", "1","0","5" );

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        main.startMenu();
    }

    void startMenu() throws Exception {

        quiz.questionList2();

        while (true) {
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

            int nr = input.nextInt();

            switch (nr) {
                case 1:
                    System.out.println("Här ska första frågan för första spelaren komma...");
                    break;
                case 2:
                    System.out.println("-------------------");
                    System.out.println("Lista av frågor");
                    System.out.println("-------------------");
                    quiz.writeObject();
                    quiz.readObject();
                    break;
                case 3:
                    //quiz.writeObject();
                    quiz.addQuestion();
                    quiz.writeObject();
                    break;
                case 4:
                    quiz.removeQuestion();
                    quiz.writeObject();
                    break;
                case 5:
                    // kod block
                    break;
                case 0:
                    System.exit(0);
                default:

            }
            quiz.pause();
        }
    }

}