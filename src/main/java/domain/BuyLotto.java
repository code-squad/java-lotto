package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private List<Lotto> lottos;

    public BuyLotto(int totalPrice, List<String> manualLotto) {
        priceCheck(totalPrice);
        this.lottos = buyLotto(totalPrice, manualLotto);
    }

    private List<Lotto> buyLotto(int totalPrice, List<String> manualLotto) {
        int ticketNum = totalPrice / LOTTO_PRICE - manualLotto.size();
        List<Lotto> lottos = buyManualLotto(manualLotto);
        return this.lottos = buyAutoLotto(ticketNum, lottos);
    }

    private static List<Lotto> buyManualLotto(List<String> manualLotto) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (String lotto : manualLotto) {
            manualLottos.add(Lotto.of(lotto));
        }
        return manualLottos;
    }

    private void priceCheck(int lottoPrice) {
        if (lottoPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("잔고가 부족합니다.");
        }
        if (lottoPrice % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("로또는 한장에 1000원 입니다.");
        }
    }
    private List<Lotto> buyAutoLotto(int buyingNum, List<Lotto> lottos) {
        for (int i = 0; i < buyingNum; i++) {
            lottos.add(Lotto.buyingLottos());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
