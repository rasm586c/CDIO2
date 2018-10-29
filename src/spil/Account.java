package spil;

public class Account {
    int money;

    Account(int money){
        if (money < 0) this.money = 0;
        else this.money = money;
    }

    public void changeMoney(int amount) {
        this.money += amount;
        if (this.money < 0) money = 0;
    }
}
