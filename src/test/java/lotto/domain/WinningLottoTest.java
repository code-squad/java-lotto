package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    Lotto lotto;

    @Before
    public void setup() {
        lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨번호_안에_보너스번호_존재() {
        WinningLotto winningLotto = new WinningLotto(lotto, 6);
    }

    @Test
    public void 당첨번호_번호_포함() {
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        boolean result = winningLotto.contains(1);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 당첨번호_번호_미포함() {
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        boolean result = winningLotto.contains(45);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 로또_안에_보너스번호_포함() {
        WinningLotto winningLotto = new WinningLotto(lotto, 7);
        List<Integer> testLotto = Arrays.asList(1,2,3,4,5,7);
        boolean result = winningLotto.matchBonusNumber(testLotto);
        assertThat(result).isEqualTo(true);
    }
}
