package spil;

public class Player {
    final String name;
    Account account;

    public Player(String name) {
        this.name = name;
        account = new Account(1000);
    }

    // Ændrer spillerens penge med amount
    public  void changeMoney(int amount) { account.changeMoney(amount); }

    public String getName() { return name; }
    public int getMoney() { return account.money; }
}
