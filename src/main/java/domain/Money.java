package domain;

import java.util.Objects;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public Money add(Money money) {
        return new Money(this.money + money.money);
    }

    public Money sub(Money money) {
        return new Money(this.money - money.money);
    }

    public Money multi(int no) {
        return new Money(this.money * no);
    }

    public int devide(Money money) {
        return this.money / money.money;
    }

    public int toNo() {
        return money;
    }

    public boolean isLowerThan(Money money) {
        return this.money < money.money;
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

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}
