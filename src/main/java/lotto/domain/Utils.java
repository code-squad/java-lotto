package lotto.domain;

import java.util.List;

public class Utils {
    private static final int LOTTO_PRIZE = 1000;

    public static boolean isOverPurchaseAmount(List<List<Integer>> numbers, int money) {
        return money / LOTTO_PRIZE < numbers.size();
    }

    public static boolean isNotEnoughMoney(int money) {
        return money < LOTTO_PRIZE;
    }

    public static boolean isNotValidMoney(int money) {
        return money % LOTTO_PRIZE != 0;
    }

    public static int calcNumberOfManual(int money, int manual) {
        int total = money / LOTTO_PRIZE;
        return total - manual;
    }
}
