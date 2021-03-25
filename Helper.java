package quiz;

import java.util.Scanner;

public class Helper {

    private static Scanner scan = new Scanner(System.in);

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

    public static int numberingList() {

        int counter = 0;

        return counter;
    }
}
