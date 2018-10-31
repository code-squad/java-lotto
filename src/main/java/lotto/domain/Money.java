package lotto.domain;

import lotto.view.BelowLimitMoneyException;

import java.util.Objects;

public class Money {
    private static final int PRICE_LOTTO = 1000;
    private int inputMoney;

    public Money(int input) {
        if (input < PRICE_LOTTO) {
            throw new BelowLimitMoneyException("구입 금액은 1,000원 이상입니다.");
        }
        inputMoney = input;
    }
    // 돈, 수익과 관련된 객체
    public int getRateOfReturn(double prize) {
        return (int) ((prize / inputMoney) * 100);
    }

    public int getAvailableForPurchaseLotto() {
        return inputMoney / PRICE_LOTTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return inputMoney == money.inputMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputMoney);
    }


}
