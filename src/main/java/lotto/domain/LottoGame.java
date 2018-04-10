package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoProvider.PRICE_PER_LOTTO;

/**
 * @author sangsik.kim
 */
public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
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

    public LottoResult createResult(Lotto winningLotto, Integer bonusNumber) {
        Map<Rank, Integer> result = new HashMap();
        for (Rank rank : Rank.values()) {
            result.put(rank, countOfWinningLotto(rank, winningLotto, bonusNumber));
        }
        return new LottoResult(result, calculateBuyAmount());
    }

    public int countOfWinningLotto(Rank rank, Lotto winningLotto, Integer bonusNumber) {
        return Math.toIntExact(this.lottos
                .stream()
                .filter(lotto -> lotto.getRank(winningLotto, bonusNumber).equals(rank))
                .count());
    }
}
