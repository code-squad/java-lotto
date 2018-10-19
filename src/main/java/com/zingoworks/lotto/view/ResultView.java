package com.zingoworks.lotto.view;

import com.zingoworks.lotto.domain.Lottery;
import com.zingoworks.lotto.domain.LottoResult;
import com.zingoworks.lotto.domain.Prize;

import java.util.List;

import static com.zingoworks.lotto.domain.Lotteries.PRICE_LOTTERY;

public class ResultView {
    private static final String NEWLINE = System.lineSeparator();

    public static void printLottoNumbers(List<Lottery> lotteries, int purchaseAmount) {
        System.out.println(purchaseAmount / PRICE_LOTTERY + "게임을 구매했습니다.");
        for (Lottery lottery : lotteries) {
            System.out.println(lottery.getSortedLotteryNumbers());
        }
    }

    public static void printResults(LottoResult lottoResults, int purchaseAmount) {
        System.out.println("당첨통계" + NEWLINE + "---------");
        for (Prize prize : Prize.values()) {
            System.out.println(prize.getCountOfHit() + "개 일치 (" + prize.getWinningMoney() + "원) - " + lottoResults.getNumberOfWins(prize.getCountOfHit()) + "개");
        }
//        System.out.println("총 수익률은 " + lottoResults.getEarningRate(purchaseAmount) + "%입니다.");
    }
}