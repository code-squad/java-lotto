package lotto;

import java.util.ArrayList;
import java.util.List;

class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    static List<Lotto> pay(int won) {
        if(isLowPayment(won)) {
            throw new RuntimeException();
        }

        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < avaliableLottoCount(won); i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    private static int avaliableLottoCount(int won) {
        return won / LOTTO_PRICE;
    }

    private static boolean isLowPayment(int won) {
        return won < LOTTO_PRICE;
    }
}
