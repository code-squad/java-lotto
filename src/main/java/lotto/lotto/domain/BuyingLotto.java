package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class BuyingLotto {

    private List<Lotto> lottos;

    public BuyingLotto(int buyingNum) {
        this.lottos = buyLottoAutomatic(buyingNum);
    }

    public List<Lotto> buyLottoAutomatic(int buyingNum) {
        Lotto buyingOneLotto;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyingNum; i++) {
            buyingOneLotto = new Lotto();
            lottos.add(buyingOneLotto);
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
