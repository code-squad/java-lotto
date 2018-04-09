package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> pay(int won) {
        if(isLowPayment(won)) {
            throw new RuntimeException();
        }

        Random rn = new LottoRandomNumber();

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < avaliableLottoCount(won); i++) {
            lottos.add(new Lotto(rn));
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
