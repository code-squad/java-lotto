package com.zingoworks.lotto.view;

import com.zingoworks.lotto.model.LottoResult;
import com.zingoworks.lotto.model.Money;
import com.zingoworks.lotto.model.Prize;
import com.zingoworks.lotto.model.lotto.Lotto;
import com.zingoworks.lotto.model.lotto.lottoPack.LottoPack;

public class ResultView {
    private static final String NEWLINE = System.lineSeparator();

    public static void printLottoNumbers(LottoPack lottoPack) {
        System.out.println(NEWLINE + lottoPack.getPurchasePhrase());

        for (Lotto lotto : lottoPack.getLottoPack()) {
            System.out.println(lotto);
        }
        System.out.print(NEWLINE);
    }

    public static void printResults(LottoResult lottoResult, Money money) {
        System.out.println(NEWLINE + "당첨통계" + NEWLINE + "---------");
        for (Prize prize : Prize.values()) {
            System.out.println(prize.getCountOfHit()
                    + "개 일치" + getBonusPhrase(prize.isBonusHit())
                    + "(" +  prize.getWinningMoney() + "원) - "
                    + lottoResult.getTotalWin(prize) + "개");
        }
        System.out.println("총 수익률은 " + money.getNetEarningRate(lottoResult.getTotalEarning()) + "%입니다.");
    }

    private static String getBonusPhrase(boolean isBonusHit) {
        if (isBonusHit) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }
}
