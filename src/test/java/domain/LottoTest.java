package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 숫자_맞추기_돈을_못받을_때() {
        WinningLotto lotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        UserLotto testLotto = new UserLotto(Arrays.asList(10, 12, 13, 7, 8, 9));
        lotto.checkTheWinningNumbers(testLotto);
    }

    @Test
    public void 숫자_맞추기_보너스볼_못맞췄을_때() {
        WinningLotto lotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        UserLotto testLotto = new UserLotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(lotto.checkTheWinningNumbers(testLotto)).isEqualTo(Rank.FIFTH);
        testLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkTheWinningNumbers(testLotto)).isEqualTo(Rank.FIRST);
    }

    @Test
    public void 숫자_맞추기_보너스볼_맞췄을_때() {
        WinningLotto lotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        UserLotto testLotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        assertThat(lotto.checkTheWinningNumbers(testLotto)).isEqualTo(Rank.SECOND);
        testLotto = new UserLotto(Arrays.asList(1, 2, 3, 45, 8, 9));
        assertThat(lotto.checkTheWinningNumbers(testLotto)).isEqualTo(Rank.FIFTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자가_여섯개가_아닐_때() {
        UserLotto lotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto = new UserLotto(Arrays.asList(1, 2, 3, 4, 5));
    }
}
