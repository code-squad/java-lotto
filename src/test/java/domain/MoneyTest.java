package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void getLottoAmt() {
        int n = 14000;
        Money money = new Money(n);

        assertEquals(14, money.getLottoAmt());
    }

}