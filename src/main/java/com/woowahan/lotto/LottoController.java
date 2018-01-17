package com.woowahan.lotto;

import java.util.*;

public class LottoController {

    private static final Map<Integer, Integer> WINNING_PRICE_INFO = setWinningPriceInfo();

    private static Map<Integer, Integer> setWinningPriceInfo() {
        Map<Integer, Integer> winningPriceInfo = new HashMap<>();
        winningPriceInfo.put(3, 5000);
        winningPriceInfo.put(4, 50000);
        winningPriceInfo.put(5, 1500000);
        winningPriceInfo.put(6, 2000000000);

        return winningPriceInfo;
    }

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

    public Map<Integer, Integer> getWinInfo(List<Lotto> lottos, List<Integer> lucky) {
        Map<Integer, Integer> winInfo = new HashMap<>();
        winInfo.put(5000, 0);
        winInfo.put(50000, 0);
        winInfo.put(1500000, 0);
        winInfo.put(2000000000, 0);

        for (Lotto lotto : lottos) {
            Integer key = WINNING_PRICE_INFO.get(check(lotto, lucky));
            winInfo.put(key, winInfo.get(key) + 1);
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
