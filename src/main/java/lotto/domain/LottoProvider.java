package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sangsik.kim
 */
public class LottoProvider {
    private static final int PRICE_PER_LOTTO = 1000;

    public static LottoGame order(int amount) {
        List<Lotto> lottos = new ArrayList();
        for (int i = 0; i < availableQuantity(amount); i++) {
            lottos.add(new Lotto());
        }
        return new LottoGame(lottos);
    }

    private static int availableQuantity(int amount) {
        return amount / PRICE_PER_LOTTO;
    }
}
