package lotto;


import java.util.ArrayList;
import java.util.List;

class LottoMachine {
    static List<Lotto> publishLotto(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (; amount > 0; amount--) {
            lottoList.add(Lotto.of());
        }

        return lottoList;
    }
}
