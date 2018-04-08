package lotto.domain;

import java.util.List;

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

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
