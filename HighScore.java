package quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HighScore {

    Player playerInfo;


    List<String> HSList = new ArrayList<>();

    void writeHighScore() throws Exception {
        //try {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Documents\\WORKSPACE\\EC_Utbildning\\Avancerad_java\\myAssignment\\src\\quiz\\Files\\highscore.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(HSList);
        oos.flush();
        oos.close();
        //}catch(InvalidClassException e){

        //}
        System.out.println("WriteHighScore success");

    }

    void readHighScore() throws Exception {

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Documents\\WORKSPACE\\EC_Utbildning\\Avancerad_java\\myAssignment\\src\\quiz\\Files\\highscore.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HSList = (List<String>) ois.readObject();
            ois.close();
        }catch(EOFException e){
            System.out.println("Listan är tom");
        }
    }

    public void printScoreBoard() throws Exception {

        readHighScore();

        System.out.println("*******************************************");
        System.out.println("*           HIGH SCORE's                  *");
        System.out.println("*******************************************");

        HSList.stream()
                .forEach(System.out::println);

    }
}
