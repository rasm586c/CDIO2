package spil;

public class Spiller {
    final String name;
    Konto konto;

    public Spiller(String name) {
        this.name = name;
        konto = new Konto(1000);
    }

    // Ændrer spillerens penge med amount
    public  void changeMoney(int amount) { konto.changeMoney(amount); }

    public String getName() { return name; }
    public int getMoney() { return konto.money; }
}
