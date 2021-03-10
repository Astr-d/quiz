package quiz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        main.startMenu();
    }
    Quiz quiz = new Quiz();
    void startMenu() throws Exception {

        quiz.questionList();
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

            //System.out.println(" > Tryck 0 för att avsluta programmet < ");



            Scanner input = new Scanner(System.in);
            int nr = input.nextInt();

            switch (nr) {
                case 1:
                    System.out.println("Här ska första frågan för första spelaren komma...");
                    break;
                case 2:
                    System.out.println("-------------------");
                    System.out.println("Lista av frågor");
                    System.out.println("-------------------");


                    quiz.readObject();
                    break;
                case 3:
                    //quiz.writeObject();
                    quiz.addQuestion();
                    quiz.writeObject();
                    break;
                case 4:
                    quiz.writeObject();
                    quiz.removeQuestion();
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