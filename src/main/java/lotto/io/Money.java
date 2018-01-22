package lotto.io;

import lotto.util.LottoUtil;

 public class Money {

    private final static int MIN_MONEY_UNIT = 1000;
    private int money;

     public Money(int money) {
        if (isUnderUnit(money)) throw new IllegalArgumentException();
        this.money = money;
    }

     public Money(String moneyStr) {
        if (!LottoUtil.isNumeric(moneyStr)) throw new IllegalArgumentException();
        int money = Integer.parseInt(moneyStr);
        if (isUnderUnit(money)) throw new IllegalArgumentException();
        this.money = money;
    }

    private boolean isUnderUnit(int money) {
        return money < MIN_MONEY_UNIT;
    }

     public int exchangeToLottoCount() {
        return money / MIN_MONEY_UNIT;
    }
}
