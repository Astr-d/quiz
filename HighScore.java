package quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HighScore {

    Player playerInfo;


    List<HighScore> HSList = new ArrayList<>();


    /*
    * För varje spelad omgång lägg till användarna i listan
    * */





    void writeHighScore() throws Exception {
        //try {
        FileOutputStream fos = new FileOutputStream("quiz/Files/highscore.txt");
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
            FileInputStream fis = new FileInputStream("quiz/Files/highscore.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            HSList = (List<HighScore>) ois.readObject();
            ois.close();
        }catch(EOFException e){
            System.out.println("Listan är tom");
        }

        System.out.println("Read HighScore success");
    }

}
