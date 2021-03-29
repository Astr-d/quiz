package quiz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HighScore {

    Player playerInfo;


    List<Player> HSList = new ArrayList<>();


    /*
    * För varje spelad omgång lägg till användarna i listan
    * */





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

            HSList = (List<Player>) ois.readObject();
            ois.close();
        }catch(EOFException e){
            System.out.println("Listan är tom");
        }

        System.out.println("Read HighScore success");
    }

    public void printScoreBoard(){

        HSList.stream()
                .forEach(System.out::println);

    }
}
