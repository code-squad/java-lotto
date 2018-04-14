package lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinLottoTest {
    @Test(expected = IllegalArgumentException.class)
    public void 보너스번호_중복() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        WinLotto winLotto = new WinLotto(lotto, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스번호_음수() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        WinLotto winLotto = new WinLotto(lotto, -1);
    }

    @Test
    public void 보너스번호_정상세팅() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        WinLotto winLotto = new WinLotto(lotto, 10);
        assertThat(winLotto.getBonusNumber()).isEqualTo(10);
    }
}
