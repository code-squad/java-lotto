package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sangsik.kim
 */
public class LottoProvider {
    public static final int PRICE_PER_LOTTO = 1000;

    public static LottoTicket order(Money money) {
        return makeLottoTicket(money, new ArrayList());
    }

    public static LottoTicket order(Money money, List<Lotto> customLottos) {
        int customLottosAmount = customLottos.size() * PRICE_PER_LOTTO;
        Money remainingMoney = money.spend(customLottosAmount);

        return makeLottoTicket(remainingMoney, customLottos);
    }

    private static LottoTicket makeLottoTicket(Money money, List<Lotto> lottos) {
        for (int i = 0; i < availableQuantity(money); i++) {
            lottos.add(Lotto.of(AutoSelector.generate()));
        }
        return new LottoTicket(lottos);
    }

    private static int availableQuantity(Money money) {
        return Math.toIntExact(money.valueOf() / PRICE_PER_LOTTO);
    }
}
