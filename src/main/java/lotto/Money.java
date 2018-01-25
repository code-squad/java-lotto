package lotto;

/**
 * Created by Joeylee on 2018-01-25.
 */
public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int howManyLotto(int lottoPrice) {
        return this.money / lottoPrice;
    }

    public int rateTotal(int sum) {
        return (sum - this.money) / this.money * 100;
    }
}
