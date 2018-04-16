package domain;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private List<Lotto> lottos;

    public BuyLotto(int totalPrice) {
        priceCheck(totalPrice);
        int ticketNum = totalPrice / LOTTO_PRICE;
        this.lottos = buyingLottos(ticketNum);
    }

    private void priceCheck(int lottoPrice) {
        if (lottoPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("잔고가 부족합니다.");
        }
        if (lottoPrice % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("로또는 한장에 1000원 입니다.");
        }
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
