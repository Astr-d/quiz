package quiz;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Quiz implements Serializable {

    String question;
    String answer1;
    String answer2;
    String answer3;

    public Quiz(String question, String answer1, String answer2, String answer3) {

        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public Quiz(){}

    LinkedList<Quiz> questionList = new LinkedList<Quiz>();

    Scanner sc = new Scanner(System.in);

    void questionList2() {

        /*questionList.add("Vad heter Einstein i förnamn?");
        questionList.add("Hur många länder ingår i EU?");
        questionList.add("I vilken världsdel ligger Grönland?");
        questionList.add("Hur många ben har en myra?");
        questionList.add("Hur många nack-kotor har en giraff?");
        questionList.add("Vilket år hade Einsteins allmänna relativitetsteori 100-årsjubileum?");
        questionList.add("Hur mår Johannes idag?");
*/
    }


    void addQuestion() {


        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Lägg till din fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Skriv in din fråga här: ");
        String addQ = sc.nextLine();

        System.out.println("Skriv in svarsalternativ 1:");
        String addA1 = sc.nextLine();
        System.out.println("Skriv in svarsalternativ 2:");
        String addA2 = sc.nextLine();
        System.out.println("Skriv in svarsalternativ 3:");
        String addA3 = sc.nextLine();

        questionList.add(new Quiz(addQ, addA1, addA2, addA3));

       // questionList.add(addQ);
        for(int i = 1; i < questionList.size(); i++){
            System.out.println(i + ". " + questionList.get(i));
        }
        //questionList.forEach(System.out::println);

    }

    void rightAnswer() {

        //Gör en loop som jämför om det intryckta svaret är samma som det rätta svaret.
        System.out.println("Ange rätt svar");
        String addAnswer = sc.nextLine();

        //Strängen addAnswer ska jämföras med det rätta svaret.

    }

    void removeQuestion(){

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Ta bort en fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Vilken fråga vill du ta bort? ");

        for(int i = 1; i < questionList.size(); i++){
            System.out.println(i + ". " + questionList.get(i));
        }

        int removeQ = sc.nextInt();

        questionList
                .remove(removeQ);

        questionList
                .forEach(System.out::println);

    }



    void writeObject() throws Exception {

        FileOutputStream fos = new FileOutputStream("src/quiz/questions.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(questionList);
        oos.flush();
        oos.close();

    }

    void readObject() throws Exception {

        FileInputStream fis = new FileInputStream("src/quiz/questions.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        questionList = (LinkedList<Quiz>) ois.readObject();
        ois.close();

        //questionList
         //       .forEach(System.out::println);
        for(int i = 0; i < questionList.size(); i++){
            System.out.println(i + ". " + questionList.get(i));
        }

    }

    public void pause() {
        System.out.println("\n> Tryck ENTER för att fortsätta < ");
        new java.util.Scanner(System.in).nextLine();
    }


}
