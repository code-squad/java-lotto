package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    public static final int PRICE_LOTTERY = 1000;

    private List<Lotto> lottos;

    private Lottos(int purchaseAmount) {
        if (purchaseAmount < PRICE_LOTTERY) {
            throw new IllegalArgumentException("<경고> 최소 구매금액은 1000원 이상입니다.");
        }
        this.lottos = generateLottos(purchaseAmount);
    }

    public static List<Lotto> getAllLottos(int purchaseAmount) {
        return new Lottos(purchaseAmount).getLottos();
    }

    private List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> generateLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int j = 0; j < purchaseAmount / PRICE_LOTTERY; j++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
