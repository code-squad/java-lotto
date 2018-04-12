package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {
    public void printHavingLotto(LottoGames lotto){
        List<Lotto> havingLottos = lotto.getHavingLottos();
        System.out.println(havingLottos.size() + "개를 구매하였습니다.");

        for(int i=0; i<havingLottos.size(); i++){
            System.out.println(havingLottos.get(i).toString());
        }
    }

    public void printWinResult(int havingCount, Map<Integer,Integer> winResults) {
        int buyAmt = havingCount * LottoGames.LOTTO_PRICE_PER_TICKET;

        System.out.println("당첨통계");
        System.out.println("---------");

        Map<Integer, Integer> resultTexts = new HashMap<>();
        resultTexts.put(3, 5000);
        resultTexts.put(4, 50000);
        resultTexts.put(5, 1500000);
        resultTexts.put(6, 2000000000);

        int awardAmt = 0;

        for(int i=3; i<7; i++){
            int matchCnt = winResults.get(i) == null ? 0 : winResults.get(i);
            System.out.println(i + "개 일치 (" + resultTexts.get(i) + "원) - " + matchCnt + "개");

            awardAmt += matchCnt * resultTexts.get(i);
        }

        System.out.println("총 수익률은 " + (awardAmt * 100 / buyAmt) + "%입니다.");
    }
}
