package quiz;

import java.time.*;
import java.util.Scanner;

public class Time extends Thread {



    Game game = new Game();
    Player player = new Player();
    Quiz quiz = new Quiz();

    public boolean isRunning = true;
    int i = 1;

    @Override
    public void run() {

        while (isRunning) {

            Scanner input = new Scanner(System.in);
            System.out.println("Thread starts" + Thread.currentThread().getName());

                LocalTime start = LocalTime.now();

               Game.helper = input.nextLine();

                LocalTime end = LocalTime.now();

                double duration = Duration.between(start, end).toMillis() / 1000d;


            System.out.println(duration + "s");

        }
    }

    public void stop1(){
        System.out.println("Thread stops");
        isRunning = false;
        }
}

