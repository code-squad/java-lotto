package lotto.domain;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    private LottoStore lottoStore;

    @Before
    public void setUp() {
        List<Integer> number = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(number);
        lottoStore = new LottoStore(Arrays.asList(lotto));
        lottoResult = lottoStore.match("1,2,3,4,6,7");
    }


    @Test(expected = IllegalArgumentException.class)
    public void lottoResult_생성_에러_테스트() {
        lottoResult = lottoStore.match("");
        lottoResult = lottoStore.match("1,2,3,4,5,6,7,8,9");
    }

    @Test
    public void getStatistics() {
        Map<PriceType, Integer> result = lottoStore.getStatistics();
        assertThat(result.get(PriceType.SECOND)).isEqualTo(1);
    }

    @Test
    public void getPercentage() {
        long result = lottoResult.getPercentage();
        assertThat(result).isEqualTo(1500L);
    }




}