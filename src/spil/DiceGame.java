package spil;

import java.io.IOException;

public class DiceGame {
    Field[] fields;
    Player[] players;
    DiceCup diceCup;

    DiceGame() {
        fields = createFields();
        diceCup = new DiceCup();
        this.players = getPlayers();
    }

    public void startGame() throws IOException {
        Player winner = getWinner();
        printWinner(winner);
        printGameInfo(players);
    }

    static Player[] getPlayers() {
        return new Player[] {
                new Player("Jens"),
                new Player("Børge")
        };
    }

    private void printWinner(Player winner) {
        System.out.println("-----------------------");
        System.out.printf("Tillykke %s du har vundet!", winner.getName());
    }

    private void printGameInfo(Player... players) {
        System.out.println();
        System.out.println("---------------------------------");
        for (int i = 0; i < players.length; i++) {
            System.out.printf("%s sluttede med %d penge!\n", players[i].getName(), players[i].getMoney());
        }
    }

    private Player getWinner() throws IOException {
        int playerTurn = 0;

        while (true) {
            Player currentPlayer = players[playerTurn];
            System.out.printf("%s TUR (Du har %d penge): \n", currentPlayer.getName(), currentPlayer.getMoney());

            castDices(diceCup, currentPlayer.getName());
            Field field = fields[diceCup.getDiceSum() - 1];

            System.out.println(field.fieldText);

            currentPlayer.changeMoney(field.value);
            if (currentPlayer.getMoney() > 3000) {
                break;
            }

            System.out.println();

            if (!field.getsAnotherTurn) {
                playerTurn = playerTurn + 1 == players.length ? 0 : playerTurn + 1;
                System.out.printf("Tryk enter for at fortsætte gå til %s tur\n", players[playerTurn].getName());
            } else {
                System.out.println("Tryk enter for at få en tur mere!");
            }

            System.in.read();
            clearConsole();
        }

        return players[playerTurn];
    }

    private void castDices(DiceCup diceCup, String player) {
        int[] terningResultater = diceCup.castDice();
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
