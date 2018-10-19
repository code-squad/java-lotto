package com.zingoworks.lotto.view;

import com.zingoworks.lotto.domain.Lottery;
import com.zingoworks.lotto.domain.LottoResult;

import java.util.List;

import static com.zingoworks.lotto.domain.Lotteries.PRICE_LOTTERY;
import static com.zingoworks.lotto.domain.LottoResult.*;

public class ResultView {
    private static final String NEWLINE = System.lineSeparator();

    public static void printLottoNumbers(List<Lottery> lotteries, int purchaseAmount) {
        System.out.println(purchaseAmount / PRICE_LOTTERY + "게임을 구매했습니다.");
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.getSortedLotteryNumbers());
        }
    }

    public static void printResults(LottoResult lottoResults, int purchaseAmount) {
        System.out.println("당첨통계" + NEWLINE +
                "---------" + NEWLINE +
                3 + "개 일치 (" + PRIZE_FORTH + "원) - " + lottoResults.getNumberOfWins(3) + "개" + NEWLINE +
                4 + "개 일치 (" + PRIZE_THIRD + "원) - " + lottoResults.getNumberOfWins(4) + "개" + NEWLINE +
                5 + "개 일치 (" + PRIZE_SECOND + "원) - " + lottoResults.getNumberOfWins(5) + "개" + NEWLINE +
                6 + "개 일치 (" + PRIZE_FIRST + "원) - " + lottoResults.getNumberOfWins(6) + "개" + NEWLINE +
                "총 수익률은 " + lottoResults.getEarningRate(purchaseAmount) + "%입니다.");
    }
}