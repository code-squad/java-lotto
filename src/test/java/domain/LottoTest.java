package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 숫자_맞추기() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto testLotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));
        assertThat(lotto.checkTheWinningNumbers(testLotto)).isEqualTo(0);
        testLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(lotto.checkTheWinningNumbers(testLotto)).isEqualTo(3);
        testLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkTheWinningNumbers(testLotto)).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자가_여섯개가_아닐_때() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5));
    }
}
