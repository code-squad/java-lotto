package lotto;

import lotto.exception.IllegalMonetaryUnitException;
import lotto.exception.NotEnoughMoneyException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test(expected = NotEnoughMoneyException.class)
    public void 구매_금액_부족() {
        Money money = new Money(1);
    }

    @Test
    public void 구매_가능() {
        Money money = new Money(1000);
        assertThat(money.isUnavailablePurchase(1000)).isEqualTo(false);
    }

    @Test(expected = IllegalMonetaryUnitException.class)
    public void 천원_미만_단위_입력() {
        Money money = new Money(1100);
    }

    @Test
    public void 정상_단위_입력() {
        Money money = new Money(1000);
        assertThat(money.isExistRemainder(1000)).isEqualTo(false);
    }

    @Test
    public void 구매_가능_숫자_초과() {
        Money money = new Money(1000);
        assertThat(money.isExceedMoney(10)).isEqualTo(true);
    }

    @Test
    public void 구매_가능_숫자_이하() {
        Money money = new Money(10000);
        assertThat(money.isExceedMoney(10)).isEqualTo(false);
    }

    @Test
    public void 구매한_로또_개수() {
        Money money = new Money(2000);
        assertThat(money.purchasedLottoNumber()).isEqualTo(2);
    }

    @Test
    public void 수익률() {
        Money money = new Money(1000);
        assertThat(money.rateOfReturn(5000)).isEqualTo(500);
    }

}
