package com.woowahan.lotto.controller;

import com.woowahan.lotto.model.LottoResult;
import com.woowahan.lotto.model.PriceInfo;
import com.woowahan.lotto.model.Lotto;
import com.woowahan.lotto.model.WinningLotto;

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

        for (Integer luck : lucky.getWinningLotto()) {
            count += getCount(lotto, luck);
        }

        if (count == 5 && checkBonusNumber(lotto, lucky.getBonusNumber())) {
            count = 7;
        }

        return count;

    }

    private int getCount(Lotto lotto, Integer luck) {
        if (lotto.contains(luck)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
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
