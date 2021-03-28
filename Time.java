package quiz;

import java.time.*;
import java.util.ArrayList;
import java.util.List;


public class Time {
    public static LocalTime playerOneStart;
    public static LocalTime playerTwoStart;

    public static List<Duration> playerOneList = new ArrayList<>();
    public static List<Duration> playerTwoList = new ArrayList<>();

    public void startTime(int player){
        if (player == 0) {
            playerOneStart = LocalTime.now();
        } else if (player == 1) {
            playerTwoStart = LocalTime.now();
        }
    }

    public void endTime(int playerIndex){

        if (playerIndex == 0) {

            LocalTime playOneStop = LocalTime.now();

            Duration playOneLapsed = Duration.between(playerOneStart, playOneStop);

            playerOneList.add(playOneLapsed);

            System.out.println(playOneLapsed.toMillis() / 1000d + " sekunder.");

        } else if (playerIndex == 1) {

            LocalTime playTwoStop = LocalTime.now();
            Duration playerTwoLapsed = Duration.between(playerTwoStart, playTwoStop);
            playerTwoList.add(playerTwoLapsed);
            System.out.println(playerTwoLapsed.toMillis() / 1000d + " sekunder.");

        }
    }

    public void endTime2(int playerIndex){
        if (playerIndex == 0) {

            LocalTime playOneStop = LocalTime.now();
            Duration playOneLapsed = Duration.between(playerOneStart, playOneStop);

            playerOneList.add(playOneLapsed);
            System.out.println(playOneLapsed.toMillis() / 1000d + " sekunder");


        } else if (playerIndex == 1) {

            LocalTime playTwoStop = LocalTime.now();
            Duration playerTwoLapsed = Duration.between(playerTwoStart, playTwoStop);
            playerTwoList.add(playerTwoLapsed);
            System.out.println(playerTwoLapsed.toMillis() / 1000d + " sekunder");

        }
    }

}
