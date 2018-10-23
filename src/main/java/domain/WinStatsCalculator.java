package domain;

import dto.WinStatsDto;
import vo.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinStatsCalculator {
    private static Map<Rank, Integer> winStats;
    static {
        winStats = new HashMap<>();
        winStats.put(Rank.FIRST, 0);
        winStats.put(Rank.SECOND, 0);
        winStats.put(Rank.THIRD, 0);
        winStats.put(Rank.FOURTH, 0);
        winStats.put(Rank.FIFTH, 0);
    }

    private List<Lotto> theLottoBundle;
    private WinningLotto theWinningLotto;

    public WinStatsCalculator(List<Lotto> theLottoBundle, WinningLotto theWinningLotto) {
        this.theLottoBundle = theLottoBundle;
        this.theWinningLotto = theWinningLotto;
        this.makeWinStats();
    }

    private void makeWinStats(){
        for (Lotto lotto : this.theLottoBundle) {
            Rank rank = Rank.valueOf(theWinningLotto.calculateHitCount(lotto), theWinningLotto.isHitBonusBall(lotto));
            countRank(rank);
        }
    }

    private static void countRank(Rank rank){
        if(rank != null){
            winStats.replace(rank, winStats.get(rank) + 1);
        }
    }

    // default modifier for test.
    double calculateEarningRate(){
        int earningMoney = 0;
        for (Rank rank : Rank.values()) {
            earningMoney += rank.calculateTotalReward(winStats.get(rank));
        };
        return earningMoney / (this.theLottoBundle.size() * 1000.0) * 100.0;
    }

    public WinStatsDto toDto(){
        return new WinStatsDto(winStats, this.calculateEarningRate());
    }

}
