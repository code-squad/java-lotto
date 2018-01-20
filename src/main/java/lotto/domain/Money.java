package lotto.domain;

public class Money {

    private int  money;

    public Money(int money) {
        if (isNotMoneyRange(money)) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    private boolean isNotMoneyRange(int money) {
        return money % 1000 != 0 || money < 1000 || money > 1000000000;
    }

    public int buyableLottoCount() {
        return this.money / 1000;
    }
}
