package lotto.domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LottoResultTest {
    @Test
    public void showResultMessage() throws Exception {
        Map<LottoPrize, Integer> LottoPrizeResult = new HashMap<>();
        LottoPrizeResult.put(LottoPrize.THREE, 1);
        LottoResult lottoResult = new LottoResult(LottoPrizeResult,1000);
        assertEquals("3개 일치 (5000원)- 1개", lottoResult.showResultMessage(LottoPrize.THREE));
    }

    @Test
    public void showResultMessageWithBonus() throws Exception {
        Map<LottoPrize, Integer> LottoPrizeResult = new HashMap<>();
        LottoPrizeResult.put(LottoPrize.FIVE_BONUS, 0);
        LottoResult lottoResult = new LottoResult(LottoPrizeResult,1000);
        assertEquals("5개 일치, 보너스 볼 일치(30000000원)- 0개", lottoResult.showResultMessage(LottoPrize.FIVE_BONUS));
    }

}