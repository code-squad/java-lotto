package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void getCountOfBuy() {
        assertThat(Lotto.getCountOfBuy(12000)).isEqualTo(12);
        assertThat(Lotto.getCountOfBuy(11500)).isEqualTo(11);
        assertThat(Lotto.getCountOfBuy(11000)).isEqualTo(11);
        assertThat(Lotto.getCountOfBuy(9999)).isEqualTo(9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCountOfBuy_음수인경우() {
        Lotto.getCountOfBuy(-9999);
    }

    @Test
    public void getCountOfBuy_0인경우() {
        assertThat(Lotto.getCountOfBuy(0)).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Lotto_생성자인자가NULL인경우() {
        new Lotto(null);
    }
}