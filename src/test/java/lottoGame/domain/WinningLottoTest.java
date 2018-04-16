package lottoGame.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class WinningLottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 보너스번호및로또번호중복확인여부() {
        new WinningLotto(new HashSet(Arrays.asList(new LottoNo(3),new LottoNo(4),new LottoNo(11),new LottoNo(5),new LottoNo(24),new LottoNo(43))),new LottoNo(43));
    }

    @Test
    public void 당첨번호와로또번호일치여부확인() {

        WinningLotto winningLotto = new WinningLotto(new HashSet(Arrays.asList(new LottoNo(3),new LottoNo(4),new LottoNo(11),new LottoNo(5),new LottoNo(24),new LottoNo(43))),new LottoNo(9));
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(3),new LottoNo(4),new LottoNo(11),new LottoNo(5),new LottoNo(24),new LottoNo(43)));
        Lotto lotto2 = new Lotto(Arrays.asList(new LottoNo(3),new LottoNo(4),new LottoNo(11),new LottoNo(41),new LottoNo(42),new LottoNo(43)));

        assertThat(winningLotto.getSameLuckNumCnt(lotto)).isEqualTo(6);
        assertThat(winningLotto.getSameLuckNumCnt(lotto2)).isEqualTo(4);
    }

    @Test
    public void 로또보너스번호일치여부() {
        WinningLotto winningLotto = new WinningLotto(new HashSet(Arrays.asList(new LottoNo(3),new LottoNo(4),new LottoNo(11),new LottoNo(5),new LottoNo(24),new LottoNo(43))),new LottoNo(9));
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(3),new LottoNo(4),new LottoNo(11),new LottoNo(9),new LottoNo(24),new LottoNo(43)));

        assertTrue(winningLotto.isContainBonusNum(lotto));
    }

}