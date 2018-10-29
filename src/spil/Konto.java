package spil;

public class Konto {
    int money;

    Konto(int money){
        if (money < 0) this.money = 0;
        else this.money = money;
    }

    void changeMoney(int amount) {
        this.money += amount;
        if (this.money < 0) money = 0;
    }
}
