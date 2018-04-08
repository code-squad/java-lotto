package LottoGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private Lottos lottos = new Lottos();
    private List<Result> results = new ArrayList<>();

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


    public List<Result> getMatchResult(WinningLotto winningLotto) {
        List<Match> matches = lottos.getMatches(winningLotto);
        for (Match match : matches) {
            calculateCount(match);
        }
        return results;
    }

    private void calculateCount(Match match) {
        for (Result result : results) {
            if (result.equalMatchValue(match)) {
                result.plusCount();
            }
        }
    }


    public List<Result> initResultList() {
        List<Result> results = new ArrayList<>();
        for (Match match : Match.values()) {
            results.add(new Result(match));
        }
        return results;
    }


    public int getYield(List<Result> results, int money) {
        int totalProfit = 0;
        for (int i = 0; i < results.size(); i++) {
            Result result = results.get(i);
            totalProfit += result.calculatePrice();
        }
        return (int) (((double) totalProfit / money) * 100);
    }
}
