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

    public LottoResult createResult(Lotto winningLotto) {
        Map<WinningTier, Integer> result = new HashMap();
        for (WinningTier tier : WinningTier.values()) {
            result.put(tier, winningLottoCount(tier, winningLotto));
        }
        return new LottoResult(result, calculateBuyAmount());
    }

    public int winningLottoCount(WinningTier tier, Lotto winningLotto) {
        return Math.toIntExact(this.lottos
                .stream()
                .filter(lotto -> lotto.tier(winningLotto).equals(tier))
                .count());
    }
}
