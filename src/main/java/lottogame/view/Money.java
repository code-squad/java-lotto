package lottogame.view;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 0원보다 커야 합니다.");
        }
        this.money = money;
    }

    public int value(){
        return money;
    }

    int howManyBuyLotto(){
        return money / LOTTO_PRICE;
    }
}
