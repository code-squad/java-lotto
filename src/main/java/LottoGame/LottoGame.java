package LottoGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private Lottos lottos = new Lottos();
    private List<Result> results;

    public LottoGame(int money) {
        int lottoTicketNumber = getLottoTicketNumber(money);
        for (int i = 0; i < lottoTicketNumber; i++) {
            lottos.add(createLotto());
        }
        results = initResultList();
    }

    private static Lotto createLotto() {
        return new Lotto();
    }

    private int getLottoTicketNumber(int money) {
        return (money / LOTTO_PRICE);
    }

    public Lottos getLottos() {
        return lottos;
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
        for(Result result : results) {
            totalReward += result.calculateReward();
        }
        return (int) (((double) totalReward / money) * 100);
    }
}
