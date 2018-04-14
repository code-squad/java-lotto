package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Money.PRICE_PER_LOTTO;


/**
 * @author sangsik.kim
 */
public class LottoTicket {
    private List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getQuantity() {
        return this.lottos.size();
    }

    private int calculateBuyAmount() {
        return lottos.size() * PRICE_PER_LOTTO;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult createResult(WinningLotto winningLotto) {
        Map<Rank, Integer> result = new HashMap();
        for (Rank rank : Rank.values()) {
            result.put(rank, countOfWinningLotto(rank, winningLotto));
        }
        return new LottoResult(result, calculateBuyAmount());
    }

    public int countOfWinningLotto(Rank rank, WinningLotto winningLotto) {
        return Math.toIntExact(this.lottos
                .stream()
                .filter(lotto -> lotto.match(winningLotto).equals(rank))
                .count());
    }
}
