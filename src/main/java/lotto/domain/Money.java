package lotto.domain;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private static long money;

    private Money (long money) {
        if (money < 1000) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public static Money of (long money) {
        return new Money(money);
    }

    public static int getCountOfPurchasedLotto(long money) {
        return (int) money / LOTTO_PRICE;
    }

    public static double getRateOfInvestment (int price) {
        return (double) price / money * 100;
    }
}
