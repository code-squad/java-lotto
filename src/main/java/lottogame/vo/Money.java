package lottogame.vo;

public class Money {
    public static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("돈은 음수가 될 수 없습니다.");
        }
        this.money = money;
    }

    public static Money of(String text){
        return new Money(Integer.parseInt(text));
    }

    public int value(){
        return money;
    }

    public int howManyBuyLotto(){
        return money / LOTTO_PRICE;
    }
}
