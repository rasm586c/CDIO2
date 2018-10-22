package spil;

import java.util.Random;

public class Terning {
    Random random;
    int værdi = 1;
    final int diceSides;

    Terning() {
        this.random = new Random();
        diceSides = 6;
    }

    Terning(int diceSides) { // Flere sider!!
        this.random = new Random();
        this.diceSides = diceSides;
    }

    // Retunerer en værdi mellem 1-6
    public int kast() {
        random = new Random(random.nextInt());//tving ny random per kald
        værdi = random.nextInt(6)+1;
        return værdi;
    }

    public int getVærdi() { return værdi; }
}