package lottoGame.domain;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LottoTest {

    @Test
    public void 당첨번호확인테스트() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1),new LottoNo(2),new LottoNo(12),new LottoNo(4),new LottoNo(24),new LottoNo(6)));

        assertThat(lotto.isContainLottoNum(new LottoNo(1))).isTrue();
        assertThat(lotto.isContainLottoNum(new LottoNo(2))).isTrue();
        assertThat(lotto.isContainLottoNum(new LottoNo(10))).isFalse();
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void 로또번호추출했을때불변리스트인것확인() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(35),new LottoNo(40),new LottoNo(22),new LottoNo(15),new LottoNo(16),new LottoNo(17)));

        Set<LottoNo> lottoNums = lotto.getLottoNums();
        lottoNums.remove(1);
    }

    @Test
    public void 보너스번호소유여부확인() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1),new LottoNo(2),new LottoNo(3),new LottoNo(4),new LottoNo(5),new LottoNo(6)));

        assertTrue(lotto.isContainBonusNum(new LottoNo(5)));
        assertFalse(lotto.isContainBonusNum(new LottoNo(8)));
    }

    @Test(expected=IllegalArgumentException.class)
    public void 로또사이즈가6이아닐시예외확인() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNo(1),new LottoNo(4),new LottoNo(24),new LottoNo(6),new LottoNo(10)));
    }

    @Test
    public void 로또번호중복여부확인() {
        Set<LottoNo> set = new HashSet<>(Arrays.asList(new LottoNo(3),new LottoNo(3),new LottoNo(3),new LottoNo(3),new LottoNo(3),new LottoNo(3)));
        assertThat(set.size()).isEqualTo(1);
    }
}