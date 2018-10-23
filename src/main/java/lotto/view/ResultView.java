package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMap;
import lotto.domain.LottoConstant;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void statisticsLottoWinnings(LottoMap lottoMap, int price){
        Map map = lottoMap.getMap();

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + LottoConstant.PRIZE_WINNER_5TH + "원) - " + map.get(3) + "개");
        System.out.println("4개 일치 (" + LottoConstant.PRIZE_WINNER_4TH + "원) - " + map.get(4) + "개");
        System.out.println("5개 일치 (" + LottoConstant.PRIZE_WINNER_3TH + "원) - " + map.get(5) + "개");
        System.out.println("6개 일치 (" + LottoConstant.PRIZE_WINNER_1TH + "원) - " + map.get(6) + "개");

        double profit = getProfit(map);
        int rateOfReturn = calculateProfits(price, profit);

        System.out.println("총 수익률은 " + rateOfReturn + "% 입니다.");
    }
    public static int calculateProfits(double price, double profit) {
        double result = 0;
        if(profit != 0) {
            result = (profit / price) * 100;
        }
        return (int)result;
    }

    public static double getProfit(Map map) {
        return LottoConstant.PRIZE_WINNER_5TH * (int)map.get(3)
                + LottoConstant.PRIZE_WINNER_4TH * (int)map.get(4)
                + LottoConstant.PRIZE_WINNER_3TH * (int)map.get(5)
                + LottoConstant.PRIZE_WINNER_1TH * (int)map.get(6);
    }

    public static void printBuyLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}
