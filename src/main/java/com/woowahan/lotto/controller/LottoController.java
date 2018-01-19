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



//    public LottoResult checkAllLottos(List<Lotto> lottos, WinningLotto lucky) {
//        LottoResult lottoResult = new LottoResult();
//
//        for (Lotto lotto : lottos) {
//            int keyCode = checkKeyCode(lotto, lucky);
//            PriceInfo key = PriceInfo.getValueByWinningCondition(keyCode);
//            lottoResult.addPriceInfo(key);
//        }
//
//        return lottoResult;
//    }
}
