package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {
    @Test
    public void 구매생성() {
        Money money = new Money(5000);
        int numOfManualLotto = 2;

        new Purchase(money, numOfManualLotto);
    }

    @Test(expected = RuntimeException.class)
    public void 구매생성_금액부족() {
        Money money = new Money(5000);
        int numOfManualLotto = 6;

        new Purchase(money, numOfManualLotto);
    }

    @Test
    public void 자동로또갯수() {
        Money money = new Money(5000);
        int numOfManualLotto = 2;
        Purchase purchase = new Purchase(money, numOfManualLotto);

        int autoSize = purchase.getAutoSize();

        assertThat(autoSize).isEqualTo(3);
    }
}