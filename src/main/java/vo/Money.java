package vo;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private int cash;

    private Money(int cash) {
        if(cash < 0) throw new IllegalArgumentException("Can't enter under 0");
        this.cash = cash;
    }

    public int calculateCountCanBuy(){
        return this.cash / LOTTO_PRICE;
    }

    Money multi(int count){
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

    private double div(int earningMoney){
        return earningMoney / (double)this.cash;
    }

    public static Money of(int cash){
        return new Money(cash);
    }

    public static Money ofText(String cashText){
        return new Money(Integer.parseInt(cashText));
    }

    @Override
    public String toString() {
        return String.valueOf(cash);
    }
}
