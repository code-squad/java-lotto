package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @Test
    public void winnigLottoTest() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLotto.getWinningLottos()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.getBonusNum()).isEqualTo(7);
    }
}
