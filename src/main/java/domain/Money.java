package domain;

import java.util.Objects;

public class Money {
    private int money;
    private int income = 0;


    private Money(int money) {
        this.money = money;
    }

    void increase(int moneyMCount) {
        this.income = this.income + (moneyMCount);
    }

    long yield() {
        return (income / money) * 100L;
    }

    static Money of(int input) {
        return new Money(input);
    }

    int getMoney() {
        return money;
    }

    int getNewMoney() {
        return this.income;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
