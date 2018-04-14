package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Money.PRICE_PER_LOTTO;

/**
 * @author sangsik.kim
 */
public class LottoProvider {

    public static LottoTicket order(Money money) {
        return makeLottoTicket(money, new ArrayList());
    }

    public static LottoTicket order(Money money, List<Lotto> customLottos) {
        Money remainingMoney = money.spend(customLottos.size() * PRICE_PER_LOTTO);
        return makeLottoTicket(remainingMoney, customLottos);
    }

    private static LottoTicket makeLottoTicket(Money money, List<Lotto> lottos) {
        for (int i = 0; i < availableQuantity(money); i++) {
            lottos.add(Lotto.of(AutoSelector.generate()));
        }
        return new LottoTicket(lottos);
    }

    private static int availableQuantity(Money money) {
        return money.calculateNumberOfPurchase(PRICE_PER_LOTTO);
    }
}
