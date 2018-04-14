package lotto.domain;

/**
 * @author sangsik.kim
 */
public class Money {
    public static final int PRICE_PER_LOTTO = 1000;

    private long amount;

    private Money(long amount) {
        if (amount < PRICE_PER_LOTTO) {
            throw new IllegalArgumentException("NOT ENOUGH MONEY");
        }
        this.amount = amount;
    }

    public static Money of(long amount) {
        return new Money(amount);
    }

    public static Money of(int amount) {
        return new Money(amount);
    }

    public Money spend(long paidAmount) {
        if (this.amount < paidAmount) {
            throw new IllegalArgumentException("NOT ENOUGH MONEY");
        }
        this.amount -= paidAmount;
        return this;
    }

    public Money spend(int paidAmount) {
        return spend((long) paidAmount);
    }

    public int calculateNumberOfPurchase(int pricePerLotto) {
        return Math.toIntExact(this.amount / pricePerLotto);
    }
}
