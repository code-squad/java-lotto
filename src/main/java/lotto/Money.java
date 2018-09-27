package lotto;

import lotto.exception.IllegalMonetaryUnitException;
import lotto.exception.NotEnoughMoneyException;

public class Money {

    private static final int MONETARY_UNIT = 1000;
    private int money;

    public Money(int money) {
        if (isUnavailablePurchase(money)) {
            throw new NotEnoughMoneyException();
        }

        if (isExistRemainder(money)) {
            throw new IllegalMonetaryUnitException();
        }

        this.money = money;
    }

    public float rateOfReturn(float totalYieldMoney) {
        return totalYieldMoney / this.money * 100;
    }

    public int purchasedLottoNumber() {
        return this.money / MONETARY_UNIT;
    }

    public boolean isUnavailablePurchase(int money) {
        return money < MONETARY_UNIT;
    }

    public boolean isExistRemainder(int money) {
        return (money % MONETARY_UNIT) != 0;
    }

    public boolean isExceedMoney(int count) {
        return purchasedLottoNumber() < count;
    }

}
