package com.codesquad.lotto.domain;

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
        final long value = money.getValue();
        assertThat(value).isEqualTo(3000);
    }

    @Test
    public void 조회_5000() {
        final Money money = new Money(5000);
        final long value = money.getValue();
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

    @Test
    public void 더하기_1000() {
        final Money result = money.add(new Money(1000));
        assertThat(result).isEqualTo(new Money(6000));
    }

    @Test
    public void 더하기_2000() {
        final Money result = money.add(new Money(2000));
        assertThat(result).isEqualTo(new Money(7000));
    }

    @Test
    public void 곱하기_10() {
        final Money result = money.multiply(10);
        assertThat(result).isEqualTo(new Money(50000));
    }

    @Test
    public void 곱하기_5() {
        final Money result = money.multiply(5);
        assertThat(result).isEqualTo(new Money(25000));
    }

    @Test
    public void 수익율_100() {
        final Money winMoney = new Money(10000);
        final Money payment = new Money(5000);
        final int profitRate = Money.calculateProfitRate(winMoney, payment);
        assertThat(profitRate).isEqualTo(100);
    }

    @Test
    public void 수익율_400() {
        final Money winMoney = new Money(5000);
        final Money payment = new Money(1000);
        final int profitRate = Money.calculateProfitRate(winMoney, payment);
        assertThat(profitRate).isEqualTo(400);
    }

    @Test
    public void 돈크기40억() {
        final Money money = new Money(4_000_000_000L);
        assertThat(money.getValue()).isEqualTo(4_000_000_000L);
    }
}
