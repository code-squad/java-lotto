package com.zingoworks.lotto.view;

import com.zingoworks.lotto.domain.Lotto;
import com.zingoworks.lotto.domain.LottoResult;
import com.zingoworks.lotto.domain.Prize;

import java.util.List;

import static com.zingoworks.lotto.domain.Lottos.PRICE_LOTTERY;

public class ResultView {
    private static final String NEWLINE = System.lineSeparator();

    public static void printLottoNumbers(List<Lotto> lottos, int purchaseAmount) {
        System.out.println(purchaseAmount / PRICE_LOTTERY + "게임을 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.print(NEWLINE);
    }

    public static void printResults(LottoResult lottoResults, int purchaseAmount) {
        System.out.println(NEWLINE + "당첨통계" + NEWLINE + "---------");
        for (Prize prize : Prize.values()) {
            System.out.println(prize.getScore().getCountOfHit()
                    + "개 일치" + getBonusHitPhrase(prize.getScore().isBonusHit())
                    + "(" +  prize.getWinningMoney() + "원) - "
                    + lottoResults.getCountOfWins(prize.getScore()) + "개");
        }
        System.out.println("총 수익률은 " + lottoResults.getNetEarningRate(purchaseAmount) + "%입니다.");
    }

    private static String getBonusHitPhrase(boolean isBonusHit) {
        if (isBonusHit) {
            return ", 보너스 볼 일치";
        }

        return " ";
    }
}