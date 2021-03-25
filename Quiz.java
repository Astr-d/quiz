package quiz;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Quiz {

    private String question;
    private String answer = "ja";

    private String answerA = "A";
    private String answerB = "B";
    private String answerC = "C";

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;

    }

    LinkedList<Quiz> questionList = new LinkedList<>();

    public Quiz() {
    }

    void showList() {

        int nr = Helper.numberingList();

        for (int i = 0; i < questionList.size(); i++) {
            nr++; // Fungerar bara en gång, adderas när man visar listan flera gånger.
            System.out.println(nr + ". " + questionList.get(i).question + "\n");
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

        String addQuestionAnswer = addQ + "\nA) " + answer1 + "\nB) " + answer2 + "\nC) " + answer3;

        if (addA1.equalsIgnoreCase(answer)) {
            questionList.add(new Quiz(addQuestionAnswer, answerA));

        }
        if (addA2.equalsIgnoreCase(answer)) {
            questionList.add(new Quiz(addQuestionAnswer, answerB));

        }
        if (addA3.equalsIgnoreCase(answer)) {
            questionList.add(new Quiz(addQuestionAnswer, answerC));

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

        questionList
                .remove(removeQ);
    }

    void editQuestion() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("   Redigera en fråga    ");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("Vilken fråga vill du redigera? \n");

        int counter = Helper.numberingList();
        String userStringInput = Helper.readString();
        int userIntInput = Helper.readInt();

        for (int i = 0; i < questionList.size(); i++) {
            counter++;
            System.out.println(counter + ". " + questionList.get(i).question + "\n");
        }


        System.out.println("Vilken fråga vill du redigera? ");
        int editQ = userIntInput;
        Helper.emptyString();

        System.out.println("Redigera din fråga: ");
        String modifyQ = userStringInput;

        System.out.println("Skriv in svarsalternativ 1:");
        String modifyA1 = userStringInput;

        System.out.println("Är detta svar rätt?");
        String setA1 = userStringInput; // ja / nej

        System.out.println("Skriv in svarsalternativ 2:");
        String modifyA2 = userStringInput;

        System.out.println("Är detta svar rätt?");
        String setA2 = userStringInput;

        System.out.println("Skriv in svarsalternativ 3:");
        String modifyA3 = userStringInput;

        System.out.println("Är detta svar rätt?");
        String setA3 = userStringInput;


        String newQuestionAnswer = modifyQ + "\nA) " + modifyA1 + "\nB) " + modifyA2 + "\nC) " + modifyA3;

        validation(setA1, setA2, setA3, editQ, newQuestionAnswer);

    }

    public void validation(String changeAnswer1, String changeAnswer2, String changeAnswer3, int getIndex, String newQA) {
        if (changeAnswer1.equals(answer)) {

            questionList.set(getIndex, new Quiz(newQA, answerA));
        }
        if (changeAnswer2.equals(answer)) {

            questionList.set(getIndex, new Quiz(newQA, answerB));
        }
        if (changeAnswer3.equals(answer)) {

            questionList.set(getIndex, new Quiz(newQA, answerC));
        }
    }

    public void pause() {
        System.out.println("\n> Tryck ENTER för att fortsätta < ");
        new java.util.Scanner(System.in).nextLine();
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
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