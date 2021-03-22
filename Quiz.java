package quiz;

import java.io.*;
import java.util.InvalidPropertiesFormatException;
import java.util.LinkedList;
import java.util.Scanner;

public class Quiz implements Serializable {

    String question;
    String answer = "ja";

    String answerA = "A";
    String answerB = "B";
    String answerC = "C";

    public Quiz(String question, String answer) {

        this.question = question;
        this.answer = answer;
    }

    public Quiz() {
    }

    LinkedList<Quiz> questionList = new LinkedList<>();

    void showList() {
        int idCounter = 0;

        for (int i = 0; i < questionList.size(); i++) {
            idCounter++; // Fungerar bara en gång, adderas när man visar listan flera gånger.
            System.out.println(idCounter + ". " + questionList.get(i).question + "\n");
        }
    }

    void addQuestion() {
        Scanner sc = new Scanner(System.in);
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


        if (addA1.equalsIgnoreCase(answer)) {
            questionList.add(new Quiz(addQ + "\nA) " + answer1 + "\nB) " + answer2 + "\nC) " + answer3, answerA));

        }
        if (addA2.equalsIgnoreCase(answer)) {
            questionList.add(new Quiz(addQ + "\nA) " + answer1 + "\nB) " + answer2 + "\nC) " + answer3, answerB));

        }
        if (addA3.equalsIgnoreCase(answer)) {
            questionList.add(new Quiz(addQ + "\nA) " + answer1 + "\nB) " + answer2 + "\nC) " + answer3, answerC));

        }

    }

    void removeQuestion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Ta bort en fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");

        int idCounter = 0;

        for (int i = 0; i < questionList.size(); i++) {
            idCounter++;
            System.out.println(idCounter + "(" + i + ")" + ". " + questionList.get(i).question);

        }
        System.out.println("Vilken fråga vill du ta bort? \n");
        int removeQ = sc.nextInt();
        sc.nextLine();

        //for (int i = 0; i < 2; i++) { }
        questionList
                .remove(removeQ);
    }

    void editQuestion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Redigera en fråga");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Vilken fråga vill du redigera? \n");
        int idCounter = 0;

        for (int i = 0; i < questionList.size(); i++) {
            idCounter++;
            System.out.println(idCounter + ". " + questionList.get(i).question + "\n");
        }

        System.out.println("Vilken fråga vill du redigera? ");
        int editQ = sc.nextInt();
        sc.nextLine();

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

        // questionList.set(editQ, new Quiz(modifyQ +"\nA) " + modifyA1 +  "\nB) " +  modifyA2+  "\nC) " +  modifyA3, answerA));

        if (setA1.equals(answer)) {
            //questionList.set(editA,answerA);
            questionList.set(editQ, new Quiz(modifyQ + "\nA) " + modifyA1 + "\nB) " + modifyA2 + "\nC) " + modifyA3, answerA));
        }
        if (setA2.equals(answer)) {
            //questionList.set(editA,answerB);
            questionList.set(editQ, new Quiz(modifyQ + "\nA) " + modifyA1 + "\nB) " + modifyA2 + "\nC) " + modifyA3, answerB));
        }
        if (setA3.equals(answer)) {
            //questionList.set(editA,answerC);
            questionList.set(editQ, new Quiz(modifyQ + "\nA) " + modifyA1 + "\nB) " + modifyA2 + "\nC) " + modifyA3, answerC));
        }

    }

    void writeQuestion() throws Exception {

        FileOutputStream fos = new FileOutputStream("src/quiz/Files/questions.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(questionList);
        oos.flush();
        oos.close();
    }

    void readQuestion() throws Exception {

        FileInputStream fis = new FileInputStream("src/quiz/Files/questions.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        questionList = (LinkedList<Quiz>) ois.readObject();
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

    @Override
    public String toString() {
        return "Quiz{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                '}';
    }
}