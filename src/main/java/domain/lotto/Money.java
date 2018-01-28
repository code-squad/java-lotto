package domain.lotto;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Money of(int money) {
        return new Money(money);
    }
}
