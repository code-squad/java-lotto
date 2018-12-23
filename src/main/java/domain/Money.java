package domain;

import java.util.Map;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    public static final int WINNER_PRICE = 2000000000;
    public static final int SECOND_PRICE = 1500000;
    public static final int THIRD_PRICE = 50000;
    public static final int FORTH_PRICE = 5000;
    public static final int PERCENTAGE_RATIO = 100;

    private int money;

    public Money(int inputMoney) {
        this.money = inputMoney;
    }

    public int getCount() {
        return money / LOTTO_PRICE;
    }

    public int calculateRatio(Map<Integer, Integer> result) {
        return ((FORTH_PRICE * result.get(3)
                + (THIRD_PRICE * result.get(4))
                + (SECOND_PRICE * result.get(5))
                + (WINNER_PRICE * result.get(6))
        ) / this.money) * PERCENTAGE_RATIO;
    }
}
