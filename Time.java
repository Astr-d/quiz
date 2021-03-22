package quiz;

import java.time.*;

public class Time extends Thread {

    Thread thread = new Thread();
    Time timer = new Time(); // timer is a thread instance

    // timer.start(); this will start a new thread => timer.run();

    @Override
    public void run() {

        LocalTime start = LocalTime.now(); // Option one
        LocalTime end = LocalTime.now();
        //Instant instant = Instant.now(); // Option two

        //System.out.println(start);
        //System.out.println(end);
        //System.out.println(instant);
        Duration dur = Duration.between(start, end);
        System.out.println(dur.getNano() + " Nano Seconds between Start and End");

        System.out.println("This code is running in a thread");
    }

}
