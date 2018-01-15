package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoResultTest {

    /**
     * 3개 일치 (5000원)- 1개
     4개 일치 (50000원)- 0개
     5개 일치 (1500000원)- 0개
     6개 일치 (2000000000원)- 0개
     총 수익률은 30%입니다.
     */

    @Test
    public void 일치하는_개수가_3개인지() {
        Lotto jackpot = LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = LottoParser.parseLotto(Arrays.asList(1, 2, 3, 10, 20, 30));

        assertEquals(3, new LottoRecorder(jackpot, Arrays.asList(lotto)).matchCount(lotto));
    }

    @Test
    public void 일치하는_랭크_찾기() {
        Lotto jackpot = LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = LottoParser.parseLotto(Arrays.asList(1, 2, 3, 10, 20, 30));
        LottoRecorder lottoRecorder = new LottoRecorder(jackpot, Arrays.asList(lotto));

        assertEquals(LottoRank.FOURTH , LottoRank.getLottoRank(lottoRecorder.matchCount(lotto)));
    }

    @Test
    public void 렝크별_테스트_6_0개__5_2개__4_3개__3_4개() {
        List<Lotto> lottoList = Arrays.asList(

                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 7)),

                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 7, 8)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 7, 8)),

                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),

                LottoParser.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(1, 8, 9, 10, 11, 12))
        );
        LottoRecorder lottoRecorder = new LottoRecorder(LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 6)), lottoList);

        assertEquals(0, lottoRecorder.getLottoCount(LottoRank.JACKPOT));
        assertEquals(2, lottoRecorder.getLottoCount(LottoRank.SECOND));
        assertEquals(3, lottoRecorder.getLottoCount(LottoRank.THIRD));
        assertEquals(4, lottoRecorder.getLottoCount(LottoRank.FOURTH));
        assertEquals(5, lottoRecorder.getLottoCount(LottoRank.REST));
    }

    @Test
    public void 지출() {
        List<Lotto> buy = LottoVendor.getInstance().buy("16000");
    }

    @Test
    public void 수익() {
        Lotto jackpot = LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = Arrays.asList(LottoParser.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoRecorder lottoRecorder = new LottoRecorder(jackpot, lottoList);

        assertEquals(5000,lottoRecorder.getProfit());
    }

    @Test
    public void 수익률_계산() {
        Lotto jackpot = LottoParser.parseLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lotto10 = Arrays.asList(
                LottoParser.parseLotto(Arrays.asList(1, 2, 3, 7, 8, 9)),

                LottoParser.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(1, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(1, 2, 9, 10, 11, 12)),
                LottoParser.parseLotto(Arrays.asList(1, 8, 9, 10, 11, 12))
        );
        LottoRecorder lottoRecorder = new LottoRecorder(jackpot, lotto10);

        assertEquals(50, lottoRecorder.getProfitRatio());
    }
}
