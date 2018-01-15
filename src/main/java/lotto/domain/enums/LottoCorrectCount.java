package lotto.domain.enums;

public enum LottoCorrectCount {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private int value;
    private int profit;

    LottoCorrectCount(int value, int profit) {
        this.value = value;
        this.profit = profit;
    }

    public boolean isCorrect(int count) {
        return value == count;
    }

    public int getValue() {
        return value;
    }

    public int getProfit() {
        return profit;
    }
}
