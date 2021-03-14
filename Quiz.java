package quiz;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Quiz implements Serializable {

    String question;
    String answer = "ja";

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Quiz() {
    }

    LinkedList<String> questionList = new LinkedList<String>();


    Scanner sc = new Scanner(System.in);

    HashMap<String, String> questionList2 = null;

    void playGame() throws Exception {

        readObject();

        for (int i = 0; i < questionList.size(); i += 2) {
            System.out.println(questionList.get(i));
            String userInput = sc.nextLine();

            if (userInput.equals(questionList.get(i + 1))) {
                System.out.println("Du svarade rätt! :) \n");
            } else {
                System.out.println("Du svarade fel :( \n");
            }
        }
    }

    void showList() {

        for (int i = 0; i < questionList.size(); i += 2) {
            System.out.println(questionList.get(i));

        /*
        [0] Fråga 1
        [1] Svar fråga 1
        [2] Fråga 2
        [3] Svar fråga 2
        */
        /*
        * [0] Fråga 1
          [1] Svar fråga 1
          Hashmap tar två element och gör till ett.
          * [0] Fråga 1 Svar 1
        * */
        }
    }

    void addQuestion() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Lägg till din fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");

        System.out.println("Skriv in din fråga här: ");
        String addQ = sc.nextLine();

        System.out.println("Skriv in svarsalternativ 1:");
        String answer1 = sc.nextLine();

        System.out.println("Är detta svar rätt?");
        String addA1 = sc.nextLine(); // ja / nej

        System.out.println("Skriv in svarsalternativ 2:");
        String answer2 = sc.nextLine();

        System.out.println("Är detta svar rätt?");
        String addA2 = sc.nextLine();

        System.out.println("Skriv in svarsalternativ 3:");
        String answer3 = sc.nextLine();

        System.out.println("Är detta svar rätt?");
        String addA3 = sc.nextLine();

        questionList.add(addQ + "\nA) " + answer1 + "\nB) " + answer2 + "\nC) " + answer3 + "\n");

        if (addA1.equals(answer)) {
            questionList.add(answer1);
        }
        if (addA2.equals(answer)) {
            questionList.add(answer2);
        }
        if (addA3.equals(answer)) {
            questionList.add(answer3);
        }

        // questionList2.put(addQ, answer);

    }

    void removeQuestion() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Ta bort en fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Vilken fråga vill du ta bort? \n");

        for (int i = 0; i < questionList.size(); i += 2) {
            System.out.println(i + ". " + questionList.get(i));
        }

        int removeQ = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 2; i++) {
            questionList
                    .remove(removeQ);
        }
    }

    void editQuestion() {
        
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

    }

    public void pause() {
        System.out.println("\n> Tryck ENTER för att fortsätta < ");
        new java.util.Scanner(System.in).nextLine();
    }

    void questionWithNr() {
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println(i + ". " + questionList.get(i));
        }
    }
}
