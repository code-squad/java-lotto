package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static com.zingoworks.lotto.domain.Lotto.PRICE_OF_GAME;

public class FullLotto {
    private List<Lotto> fullLotto;

    public FullLotto(int purchaseAmount) {
        generateFullLotto(purchaseAmount);
    }

    public List<Lotto> getFullLotto() {
        return this.fullLotto;
    }

    List<Integer> countFullWinning(List<Integer> lastWinningNumbers) {
        List<Integer> results = new ArrayList<>();
        for (Lotto lotto : fullLotto) {
            results.add(lotto.countWinning(lastWinningNumbers));
        }
        return results;
    }

    private void generateFullLotto(int purchaseAmount) {
        this.fullLotto = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / PRICE_OF_GAME; i++) {
            this.fullLotto.add(new Lotto());
        }
    }
}
