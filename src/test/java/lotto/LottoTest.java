package lotto;

import lotto.domain.Lotto;
import lotto.domain.WinningTier;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sangsik.kim
 */
public class LottoTest {
    private Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));


    @Test
    public void 당첨확인_1등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.tier(this.winningLotto)).isEqualTo(WinningTier.FIRST);
    }

    @Test
    public void 당첨확인_2등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));

        assertThat(lotto.tier(this.winningLotto)).isEqualTo(WinningTier.SECOND);
    }

    @Test
    public void 당첨확인_3등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 20));

        assertThat(lotto.tier(this.winningLotto)).isEqualTo(WinningTier.THIRD);
    }

    @Test
    public void 당첨확인_4등() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 20, 30));

        assertThat(lotto.tier(this.winningLotto)).isEqualTo(WinningTier.FOURTH);
    }
}
