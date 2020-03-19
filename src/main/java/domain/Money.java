package domain;

import vo.Rank;

import java.util.Map;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    public static final String INVALID_MONEY_FORMAT_MSG = "로또는 천 원 단위로만 판매합니다";

    private int amount;

    public Money(int amount) {
        isValidMoney(amount);
        this.amount = amount;
    }

    private void isValidMoney(int amount) {
        if(amount % LOTTO_PRICE != 0 || amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(INVALID_MONEY_FORMAT_MSG);
        }
    }

    public int getLottoAmount() {
        return amount / LOTTO_PRICE;
    }

    public int calculateTotalRateOfReturn(Map<Rank, Integer> rankCount) {
        long sum = 0;
        for (Rank value : Rank.values()) {
            sum += value.calculateTotalEarningMoney(rankCount.get(value));
        }
        return (int) (sum / amount);
    }
}
