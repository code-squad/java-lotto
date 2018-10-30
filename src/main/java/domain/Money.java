package domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private int cash;

    public Money(int cash) {
        if(cash < 0) throw new IllegalArgumentException("Can't enter under 0");
        this.cash = cash;
    }

    public int calculateCountCanBuy(){
        return this.cash / LOTTO_PRICE;
    }

    public Money multi(int count){
        return new Money(this.cash * count);
    }

    public Money add(Money other){
        return other.add(this.cash);
    }

    public Money add(int cash){
        return new Money(this.cash + cash);
    }

    public double div(Money investedMoney){
        return investedMoney.div(this.cash);
    }

    public double div(int earningMoney){
        return earningMoney / (double)this.cash;
    }

    @Override
    public String toString() {
        return String.valueOf(cash);
    }
}
