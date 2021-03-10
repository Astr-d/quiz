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

    LinkedList<String> questionList = new LinkedList<>();

    Scanner sc = new Scanner(System.in);

    void questionList() {

        questionList.add("Vad heter Einstein i förnamn?");
        questionList.add("Hur många länder ingår i EU?");
        questionList.add("I vilken världsdel ligger Grönland?");
        questionList.add("Hur många ben har en myra?");
        questionList.add("Hur många nack-kotor har en giraff?");
        questionList.add("Vilket år hade Einsteins allmänna relativitetsteori 100-årsjubileum?");
        questionList.add("Hur mår Johannes idag?");

    }

    void addQuestion() {


        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Lägg till din fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Skriv in din fråga här: ");
        String addQ = sc.nextLine();

        questionList.add(addQ);

       // questionList.add(addQ);
        questionList.forEach(System.out::println);

    }

    void removeQuestion(){

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Ta bort en fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Vilken fråga vill du ta bort? ");
        int removeQ = sc.nextInt();

        questionList
                .remove(removeQ);

        questionList
                .forEach(System.out::println);
    }

    void rightAnswer() {

        //Gör en loop som jämför om det intryckta svaret är samma som det rätta svaret.
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

        questionList = (LinkedList<String>) ois.readObject();
        ois.close();

        questionList
                .forEach(System.out::println);

    }

    public void pause() {
        System.out.println("\n> Tryck ENTER för att fortsätta < ");
        new java.util.Scanner(System.in).nextLine();
    }


}
