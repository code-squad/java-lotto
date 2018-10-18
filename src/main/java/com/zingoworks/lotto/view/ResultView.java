package com.zingoworks.lotto.view;

import com.zingoworks.lotto.domain.Lottery;
import com.zingoworks.lotto.domain.LottoResult;

import java.util.List;

import static com.zingoworks.lotto.domain.Lotteries.PRICE_LOTTERY;

public class ResultView {
    static final String NEWLINE = System.lineSeparator();

    public static void printGames(List<Lottery> lotteries, int purchaseAmount) {
        System.out.println(purchaseAmount / PRICE_LOTTERY + "게임을 구매했습니다.");
        for (int i = 0; i < lotteries.size(); i++) {
            System.out.println(lotteries.get(i).getSortedLotteryNumbers());
        }
    }

    public static void printResults(LottoResult lottoResults, int purchaseAmount) {
        System.out.println("당첨통계" + NEWLINE +
                "---------" + NEWLINE +
                3 + "개 일치 (" + 5000 + "원) - " + lottoResults.getWinners().get(3) + "개" + NEWLINE +
                4 + "개 일치 (" + 50000 + "원) - " + lottoResults.getWinners().get(4) + "개" + NEWLINE +
                5 + "개 일치 (" + 1500000 + "원) - " + lottoResults.getWinners().get(5) + "개" + NEWLINE +
                6 + "개 일치 (" + 2000000000 + "원) - " + lottoResults.getWinners().get(6) + "개" + NEWLINE +
                "총 수익률은 " + lottoResults.getEarningRate(purchaseAmount) + "%입니다.");
        System.out.println("총 수익금은 " + (lottoResults.getEarning() - purchaseAmount) + "원 입니다.");
    }
}