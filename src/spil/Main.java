package spil;

public class Main {
    public static void main(String[] args) {
        Field[] fields = createFields();

        Spiller[] spillers = new Spiller[] {
            new Spiller("Jens"),
            new Spiller("Børge")
        };

        Raflebæger raflebæger = new Raflebæger();

        int spillerTur = 0;
        while (true) {
            Spiller nuværendeSpiller = spillers[spillerTur];
            System.out.println("Det er nu %s tur!", nuværendeSpiller.getName());

            // Kast terninger!
            castDices(raflebæger);

            // Find field ud fra terning sum
            Field field = fields[raflebæger.getTerningSum()];

            // Ændrer penge baseret på field værdi!
            nuværendeSpiller.changeMoney(field.value);

            // Har spilleren vundet?
            if (nuværendeSpiller.getMoney() > 3000) {
                System.out.printf("Tillykke %s du har vundet!", nuværendeSpiller.getName());
                break;
            }

            // Får spilleren en ekstra tur? Ellers er det næste spillers tur!
            if (!field.getsAnotherTurn) {
                spillerTur++;
            }
        }
    }

    static void castDices(Raflebæger raflebæger) {
        int[] terningResultater = raflebæger.kastTerninger();
        System.out.printf("Spilleren kastede slog %d og %d!\n", terningResultater[0], terningResultater[1]);
    }
    static Field[] createFields() {
        return new Field[] {
                null, // Man kan ikke slå 1 med 2 terninger!
                new Field("Tower", 250, ""),
                new Field("Crater", -100, ""),
                new Field("Palace Gates", 100, ""),
                new Field("Cold Desert", -20, ""),
                new Field("Walled City", 180, ""),
                new Field("Monastery", 0, ""),
                new Field("Black Cave", -70, ""),
                new Field("Huts in the mountain", 60, ""),
                new Field("The Werewall (werewolf-wall)", -80, "", true),
                new Field("The pit", -50, ""),
                new Field("The goldmine", 650, "Du har fundet guld i bjergene og sælger det for 650, du er rig!"),
        };
    }
}
