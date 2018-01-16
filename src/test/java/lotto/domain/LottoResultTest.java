package lotto.domain;


import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    private LottoStore lottoStore;

    @Before
    public void setUp() {
        List<Integer> number = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(number);
        lottoStore = new LottoStore(Arrays.asList(lotto));
        lottoResult = lottoStore.match("1,2,3,4,5,6,7");
    }

    @Test
    public void lottoResult_생성() {
        lottoResult = lottoStore.match("1,2,3,4,5,6,7");
        assertThat(lottoResult.getWinners().size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lottoResult_생성_에러_테스트() {
        lottoResult = new LottoResult("", lottoStore.getLottos());
        lottoResult = new LottoResult("1,2,3,4,5,6,7,7,5,4,3", lottoStore.getLottos());
    }

    @Test
    public void getStatistics() {
        Map<PriceType, Integer> result = lottoResult.getStatistics();
        assertThat(result.get(5)).isEqualTo(1);
    }

    @Test
    public void getPercentage() {
        long result = lottoResult.getPercentage();
        assertThat(result).isEqualTo(1500L);
    }




}