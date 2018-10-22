package spil;

import java.util.Random;

public class Raflebæger {
    private final Terning[] terninger;

    public Raflebæger() {
        terninger = new Terning[] { new Terning(), new Terning() }; // der er altid kun 2 terninger (final)
    }

    // Kaster begge terninger og retunerer dette
    public int[] kastTerninger() {
        int[] kast = new int[terninger.length];

        // Her laver vi kastne
        for (int i = 0; i < terninger.length; i++) {
            Terning terning = terninger[i];
            kast[i] = terning.kast();
        }

        return kast;
    }

    public int getTerningSum() {
        int sum = 0;
        for (int i = 0; i < terninger.length; i++) { sum += terninger[i].getVærdi(); }
        return sum;
    }

    public boolean erEns() {
        for (int i = 0; i < terninger.length; i++) {
            for (int j = 0; j < terninger.length; j++) {
                if (terninger[i] != terninger[j]) return false;
            }
        }
        return true;
    }
}