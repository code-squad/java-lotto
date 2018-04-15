package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoProvider {
    private List<Lotto> lottos;

    public LottoProvider() {
        lottos = new ArrayList<Lotto>();
    }

    public List<Lotto> purchaseLottos(long money) {
        int countOfLotto = (int) money / LottoMachine.LOTTO_PRICE;
        for (int index = 0; index < countOfLotto; index++) {
            lottos.add(LottoMachine.getLottoNumber());
        }
        return lottos;
    }

    public List<Lotto> getPurchasedLottos() {
        return lottos;
    }
}
