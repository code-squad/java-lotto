package lotto.view;

import lotto.domain.Lotto;
import lotto.service.LottoGames;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static lotto.service.LottoGames.LOTTO_PRICE_PER_TICKET;

public class ResultView {
    public static void printHavingLotto(LottoGames lottoGames){

        System.out.println(lottoGames.getHavingCount() + "개를 구매하였습니다.");
        Lottos lottos = lottoGames.getLottos();

        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.toString());
        }
    }

    public static void printWinResult(LottoGames lottoGames) {

        long buyAmt = lottoGames.getHavingCount() * LOTTO_PRICE_PER_TICKET;
        Map<Rank, Integer> rankCountMap = lottoGames.getRankMap();
        int awardAmt = lottoGames.getAwardAmt();

        System.out.println("당첨통계");
        System.out.println("---------");

        List<Rank> ranks = Arrays.asList(Rank.values());

        List<String> resultTexts = lottoGames.getResultViewString();

        for(String resultText : resultTexts){
            System.out.println(resultText);
        }

        System.out.println();
        System.out.println("총 수익률은 " + ((long)awardAmt * 100l / (long)buyAmt) + "%입니다.");
    }
}
