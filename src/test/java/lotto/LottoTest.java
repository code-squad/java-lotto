package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.Arrays;

public class LottoTest {
    @Test
    public void new_lotto_6개의_숫자_리스트_보유() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.numbers).hasSize(6).contains(1, 2, 3, 4, 5, 6);
    }
}
