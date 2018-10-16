package com.zingoworks.lotto.view;

import com.zingoworks.lotto.domain.FullLotto;
import com.zingoworks.lotto.domain.LottoResults;

import static com.zingoworks.lotto.domain.Lotto.NEWLINE;
import static com.zingoworks.lotto.domain.Lotto.PRICE_OF_GAME;
import static com.zingoworks.lotto.domain.LottoResults.*;


public class ResultView {
    public static void printGames(FullLotto fullLotto, int purchaseAmount) {
        System.out.println(purchaseAmount / PRICE_OF_GAME + "게임을 구매했습니다.");
        for (int i = 0; i < fullLotto.getFullLotto().size(); i++) {
            System.out.println(fullLotto.getFullLotto().get(i).getLottoNumbers());
        }
    }

    public static void printResults(LottoResults lottoResults, int purchaseAmount) {
        System.out.println("당첨통계" + NEWLINE +
                "---------" + NEWLINE +
                SCORE_FORTH + "개 일치 (" + PRIZE_FORTH + "원)- " + lottoResults.getRanks().get("FORTH") + "개" + NEWLINE +
                SCORE_THIRD + "개 일치 (" + PRIZE_THIRD + "원)- " + lottoResults.getRanks().get("THIRD") + "개" + NEWLINE +
                SCORE_SECOND + "개 일치 (" + PRIZE_SECOND + "원)- " + lottoResults.getRanks().get("SECOND") + "개" + NEWLINE +
                SCORE_FIRST + "개 일치 (" + PRIZE_FIRST + "원)- " + lottoResults.getRanks().get("FIRST") + "개" + NEWLINE +
                "총 수익률은 " + lottoResults.getEarningRate(purchaseAmount) + "%입니다.");
    }
}
