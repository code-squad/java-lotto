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
        List<LottoNo> number = new ArrayList<>(Arrays.asList(new LottoNo(6)
            ,new LottoNo(1)
            ,new LottoNo(2)
            ,new LottoNo(3)
            ,new LottoNo(4)
            ,new LottoNo(5)));
        Lotto lotto = new Lotto(number);
        lottoStore = new LottoStore(Arrays.asList(lotto));
        lottoResult = lottoStore.match(new WinningLotto("1,2,3,4,6,7",8));
    }

    @Test
    public void getResult() {
        Map<Rank, Integer> result = lottoResult.getResult();
        assertThat(result.get(Rank.FORTH)).isEqualTo(1);
    }

    @Test
    public void getPercentage() {
        lottoResult.getResult();
        long result = lottoResult.getPercentage();
        assertThat(result).isEqualTo(50L);
    }




}