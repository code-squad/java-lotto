package lottoGame.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @Test
    public void 당첨번호확인테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,12,4,24,6));

        assertThat(lotto.isContainLuckyNum(1)).isTrue();
        assertThat(lotto.isContainLuckyNum(2)).isTrue();
        assertThat(lotto.isContainLuckyNum(10)).isFalse();
    }

    @Test
    public void 당첨번호카운트세기테스트() {

        Lotto lotto = new Lotto(Arrays.asList(1,2,10,4,24,6));

        assertThat(lotto.getSameLuckNumCnt(Arrays.asList(1,4,5,24,6,11))).isEqualTo(4);
        assertThat(lotto.getSameLuckNumCnt(Arrays.asList(1,2,30,40,50,6))).isEqualTo(3);
    }

    @Test(expected = java.lang.UnsupportedOperationException.class)
    public void 로또번호추출했을때불변리스트인것확인() {
        Lotto lotto = new Lotto(Arrays.asList(35,40,22,15,16,17));
        List<Integer> list = lotto.getLottoNums();
        list.remove(1);
    }
}