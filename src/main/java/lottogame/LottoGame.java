package lottogame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class LottoGame {

    private Lottos lottos = new Lottos();
    private List<Result> results;

    public LottoGame() {
        results = initResultList();
    }

    public void createAutoLotto(int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(LottoFactory.createAutoLotto());
        }
    }

    public void createManualLotto(String text) {
        lottos.add(LottoFactory.createManualLotto(text));
    }

    public List<Result> getRankResults(WinningLotto winningLotto) {
        List<Rank> ranks = lottos.getRanks(winningLotto);
        for (Rank rank : ranks) {
            calculateCountPerRank(rank);
        }
        return results;
    }

    public List<Result> initResultList() {
        List<Result> results = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            results.add(new Result(rank));
        }
        return results;
    }

    private void calculateCountPerRank(Rank rank) {
        for (Result result : results) {
            if (result.equal(rank)) {
                result.plusCount();
            }
        }
    }

    public int getYield(List<Result> results, int money) {
        int totalReward = 0;
        for (Result result : results) {
            totalReward += result.calculateReward();
        }
        return (int) (((double) totalReward / money) * 100);
    }

    public Lottos getLottos() {
        return lottos;
    }
}