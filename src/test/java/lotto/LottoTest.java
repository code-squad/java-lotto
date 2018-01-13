package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void getCount() {
        assertThat(Lotto.getCount(12000)).isEqualTo(12);
        assertThat(Lotto.getCount(11500)).isEqualTo(11);
        assertThat(Lotto.getCount(11000)).isEqualTo(11);
        assertThat(Lotto.getCount(9999)).isEqualTo(9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getCount_음수인경우() {
        Lotto.getCount(-9999);
    }

    @Test
    public void getCount_0인경우() {
        assertThat(Lotto.getCount(0)).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Lotto_생성자인자가NULL인경우() {
        new Lotto(null);
    }
}