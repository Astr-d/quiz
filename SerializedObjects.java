package quiz;

import java.io.*;
import java.util.LinkedList;


public class SerializedObjects implements Serializable{

    Player player = new Player();

    Quiz quiz  = new Quiz();

    void writePlayer() throws Exception {
        //try {
            FileOutputStream fos = new FileOutputStream("src/quiz/Files/players.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(player.playerList);
            oos.flush();
            oos.close();
        //} catch (InvalidClassException e){

        //}

        System.out.println("Writeplayer success");
    }

    void readPlayer() throws Exception { // if (questList.length() <= )
        //try {
            FileInputStream fis = new FileInputStream("src/quiz/Files/players.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            player.playerList = (LinkedList<Player>) ois.readObject();
            ois.close();
        //}catch(InvalidClassException e){

        //}
        System.out.println("readPlayer success");

    }

    void writeQuestion() throws Exception {
        //try {
            FileOutputStream fos = new FileOutputStream("src/quiz/Files/questions.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(quiz.questionList);
            oos.flush();
            oos.close();
        //}catch(InvalidClassException e){

        //}
    }

    void readQuestion() throws Exception {

        try {
            FileInputStream fis = new FileInputStream("src/quiz/Files/questions.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            quiz.questionList = (LinkedList<Quiz>) ois.readObject();
            ois.close();
        }catch(EOFException e){
            System.out.println("Listan är tom");
        }
    }

}
