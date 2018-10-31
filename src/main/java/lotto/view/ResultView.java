package lotto.view;

import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;

import java.util.Map;

public class ResultView {

    public static void statisticsLottoWinnings(ResultDto result){
        Map map = result.getResults();
        int rateOfReturn = result.getRateOfReturn();

        System.out.println("당첨 통계 \n ---------- ");

        for (Rank rank : Rank.values()) {
            String explain = "";
            if(Rank.SECOND == rank) {
                explain = ", 보너스 볼 일치";
            }
            System.out.println(rank.getCountOfMatch() + "개 일치"
                    + explain + "(" + rank.getWinningMoney() + "원)- "
                    + map.get(rank) + "개");
        }
        System.out.println("총 수익률은 " + rateOfReturn + "% 입니다.");
    }

    public static void printBuyLotto(LottoDto lottos) {
        System.out.println("수동으로 " + (lottos.getLottos().size() - lottos.getNumberOfLottoToBuyManually()) + "장, "
                + "자동으로 " + lottos.getNumberOfLottoToBuyManually()
                + "개를 구매했습니다.");
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }
}
