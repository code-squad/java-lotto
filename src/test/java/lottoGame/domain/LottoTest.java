package lottoGame.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LottoTest {

    @Test
    public void 당첨번호확인테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,12,4,24,6));

        assertThat(lotto.isContainLuckyNum(1)).isTrue();
        assertThat(lotto.isContainLuckyNum(2)).isTrue();
        assertThat(lotto.isContainLuckyNum(10)).isFalse();
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void 로또번호추출했을때불변리스트인것확인() {
        Lotto lotto = new Lotto(Arrays.asList(35,40,22,15,16,17));

        Set<Integer> lottoNums = lotto.getLottoNums();
        lottoNums.remove(1);
    }

    @Test
    public void 보너스번호소유여부확인() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertTrue(lotto.isContainBonusNum(5));
        assertFalse(lotto.isContainBonusNum(8));
    }
}