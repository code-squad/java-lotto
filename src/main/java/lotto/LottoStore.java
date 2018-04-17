package lotto;

import java.util.ArrayList;
import java.util.List;

class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    static List<Lotto> buyLotto(int money) {
        try {
            checkLowPayment(money);

            return LottoMachine.publishLotto(avaliableLottoCount(money));

        } catch(RuntimeException re) {
            return new ArrayList<>();
        }
    }

    public static List<Lotto> buyLotto(int money, List<Lotto> lottos) {
        money = deductionMoney(money, lottos.size());

        List<Lotto> purchasedLotto = new ArrayList<>();
        purchasedLotto.addAll(lottos);
        purchasedLotto.addAll(LottoStore.buyLotto(money));

        return purchasedLotto;
    }

    private static int deductionMoney(int money, int size) {
        money -= size * LOTTO_PRICE;
        return money;
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
