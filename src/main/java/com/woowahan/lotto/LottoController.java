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

    public int check(Lotto lotto, List<Integer> lucky) {
        int count = 0;

        for (Integer luck : lucky) {
            count += getCount(lotto, luck);
        }

        return count;

    }

    private int getCount(Lotto lotto, Integer luck) {
        if (lotto.contains(luck)) {
            return 1;
        }
        return 0;
    }

    public Map<PriceInfo, Integer> checkAllLottos(List<Lotto> lottos, List<Integer> lucky) {
        Map<PriceInfo, Integer> winInfo = initWinInfo();

        for (Lotto lotto : lottos) {
            int count = check(lotto, lucky);
            PriceInfo key = PriceInfo.getValueByWinningCondition(count);
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

    public int getTotalWinPrice(Map<Integer, Integer> winInfo) {
        int totalPrice = 0;
        for (Integer key : winInfo.keySet()) {
            totalPrice += key * winInfo.get(key);
        }
        return totalPrice;
    }
}
