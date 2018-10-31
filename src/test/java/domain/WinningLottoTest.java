package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.IntegerToLottoNum.convertLottoNums;

public class WinningLottoTest {
    WinningLotto winningLotto;

    @Before
    public void setUp() throws Exception {
        winningLotto = WinningLotto.ofWinningLotto(convertLottoNums(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    public void 보너스_boolean_체크_가진다() {
        Lotto lotto = Lotto.ofLotto(convertLottoNums(Arrays.asList(11, 12, 13, 14, 15, 7)));
        assertThat(winningLotto.bonusCheck(lotto)).isEqualTo(true);
    }

    @Test
    public void 보너스_boolean_체크_안가진다() {
        Lotto lotto = Lotto.ofLotto(convertLottoNums(Arrays.asList(11, 12, 13, 14, 15, 17)));
        assertThat(winningLotto.bonusCheck(lotto)).isEqualTo(false);
    }
}