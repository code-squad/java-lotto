package lottoGame.domain;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LottoTest {

    @Test
    public void 당첨번호확인테스트() {
        Lotto lotto = new Lotto(1,2,12,4,24,6);

        assertThat(lotto.isContainLottoNum(new LottoNo(1))).isTrue();
        assertThat(lotto.isContainLottoNum(new LottoNo(2))).isTrue();
        assertThat(lotto.isContainLottoNum(new LottoNo(10))).isFalse();
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void 로또번호추출했을때불변리스트인것확인() {
        Lotto lotto = new Lotto(35,40,22,15,16,17);

        Set<LottoNo> lottoNums = lotto.getLottoNums();
        lottoNums.remove(1);
    }

    @Test
    public void 보너스번호소유여부확인() {
        Lotto lotto = new Lotto(1,2,3,4,5,6);

        assertTrue(lotto.isContainBonusNum(new LottoNo(5)));
        assertFalse(lotto.isContainBonusNum(new LottoNo(8)));
    }

    @Test(expected=IllegalArgumentException.class)
    public void 로또사이즈가6이아닐시예외확인() {
        Lotto lotto = new Lotto(1,4,24,6,10);
    }

    @Test
    public void 로또번호중복여부확인() {
        Set<LottoNo> set = new HashSet<>(Arrays.asList(new LottoNo(3),new LottoNo(3),new LottoNo(4),new LottoNo(4),new LottoNo(3),new LottoNo(3)));
        assertThat(set.size()).isEqualTo(2);
    }

    @Test(expected=IllegalArgumentException.class)
    public void 로또번호1이상45이하번호아닐시예외확인() {
        Lotto lotto = new Lotto(1,4,24,6,46);
    }
}