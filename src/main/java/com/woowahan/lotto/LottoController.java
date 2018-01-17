package com.woowahan.lotto;

import java.util.*;

public class LottoController {
    public List<Lotto> buy(int money) {
        List<Lotto> totalLotto = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            totalLotto.add(new Lotto());
        }
        return totalLotto;
    }

    public void check(Lotto lotto, List<Integer> lucky) {
        int count = 0;

        for (Integer luck : lucky) {
            count += getCount(lotto, luck);
        }

        switch (count) {
            case 3:
                PriceInfo.THREE.addCount();
                break;
            case 4:
                PriceInfo.FOUR.addCount();
                break;
            case 5:
                PriceInfo.FIVE.addCount();
                break;
            case 6:
                PriceInfo.SIX.addCount();
                break;
        }
    }

    private int getCount(Lotto lotto, Integer luck) {
        if (lotto.contains(luck)) {
            return 1;
        }
        return 0;
    }

    public void checkAllLottos(List<Lotto> lottos, List<Integer> lucky) {
        for (Lotto lotto : lottos) {
            check(lotto, lucky);
        }
    }

    public int getTotalWinPrice(Map<Integer, Integer> winInfo) {
        int totalPrice = 0;
        for (Integer key : winInfo.keySet()) {
            totalPrice += key * winInfo.get(key);
        }
        return totalPrice;
    }
}
