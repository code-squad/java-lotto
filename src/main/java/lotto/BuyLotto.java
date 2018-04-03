package lotto;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private List<Lotto> lottos;

    public BuyLotto(int inputMoney) {
        lottos = new ArrayList<>();
        int num = inputMoney / 1000;
        for(int i = 0; i < num; i++)
            lottos.add(new Lotto());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
