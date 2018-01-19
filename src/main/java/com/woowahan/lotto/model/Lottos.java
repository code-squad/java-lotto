package com.woowahan.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public LottoResult match(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            winningLotto.match(lotto);

        }

    }
}
