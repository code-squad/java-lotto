package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.Arrays;

public class LottoTest {
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void new_lotto_6개의_숫자_리스트_보유() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).hasSize(6).contains(1, 2, 3, 4, 5, 6);
    }

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void 당첨갯수_3개() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13));

        assertThat(lotto.matcherNumber(winningLotto)).isEqualTo(3);
    }

    @SuppressWarnings("NonAsciiCharacters")
    @Test
    public void 당첨갯수_6개() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.matcherNumber(winningLotto)).isEqualTo(6);
    }
}
