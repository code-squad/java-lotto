package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MoneyTest {
    @Test
    public void moneyTest() {
        Money money = new Money(10000);

        assertThat(money).isEqualTo(new Money(10000));
    }

    @Test
    public void addTest() {
        Money money = new Money(10000).add(new Money(5000));
        assertThat(money).isEqualTo(new Money(15000));
    }

    @Test
    public void subTest() {
        Money money = new Money(10000).sub(new Money(5000));
        assertThat(money).isEqualTo(new Money(5000));
    }

    @Test
    public void multiTest() {
        Money money = new Money(10000);
        assertThat(money.multi(2)).isEqualTo(new Money(20000));
    }

    @Test
    public void devideTest() {
        int no = new Money(10000).devide(new Money(5000));
        assertThat(no).isEqualTo(2);
    }

    @Test
    public void toNoTest() {
        Money money = new Money(10000);
        assertThat(money.toNo()).isEqualTo(10000);
    }

    @Test
    public void isLowerThanTest() {
        boolean result = new Money(10000).isLowerThan(new Money(20000));
        assertThat(result).isEqualTo(true);
    }
}
