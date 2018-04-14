package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {
    public void printHavingLotto(LottoGames lottoGames){

        System.out.println(lottoGames.getHavingCount() + "개를 구매하였습니다.");
        Lottos lottos = lottoGames.getLottos();

        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.toString());
        }
    }

    public void printWinResult(int havingCount, Map<Rank, Integer> rankCountMap) {
        int buyAmt = havingCount * LottoGames.LOTTO_PRICE_PER_TICKET;

        System.out.println("당첨통계");
        System.out.println("---------");

        int awardAmt = 0;

        List<Rank> ranks = Arrays.asList(Rank.values());

        for(Rank rank : ranks){
            if(rank == Rank.SECOND){
                System.out.println( Rank.SECOND.getCountOfMatch() + "개 일치, 보너스볼 일치 (" + Rank.SECOND.getWinningMoney() + "원) - " + rankCountMap.get(rank) + "개");
                continue;
            }

            System.out.println( rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) - " + rankCountMap.get(rank) + "개");

            if(rankCountMap.get(rank) > 0)
                awardAmt += rank.getWinningMoney();
        }

        /*
        int awardAmt = 0;
        for(Rank rank : rankCountMap.keySet()){
            if(rank.getCountOfMatch() == 5){
                if(rank.getWinningMoney() == Rank.SECOND.getWinningMoney()){
                    System.out.println( Rank.SECOND.getCountOfMatch() + "개 일치, 보너스볼 일치 (" + Rank.SECOND.getWinningMoney() + "원) - " + rankCountMap.get(rank) + "개");
                    continue;
                }
                System.out.println( Rank.THIRD.getCountOfMatch() + "개 일치 (" + Rank.THIRD.getWinningMoney() + "원) - " + rankCountMap.get(rank) + "개");
                continue;
            }
            System.out.println( rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) - " + rankCountMap.get(rank) + "개");
            awardAmt += rank.getWinningMoney();
        }
        */


        System.out.println();
        System.out.println("총 수익률은 " + (awardAmt * 100 / buyAmt) + "%입니다.");
    }
}
