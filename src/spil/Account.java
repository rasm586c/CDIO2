package spil;

public class Account {
    int balance;

    Account(int balance){
        if (balance < 0) this.balance = 0;
        else this.balance = 0;
    }

    public void changeBalance(int amount) {
        this.balance += amount;
        if (this.balance < 0) balance = 0;
    }

    public int getBalance() {
        return balance;
    }
}
