package lotto.domain;

import lotto.util.LottoUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoAnalyzerTest {

    /**
     * 3개 일치 (5000원)- 1개
     4개 일치 (50000원)- 0개
     5개 일치 (1500000원)- 0개
     6개 일치 (2000000000원)- 0개
     총 수익률은 30%입니다.
     */

    @Test
    public void 일치하는_개수가_3개인지() {
        Lotto lotto = LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 10, 20, 30));
        assertEquals(3,new LottoAnalyzer().matchCount(lotto));
    }

    @Test
    public void 일치하는_랭크_찾기() {
        Lotto lotto = LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 10, 20, 30));
        assertEquals(LottoRank.FOURTH , LottoRank.getLottoRank(new LottoAnalyzer().matchCount(lotto)));
    }

    @Test
    public void 렝크별_테스트_6_0개__5_2개__4_3개__3_4개() {
        List<Lotto> lottoList = Arrays.asList(

                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 7)),

                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 4, 7, 8)),

                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),

                LottoUtil.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoUtil.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoUtil.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoUtil.parseLotto(Arrays.asList(1, 2, 9, 10, 11, 12)),
                LottoUtil.parseLotto(Arrays.asList(1, 8, 9, 10, 11, 12))
        );
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer().analyzeLottery(lottoList);
        assertEquals(0, lottoAnalyzer.getLottoCount(LottoRank.JACKPOT));
        assertEquals(2, lottoAnalyzer.getLottoCount(LottoRank.SECOND));
        assertEquals(3, lottoAnalyzer.getLottoCount(LottoRank.THIRD));
        assertEquals(4, lottoAnalyzer.getLottoCount(LottoRank.FOURTH));
        assertEquals(5, lottoAnalyzer.getLottoCount(LottoRank.REST));
    }

    @Test
    public void 지출() {
        List<Lotto> buy = LottoVendor.getInstance().buy("16000");
    }

    @Test
    public void 수익() {
        List<Lotto> lottoList = Arrays.asList(
                LottoUtil.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9))
        );
        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer().analyzeLottery(lottoList);
        assertEquals(5000,lottoAnalyzer.getProfit());
    }

    @Test
    public void 수익률_계산() {

    }
}
