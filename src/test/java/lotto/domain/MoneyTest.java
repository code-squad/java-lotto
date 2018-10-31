package lotto.domain;

import lotto.view.BelowLimitMoneyException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void 생성자() {
        Money money = new Money(1000);
        assertThat(money).isEqualTo(new Money(1000));
        assertThat(money).isNotEqualTo(new Money(2000));
    }

    @Test(expected = BelowLimitMoneyException.class)
    public void 생성자_입력금액미만() {
        Money money = new Money(999);
    }

    @Test
    public void 수익률계산1() {
        Money money = new Money(14000);
        int rateOfReturn = money.getRateOfReturn(5000);
        assertThat(rateOfReturn).isEqualTo(35);
    }

    @Test
    public void 수익률계산2() {
        Money money = new Money(14000);
        int rateOfreturn = money.getRateOfReturn(0);
        assertThat(rateOfreturn).isEqualTo(0);
    }

    @Test
    public void 구입가능한로또개수() {
        Money money = new Money(2000);
        int count = money.getAvailableForPurchaseLotto();
        assertThat(count).isEqualTo(2);
    }
}
