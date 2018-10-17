package lottogame.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {
    @Test
    public void check() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.match(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)));
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void checkBoom() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.match(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)));
        assertThat(result).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inspectDuplication() {
        new Lotto(Arrays.asList(1, 1, 3, 4, 5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void inspectCorrectNumberAmount() {
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }
}
