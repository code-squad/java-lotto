package com.woowahan.lotto.controller;

import com.woowahan.lotto.model.*;

import java.util.*;

public class LottoController {
    public Lottos buy(int money) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < money / 1000; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
