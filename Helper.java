package quiz;

import java.util.Scanner;

public class Helper {

    private static Scanner scan = new Scanner(System.in);

    //Hjälper oss att skicka en scanner globalt
    public static String readString() {

      String input = scan.nextLine();
        return input;
    }


    public static int readInt() {

        int input = scan.nextInt();

        return input;
    }


    public static String emptyString() {

        String input = scan.next();

        return input;
    }
    // Hjälper oss att skicka en counter globalt
    public static int numberingList() {

        int counter = 0;

        return counter;
    }
}
