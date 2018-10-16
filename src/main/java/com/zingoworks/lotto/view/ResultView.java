package com.zingoworks.lotto.view;

import com.zingoworks.lotto.domain.FullGame;
import com.zingoworks.lotto.domain.LottoResults;

import static com.zingoworks.lotto.domain.Game.PRICE_OF_GAME;

public class ResultView {
    public static void printGames(FullGame fullGame, int purchaseAmount) {
        System.out.println(purchaseAmount / PRICE_OF_GAME + "게임을 구매했습니다.");
        for (int i = 0; i < fullGame.getFullGame().size(); i++) {
            System.out.println(fullGame.getFullGame().get(i).getGameNumbers());
        }
    }

    public static void printResults(LottoResults lottoResults, int purchaseAmount) {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원)- " + lottoResults.getResults().get(0) + "개");
        System.out.println("4개 일치 (50,000원)- " + lottoResults.getResults().get(1) + "개");
        System.out.println("5개 일치 (1,500,000원)- " + lottoResults.getResults().get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + lottoResults.getResults().get(3) + "개");
        System.out.println("총 수익률은 " + lottoResults.getEarningRate(purchaseAmount) + "%입니다.");
    }
}
