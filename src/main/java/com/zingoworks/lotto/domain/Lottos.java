package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int PRICE_OF_LOTTO = 1000;

    private List<Lotto> lottos;
    private int numberOfLottos;

    public Lottos(int purchaseAmount) {
        verifyMinimumAmount(purchaseAmount);
        this.numberOfLottos = purchaseAmount / PRICE_OF_LOTTO;
        this.lottos = getAllLottos();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    //by pobi...
    //테스트코드 구현이 가능?
    public LottoResult match(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            Prize prize = winningLotto.match(lotto);
            result.addPrize(prize);
        }
        return result;
    }

    public String getPurchasePhrase() {
        return numberOfLottos + "게임을 구매했습니다.";
    }

    private List<Lotto> getAllLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int j = 0; j < numberOfLottos; j++) {
            lottos.add(Lotto.generateAutomaticLotto());
        }
        return lottos;
    }

    private void verifyMinimumAmount(int amount) {
        if (amount < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException("<경고> 최소 구매금액은 1000원 이상입니다.");
        }
    }
}