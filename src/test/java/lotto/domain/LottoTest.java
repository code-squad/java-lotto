package lotto.domain;

import lotto.domain.Lotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void of_문자열_숫자() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void of_중복_값() {
        Lotto.of("1, 2, 3, 4, 5, 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void of_문자열_isNull() {
        Lotto.of("");
    }
}
