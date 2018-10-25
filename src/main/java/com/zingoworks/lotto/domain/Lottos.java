package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final int PRICE_LOTTO = 1000;

    private List<Lotto> lottos;

    public Lottos(int purchaseAmount) {
        if (purchaseAmount < PRICE_LOTTO) {
            throw new IllegalArgumentException("<경고> 최소 구매금액은 1000원 이상입니다.");
        }
        this.lottos = getAllLottos(purchaseAmount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult match(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            Prize prize = winningLotto.match(lotto);
            result.addPrize(prize);
        }
        return result;
    }

    private List<Lotto> getAllLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int j = 0; j < purchaseAmount / PRICE_LOTTO; j++) {
            lottos.add(Lotto.generateAutomaticLotto());
        }
        return lottos;
    }
}