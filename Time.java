package quiz;

import java.time.*;
import java.util.Scanner;

public class Time extends Thread {

    public Time(String str) {

        super(str);
    }
    Game game = new Game();
    Player player = new Player();

    // en boolean som är true när spelare 1 spelar

    // if-sats

    /*if (player1 = true) {

        Här startas tidräkningen för player 1
       .
        } else {

        Här är player 1 falsk, så tidräkningen börjar för player2

        }
     */
    boolean player1 = true;



           // player1 = player.playerList.get(0).getName();

    public boolean stop = false;
    int i = 1;

    @Override
    public void run() {
        System.out.println(player.getName());

        while (!stop) {

            try {

                LocalTime start = LocalTime.now();

                String test = Helper.readString();
                System.out.println(test);

                LocalTime end = LocalTime.now();

                double duration = Duration.between(start, end).toMillis() / 1000d;

                System.out.println(duration + "s");

            } catch (Exception e) {
            }

            System.out.println(i);
            i++;
        }
    }


    // det är duration vi vill veta


}


