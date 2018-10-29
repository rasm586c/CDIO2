package spil;

import java.util.Random;

public class Dice {
    Random random;
    int value = 1;
    final int diceSides;

    Dice() {
        this.random = new Random();
        diceSides = 6;
    }

    Dice(int diceSides) { // Flere sider!!
        this.random = new Random();
        this.diceSides = diceSides;
    }

    // Retunerer en værdi mellem 1-6
    public int castDie() {
        random = new Random(random.nextInt());//tving ny random per kald
        value = random.nextInt(6)+1;
        return value;
    }

    public int getValue() { return value; }
}