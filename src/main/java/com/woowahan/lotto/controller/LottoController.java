package com.woowahan.lotto.controller;

import com.woowahan.lotto.model.PriceInfo;
import com.woowahan.lotto.model.UserLotto;
import com.woowahan.lotto.model.WinningLotto;

import java.util.*;

public class LottoController {
    public List<UserLotto> buy(int money) {
        List<UserLotto> totalLotto = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            totalLotto.add(new UserLotto());
        }
        return totalLotto;
    }

    public int check(UserLotto lotto, WinningLotto lucky) {
        int count = 0;

        for (Integer luck : lucky.getWinningLotto()) {
            count += getCount(lotto, luck);
        }

        return count;

    }

    private int getCount(UserLotto lotto, Integer luck) {
        if (lotto.contains(luck)) {
            return 1;
        }
        return 0;
    }

    private boolean checkBonusNumber(UserLotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public Map<PriceInfo, Integer> checkAllLottos(List<UserLotto> lottos, WinningLotto lucky) {
        Map<PriceInfo, Integer> winInfo = initWinInfo();

        for (UserLotto lotto : lottos) {
            int count = check(lotto, lucky);
            PriceInfo key = PriceInfo.getValueByWinningCondition(count, checkBonusNumber(lotto, lucky.getBonusNumber()));
            winInfo.put(key, winInfo.get(key) + 1);
        }

        winInfo.remove(PriceInfo.LOSE);

        return winInfo;
    }

    private Map<PriceInfo, Integer> initWinInfo() {
        Map<PriceInfo, Integer> winInfo = new HashMap<>();

        for (PriceInfo priceInfo : PriceInfo.values()) {
            winInfo.put(priceInfo, 0);
        }
        return winInfo;
    }

    public int getTotalWinPrice(Map<PriceInfo, Integer> winInfo) {
        int totalPrice = 0;
        for (PriceInfo key : winInfo.keySet()) {
            totalPrice += key.getPrice() * winInfo.get(key);
        }
        return totalPrice;
    }

    public int calculateBenefit(int totalPrice, int money) {
        return totalPrice * 100 / money;
    }
}
