package com.woowahan.lotto.controller;

import com.woowahan.lotto.model.*;

import java.util.*;

public class LottoController {
    public List<Lotto> buy(int money) {
        List<Lotto> totalLotto = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            totalLotto.add(new Lotto());
        }
        return totalLotto;
    }

    public int checkKeyCode(Lotto lotto, WinningLotto lucky) {
        int count = 0;

        for (LottoNo luck : lucky.getWinningLotto()) {
            count += getCount(lotto, luck);
        }

        if (count == 5 && checkBonusNumber(lotto, lucky.getBonusNumber())) {
            count = 7;
        }

        return count;
    }

    private int getCount(Lotto lotto, LottoNo luck) {
        if (lotto.contains(luck)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusNumber(Lotto lotto, LottoNo bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public LottoResult checkAllLottos(List<Lotto> lottos, WinningLotto lucky) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : lottos) {
            int keyCode = checkKeyCode(lotto, lucky);
            PriceInfo key = PriceInfo.getValueByWinningCondition(keyCode);
            lottoResult.addPriceInfo(key);
        }

        return lottoResult;
    }
}
