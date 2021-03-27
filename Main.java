package quiz;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) throws Exception {

        Game game = new Game();

        game.menuSwitch();

    }

    void startMenu() {

        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println(" Tryck in en siffra för vad du vill göra");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println(" > [1] Starta spelet");
        System.out.println(" > [2] Visa en lista med frågorna");
        System.out.println(" > [3] Lägg till en fråga");
        System.out.println(" > [4] Ta bort en fråga");
        System.out.println(" > [5] Redigera en fråga");
        System.out.println(" > [0] Avsluta programmet \n");
        System.out.println("Skriv ditt val här: ");
    }

}

/*
Lambdauttryck
Streams
Regular expressions
Serialisering
Date and time
Avancerad objektorientering
Threads
Annotations
Reflection
Design patterns
 */