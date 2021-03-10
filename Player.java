package quiz;

import java.io.Serializable;

public class Player extends Person implements Serializable {

    int score;
    int playedGames;

    public Player(String name, int age, String eMail, int score, int playedGames) {
        super(name, age, eMail);
        this.score = score;
        this.playedGames = playedGames;
    }
}
