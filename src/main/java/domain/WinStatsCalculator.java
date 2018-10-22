package domain;

import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;
import dto.ResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinStatsCalculator {
    private static Map<Rank, Integer> winStats;
    static {
        winStats = new HashMap<>();
        winStats.put(Rank.valueOf("FIRST"), 0);
        winStats.put(Rank.valueOf("SECOND"), 0);
        winStats.put(Rank.valueOf("THIRD"), 0);
        winStats.put(Rank.valueOf("FOURTH"), 0);
        winStats.put(Rank.valueOf("FIFTH"), 0);
    }

    public void makeWinStats(List<Lotto> theLottoBundle, WinningLotto theWinningLotto){
        for (Lotto lotto : theLottoBundle) {
            Rank rank = Rank.valueOf(theWinningLotto.calculateHitCount(lotto), theWinningLotto.isHitBonusBall(lotto));
            this.countRankLotto(rank);
        }
    }

    public void countRankLotto(Rank rank){
        if(rank != null){
            winStats.replace(rank, winStats.get(rank) + 1);
        }
    }

    public double calculateEarningRate(){
        winStats.get()
    }

    public ResultDto toDto(){

    }
}
