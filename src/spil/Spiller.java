package spil;

public class Spiller {
    final String name;
    int money;

    public Spiller(String name) {
        this.name = name;
        money = 1000;
    }

    // Ændrer spillerens penge med delta
    public  void changeMoney(int delta) { money += delta; }

    public String getName() { return name; }
    public int getMoney() { return money; }
}
