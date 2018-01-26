package lotto;

/**
 * Created by Joeylee on 2018-01-25.
 */
public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int howManyLotto(int lottoPrice, int selfLottoCount) {
        return (this.money - lottoPrice * selfLottoCount) / lottoPrice;
    }

    public int rateTotal(int sum) {
        return (sum - this.money) / this.money * 100;
    }

    public boolean vaildCheck(Money wantPurchaseMoney, int selfLottoMoney) {
        if(wantPurchaseMoney.money < 0  || wantPurchaseMoney.money < selfLottoMoney) {
            return false;
        }
        return true;
    }
}
