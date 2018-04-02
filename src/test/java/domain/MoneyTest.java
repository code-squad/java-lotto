package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoneyTest {

    @Test
    public void 돈입력유효값확인_true() {
        assertThat(Money.isValidMoney(1000), is(true));
    }

    @Test
    public void 돈입력유효값확인_false() {
        assertThat(Money.isValidMoney(0), is(false));
        assertThat(Money.isValidMoney(100), is(false));
    }

    @Test
    public void 출금테스트() {
        Money money = Money.of(5000);
        money.withDraw(1000);
        assertThat(money.getPresentMoney(), is(4000));
    }

    @Test
    public void 입금테스트() {
        Money money = Money.of(5000);
        money.depositEarnings(1000);
        assertThat(money.getPresentMoney(), is(6000));
    }

    @Test
    public void 수익률테스트() {
        Money money = Money.of(5000);
        money.withDraw(5000);
        money.depositEarnings(10000);
        assertThat(money.calcProfit(), is(100));
    }

}
