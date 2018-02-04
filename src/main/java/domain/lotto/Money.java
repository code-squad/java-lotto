package domain.lotto;

public class Money {
    private int value;

    private Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Money of(int inputMoney) {
        int money = inputMoney;
        if(money <= 0){
            money = 0;
        }

        return new Money(money);
    }
}
