package by.starovoitov.shop.logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Wallet {

    private Money money; // Хранит текущее количество денег
    private Money credit; // Хранит кредит, лучше сделать private

    public Wallet(int amount) {
        this.money = new Money(amount);
        this.credit = new Money(0);
    }

    public Money getMoney() {
        return money;
    }
    @JsonCreator
    public Wallet(@JsonProperty("money") Money money, @JsonProperty("credit") Money credit) {
        this.money = money;
        this.credit = credit;
    }

    public Money getCredit() {
        return credit;
    }

    public void sendMoney(int amount, Wallet other) {
        if (money.getAmount() < amount) {
            int new_amount = amount - this.money.getAmount();
            this.money.setAmount(0);
            this.credit.setAmount(new_amount);
        }
        else {
            money.minusAmount(amount);
            other.getMoney().plusAmount(amount);
        }
    }

    public boolean receiveMoney(int amount, Wallet other) {
        if (other.getMoney().getAmount() < amount) {
            return false;
        } else {
            other.money.minusAmount(amount);
            this.money.plusAmount(amount);
            return true;
        }
    }

}