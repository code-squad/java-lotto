package lottoGame.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    public void test_Money_getLottoCnt() {
        assertThat(Money.getLottoCnt(14000)).isEqualTo(14);
        assertThat(Money.getLottoCnt(1000)).isEqualTo(1);
    }

    @Test
    public void test_Money_getLottoProfitPer() {
        assertThat(Money.getLottoProfitPer(10000,1000)).isEqualTo("1000");
        assertThat(Money.getLottoProfitPer(5000,25000)).isEqualTo("20");
    }
}
