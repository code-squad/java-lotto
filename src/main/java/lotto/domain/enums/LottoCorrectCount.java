package lotto.domain.enums;

public enum  LottoCorrectCount {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private int value;

    LottoCorrectCount(int value) {
        this.value = value;
    }

    public boolean isCorrect(int count) {
        return value == count;
    }

    public int getValue() {
        return value;
    }
}
