package domain;

import java.util.Objects;

public class Money {
    public static final int LOTTO_PRICE = 1_000;
    private int money;

    public Money(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("[구입 금액 입력이 적절하지 않습니다]");
        }
        this.money = money;
    }

    public int countOfLottos() {
        return money / LOTTO_PRICE;
    }

    public Money spendAfterMoney(int lottoCount) {
        return new Money(money - (lottoCount * LOTTO_PRICE));
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
