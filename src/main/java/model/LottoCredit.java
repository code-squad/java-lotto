package model;

public class LottoCredit {

    public static final int PRICE = 1000;
    private NaturalNumber amount;

    public LottoCredit(int money) {
        this.amount = new NaturalNumber(money / LottoCredit.PRICE);

    }

    public NaturalNumber getAvailableAmount(){
        return this.amount;
    }

    public int getMoney() {
        return this.amount.getNumber() * LottoCredit.PRICE;
    }


}
