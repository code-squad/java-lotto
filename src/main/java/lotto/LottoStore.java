package lotto;

import java.util.List;

class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    static List<Lotto> buyLotto(int money) {
        checkLowPayment(money);

        return LottoMachine.publishLotto(avaliableLottoCount(money));
    }

    private static int avaliableLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private static void checkLowPayment(int money) {
        if (isLowPayment(money)) {
            throw new RuntimeException();
        }
    }

    private static boolean isLowPayment(int money) {
        return money < LOTTO_PRICE;
    }
}
