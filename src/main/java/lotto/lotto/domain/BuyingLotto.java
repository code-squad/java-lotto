package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class BuyingLotto {

    private List<Lotto> lottos;

    public BuyingLotto(int money) {
        LottoException.moneyCheckException(money);
        this.lottos = buyLottoAutomatic(money / 1000);
    }

    private List<Lotto> buyLottoAutomatic(int buyingNum) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyingNum; i++) {
            lottos.add(Lotto.automaticLotto());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
