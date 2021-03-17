package quiz;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Quiz implements Serializable {

    String question;
    String answer = "ja";

    String answerA = "A";
    String answerB = "B";
    String answerC = "C";

    int id;
    private static int idCounter = 0;

    public Quiz(String question, String answer) {
        this.id = idCounter;
        idCounter += 1;

        this.question = question;
        this.answer = answer;
    }

    public Quiz() {
    }

    LinkedList<String> questionList = new LinkedList<String>();
    Scanner sc = new Scanner(System.in);

    void playGame() throws Exception {

        readQuestion();

        for (int i = 0; i < questionList.size(); i += 2) {
            idCounter++;
            System.out.println(idCounter + ". " + questionList.get(i));
            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase(questionList.get(i + 1))) {
                System.out.println("Du svarade rätt! :) \n");
            } else {
                System.out.println("Du svarade fel :( \n");
            }
        }
    }

    void showList() {

        for (int i = 0; i < questionList.size(); i += 2) {
            idCounter += 1; // Fungerar bara en gång, adderas när man visar listan flera gånger.
            System.out.println(idCounter + ". " + questionList.get(i) + "\n");
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

        questionList.add(addQ + "\nA) " + answer1 + "\nB) " + answer2 + "\nC) " + answer3);

        if (addA1.equalsIgnoreCase(answer)) {
            questionList.add(answerA);
        }
        if (addA2.equalsIgnoreCase(answer)) {
            questionList.add(answerB);
        }
        if (addA3.equalsIgnoreCase(answer)) {
            questionList.add(answerC);
        }


    }

    void removeQuestion() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Ta bort en fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");


        for (int i = 0; i < questionList.size(); i += 2) {
            System.out.println(i + ". " + questionList.get(i));// varannat element [0], [2]

        }
        System.out.println("Vilken fråga vill du ta bort? \n");
        int removeQ = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < 2; i++) {
            questionList
                    .remove(removeQ);

        }
    }

    void editQuestion() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Redigera en fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Vilken fråga vill du redigera? \n");

        for (int i = 0; i < questionList.size(); i++) {
            System.out.println(i + ". " + questionList.get(i) + "\n");
        }

        System.out.println("Vilken fråga vill du redigera? ");
        int editQ = sc.nextInt();
        sc.nextLine();
        System.out.println("Vilken svar vill du redigera? ");
        int editA = sc.nextInt();
        sc.nextLine();
        System.out.println("Redigera din fråga: ");
        String modifyQ = sc.nextLine();

        System.out.println("Skriv in svarsalternativ 1:");
        String modifyA1 = sc.nextLine();

        System.out.println("Är detta svar rätt?");
        String setA1 = sc.nextLine(); // ja / nej

        System.out.println("Skriv in svarsalternativ 2:");
        String modifyA2 = sc.nextLine();

        System.out.println("Är detta svar rätt?");
        String setA2 = sc.nextLine();

        System.out.println("Skriv in svarsalternativ 3:");
        String modifyA3 = sc.nextLine();

        System.out.println("Är detta svar rätt?");
        String setA3 = sc.nextLine();

        questionList.set(editQ, modifyQ + "\nA) "  + modifyA1 + "\nB) "+ modifyA2 + "\nC) "+ modifyA3 );

        if (setA1.equals(answer)) {
            questionList.set(editA,answerA);
        }
        if (setA2.equals(answer)) {
            questionList.set(editA,answerB);
        }
        if (setA3.equals(answer)) {
            questionList.set(editA,answerC);
        }

    }

    void writeQuestion() throws Exception {

        FileOutputStream fos = new FileOutputStream("src/quiz/Files/questions.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(questionList);
        oos.flush();
        oos.close();

    }

    void readQuestion
            () throws Exception { // if (questList.length() <= )

        FileInputStream fis = new FileInputStream("src/quiz/Files/questions.txt");
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