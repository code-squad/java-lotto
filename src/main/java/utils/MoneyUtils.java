package utils;

public class MoneyUtils {
    private static final int LOTTO_PRICE = 1000;

    public static int calcBuyAmount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 1개 당 " + LOTTO_PRICE + "원 입니다.");
        }
        return money / LOTTO_PRICE;
    }

    public static int calcProfit(long totalPrizeMoney, int amount) {
        return (int) (totalPrizeMoney / calcConsumptionMoney(amount) * 100);
    }

    private static int calcConsumptionMoney(int amount) {
        return amount * LOTTO_PRICE;
    }
}
