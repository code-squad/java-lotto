package com.codesquad.lotto.vo;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    private Money money;

    @Before
    public void setUp() throws Exception {
        money = new Money(5000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수생성() {
        new Money(-1000);
    }

    @Test
    public void zero생성() {
        new Money(0);
    }

    @Test
    public void 조회_3000() {
        final Money money = new Money(3000);
        final int value = money.getValue();
        assertThat(value).isEqualTo(3000);
    }

    @Test
    public void 조회_5000() {
        final Money money = new Money(5000);
        final int value = money.getValue();
        assertThat(value).isEqualTo(5000);
    }

    @Test
    public void 나누기_1000() {
        final int quotient = money.divide(new Money(1000));
        assertThat(quotient).isEqualTo(5);
    }

    @Test
    public void 나누기_2000() {
        final int quotient = money.divide(new Money(2000));
        assertThat(quotient).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 나누기0() {
        money.divide(new Money(0));
    }
}
