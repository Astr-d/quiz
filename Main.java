package quiz;

import java.io.Serializable;


public class Main implements Serializable {



    public static void main(String[] args) throws Exception  {
        Player player = new Player();
        player.readPlayer();
        Game game = new Game();

        game.menuSwitch();

    }

    void startMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("*                                                                                   *");
        System.out.println("* VÄLKOMMEN TILL SPELET QUIZ!                                                       *");
        System.out.println("*                                - made by :: Trong :: Astrid :: Johannes :: Johan  *");
        System.out.println("*************************************************************************************");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println(" Tryck in en siffra för vad du vill göra");
        System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        System.out.println(" > [1] Starta spelet");
        System.out.println(" > [2] Visa HIGH SCORE's");
        System.out.println(" > [3] Visa en lista med frågorna");
        System.out.println(" > [4] Lägg till en fråga");
        System.out.println(" > [5] Redigera en fråga");
        System.out.println(" > [6] Ta bort en fråga");
        System.out.println(" > [0] Avsluta programmet \n");
        System.out.println("Skriv ditt val här: ");
    }

}

