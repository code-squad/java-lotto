package lotto.domain;

/**
 * @author sangsik.kim
 */
public class Money {
    private long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public long valueOf() {
        return this.amount;
    }

    public Money spend(long paidAmount) {
        if (this.amount < paidAmount) {
            throw new IllegalArgumentException("NOT ENOUGH MONEY");
        }
        return new Money(this.amount - paidAmount);
    }

    public Money spend(int paidAmount) {
        return spend((long) paidAmount);
    }
}
