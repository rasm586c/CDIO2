package spil;

import java.io.IOException;

public class TerningSpil {
    Field[] fields;
    Spiller[] spillers;
    Raflebæger raflebæger;

    TerningSpil() {
        fields = createFields();
        raflebæger = new Raflebæger();
        this.spillers = getPlayers();
    }

    public void startSpil() throws IOException {
        Spiller vinder = findVinder();
        printVinder(vinder);
        printSpilInfo(spillers);
    }

    static Spiller[] getPlayers() {
        return new Spiller[] {
                new Spiller("Jens"),
                new Spiller("Børge")
        };
    }

    private void printVinder(Spiller vinder) {
        System.out.println("-----------------------");
        System.out.printf("Tillykke %s du har vundet!", vinder.getName());
    }

    private void printSpilInfo(Spiller... spillers) {
        System.out.println();
        System.out.println("---------------------------------");
        for (int i = 0; i < spillers.length; i++) {
            System.out.printf("%s sluttede med %d penge!\n", spillers[i].getName(), spillers[i].getMoney());
        }
    }

    private Spiller findVinder() throws IOException {
        int spillerTur = 0;

        while (true) {
            Spiller nuværendeSpiller = spillers[spillerTur];
            System.out.printf("%s TUR (Du har %d penge): \n", nuværendeSpiller.getName(), nuværendeSpiller.getMoney());

            castDices(raflebæger, nuværendeSpiller.getName());
            Field field = fields[raflebæger.getTerningSum() - 1];

            System.out.println(field.fieldText);

            nuværendeSpiller.changeMoney(field.value);
            if (nuværendeSpiller.getMoney() > 3000) {
                break;
            }

            System.out.println();

            if (!field.getsAnotherTurn) {
                spillerTur = spillerTur + 1 == spillers.length ? 0 : spillerTur + 1;
                System.out.printf("Tryk enter for at fortsætte gå til %s tur\n", spillers[spillerTur].getName());
            } else {
                System.out.println("Tryk enter for at få en tur mere!");
            }

            System.in.read();
            clearConsole();
        }

        return spillers[spillerTur];
    }

    private void castDices(Raflebæger raflebæger, String player) {
        int[] terningResultater = raflebæger.kastTerninger();
        System.out.printf("%s slog %d og %d!\n", player, terningResultater[0], terningResultater[1]);
    }

    private void clearConsole() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    private Field[] createFields() {
        return new Field[] {
                null, // Man kan ikke slå 1 med 2 terninger!
                new Field("Tower", 250, "Du har fundet tårne, og finder gamle skatte. Du får 250 !"),
                new Field("Crater", -100, "Du faldt ned i et krater og mistede 100 :("),
                new Field("Palace Gates", 100, "Du kom til et palads! 100 til dig!"),
                new Field("Cold Desert", -20, "Du landede i en kold ørken. Øv! -20"),
                new Field("Walled City", 180, "Du fandt walled city! Du får 180"),
                new Field("Monastery", 0, "Du kom til monastery og fik ingenting"),
                new Field("Black Cave", -70, "Du befinder dig nu i en sort grotte, -70"),
                new Field("Huts in the mountain", 60, "Du fandt nogle små hytter på et bjerg! Og får 60!"),
                new Field("The Werewall (werewolf-wall)", -80, "Øv! Du kom til varulve grotten og mistede 80! Men du får en ekstra tur!", true),
                new Field("The pit", -50, "Du landede på the pit og mistede 50"),
                new Field("The goldmine", 650, "Du har fundet guld i bjergene og sælger det for 650, du er rig!"),
        };
    }
}
