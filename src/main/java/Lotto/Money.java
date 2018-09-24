package Lotto;

public class Money {

    private static final int MONETARY_UNIT = 1000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public float rateOfReturn(float totalYieldMoney) {
        return totalYieldMoney / this.money * 100;
    }

    public int purchasedLottoNumber() {
        return this.money / MONETARY_UNIT;
    }

    public boolean isUnavailablePurchase() {
        return this.money < MONETARY_UNIT ? true : false;
    }

    public boolean isExistRemainder() {
        return (this.money % MONETARY_UNIT) != 0 ? true : false;
    }

    public boolean isExceedMoney(int count) {
        return purchasedLottoNumber() < count ? true : false;
    }

}
