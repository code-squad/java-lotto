package lotto;


import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    private LottoStore lottoStore;

    @Before
    public void setUp() {
        Set<Integer> number = new HashSet<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        number.add(6);
        Lotto lotto = new Lotto(number);
        lottoStore = new LottoStore(Arrays.asList(lotto));
        lottoResult = new LottoResult("1,2,3,4,5,7", lottoStore);
    }

    @Test
    public void lottoResult_생성() {
        lottoResult = new LottoResult("1,2,3,4,5,6", lottoStore);
        assertThat(lottoResult.getWinners().size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lottoResult_생성_에러_테스트() {
        lottoResult = new LottoResult("", lottoStore);
        lottoResult = new LottoResult("1,2,3,4,5,6,7,7,5,4,3", lottoStore);
    }

    @Test
    public void 당첨_통계() {
        Map<Integer, Integer> result = lottoResult.getStatistics();
        assertThat(result.get(5)).isEqualTo(1);
    }


}