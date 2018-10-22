package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.util.Constant.LOTTO_PRICE;

public class LottoGame {
    private int price = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int price) {
        this.price = price;

        for (int i = 0; i < price/LOTTO_PRICE; i++) {
            lottos.add(Lotto.generateLottoNumber());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map compare(String input){
        Lotto winningLotto = Lotto.winningLotto(input);
        int count = 0;
        LottoMap map = new LottoMap();
        for (Lotto lotto : lottos) {
            count = lotto.compare(winningLotto);
            map.saveCountWinLotto(count);
        }
        return map.getMap();
    }
}
