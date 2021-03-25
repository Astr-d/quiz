package quiz;

import java.time.*;

public class Time extends Thread {



    Game game = new Game();
    Player player = new Player();
    Quiz quiz = new Quiz();

    public boolean isRunning = true;
    int i = 1;

    @Override
    public void run() {

        while (isRunning) {

            System.out.println("Thread starts");

            System.out.println("Inside while-loop");
            try {

            /*for (int i = 0; i < 2; i++) {
                System.out.println(player.playerList.get(i).getName());
            }*/

                LocalTime start = LocalTime.now();


                //String startEndTime = Helper.readString();
                Helper.readString();

                //sleep(2000);
                //System.out.println(startEndTime);
                LocalTime end = LocalTime.now();

                double duration = Duration.between(start, end).toMillis() / 1000d;

                System.out.println(duration + "s");


            } catch (Exception e) {
            }


        }


    }

    public void stop1(){
        System.out.println("Thread stops");
        isRunning = false;
        }

}

