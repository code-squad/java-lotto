package domain;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private static final int PER_LOTTO_PRICE = 1000;
    private List<Lotto> lottos;

    public BuyLotto(int totalPrice) {
        ExceptionCheck.priceCheck(totalPrice);
        int ticketNum = totalPrice / PER_LOTTO_PRICE;
        this.lottos = buyingLottos(ticketNum);
    }

    private List<Lotto> buyingLottos(int buyingNum) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < buyingNum; i++) {
            lotto.add(Lotto.buyingLottos());
        }
        return lotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
