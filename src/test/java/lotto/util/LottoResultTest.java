package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoResultTest {

    @Test
    public void 일치하는_개수가_3개인지() {
        Lotto jackpot = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("1, 2, 3, 10, 20, 30");

        assertEquals(3, jackpot.match(Arrays.asList(lotto), new LottoNumber(40)).matchCount(lotto));
    }

    @Test
    public void 일치하는_랭크_찾기() {
        Lotto jackpot = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto("1, 2, 3, 10, 20, 30");
        LottoRecorder lottoRecorder = jackpot.match(Arrays.asList(lotto), new LottoNumber(40));

        assertEquals(LottoRank.FIFTH , LottoRank.getLottoRank(lottoRecorder.matchCount(lotto), false));
    }

    @Test
    public void 지출() {
        List<Lotto> buy = LottoVendor.getInstance().buy("16000");
    }

    @Test
    public void 수익() {
        Lotto jackpot = new Lotto("1, 2, 3, 4, 5, 6");
        List<Lotto> lottoList = Arrays.asList(new Lotto("1, 2, 3, 7, 8, 9"));
        LottoRecorder lottoRecorder = new LottoRecorder(jackpot, lottoList, new LottoNumber(40));

        assertEquals(5000,lottoRecorder.getProfit());
    }

    @Test
    public void 수익률_계산() {
        Lotto jackpot = new Lotto("1, 2, 3, 4, 5, 6");
        List<Lotto> lotto10 = Arrays.asList(
                new Lotto("1, 2, 3, 7, 8, 9"),

                new Lotto("7, 8, 9, 10, 11, 12"),
                new Lotto("7, 8, 9, 10, 11, 12"),
                new Lotto("7, 8, 9, 10, 11, 12"),
                new Lotto("1, 2, 9, 10, 11, 12"),
                new Lotto("1, 8, 9, 10, 11, 12"),
                new Lotto("7, 8, 9, 10, 11, 12"),
                new Lotto("7, 8, 9, 10, 11, 12"),
                new Lotto("1, 2, 9, 10, 11, 12"),
                new Lotto("1, 8, 9, 10, 11, 12")
        );
        LottoRecorder lottoRecorder = jackpot.match(lotto10, new LottoNumber(13));

        assertEquals(50, lottoRecorder.getProfitRatio());
    }

    @Test
    public void 행운_번호_일치_및_랭크별() {
        Lotto jackpot = new Lotto("1, 2, 3, 4, 5, 6");
        List<Lotto> lotto10 = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),

                new Lotto("1, 2, 3, 4, 5, 7"),

                new Lotto("1, 2, 3, 4, 5, 8"),

                new Lotto("1, 2, 3, 4, 8, 9"),

                new Lotto("1, 2, 3, 10, 11, 12"),

                new Lotto("1, 2, 9, 10, 11, 12"),
                new Lotto("1, 9, 10, 11, 12, 13"),
                new Lotto("7, 8, 9, 10, 11, 12"),
                new Lotto("8, 9, 10, 11, 12, 13")
        );
        LottoRecorder lottoRecorder = jackpot.match(lotto10, new LottoNumber(7));
        assertEquals(1,lottoRecorder.getLottoCount(LottoRank.JACKPOT));
        assertEquals(1,lottoRecorder.getLottoCount(LottoRank.SECOND));
        assertEquals(1,lottoRecorder.getLottoCount(LottoRank.THIRD));
        assertEquals(1,lottoRecorder.getLottoCount(LottoRank.FOURTH));
        assertEquals(1,lottoRecorder.getLottoCount(LottoRank.FIFTH));
        assertEquals(4,lottoRecorder.getLottoCount(LottoRank.REST));

    }
}