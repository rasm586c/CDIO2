package spil;

public class DiceCup {
    private final Dice[] dice;

    public DiceCup() {
        dice = new Dice[] { new Dice(), new Dice() }; // der er altid kun 2 terninger (final)
    }

    // Kaster begge terninger og retunerer dette
    public int[] castDices() {
        int[] kast = new int[dice.length];

        // Her laver vi kastne
        for (int i = 0; i < dice.length; i++) {
            Dice terning = dice[i];
            kast[i] = terning.cast();
        }

        return kast;
    }

    public int getDiceSum() {
        int sum = 0;
        for (int i = 0; i < dice.length; i++) { sum += dice[i].getValue(); }
        return sum;
    }

    public boolean isEqual() {
        for (int i = 0; i < dice.length; i++) {
            for (int j = 0; j < dice.length; j++) {
                if (dice[i] != dice[j]) return false;
            }
        }
        return true;
    }
}