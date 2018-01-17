package com.woowahan.lotto;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

import java.util.*;

public class Lotto {
    private List<Integer> baseNumberList;
    private Map<Integer, Integer> winningPriceInfo;

    public Lotto() {
        baseNumberList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            baseNumberList.add(i);
        }

        winningPriceInfo = new HashMap<>();
        winningPriceInfo.put(3, 5000);
        winningPriceInfo.put(4, 50000);
        winningPriceInfo.put(5, 1500000);
        winningPriceInfo.put(6, 2000000000);
    }

    public List<Integer> create() {
        List<Integer> copyBaseList = new ArrayList<>(baseNumberList);
        Collections.shuffle(copyBaseList);
        return copyBaseList.subList(0, 6);
    }

    public List<List<Integer>> buy(int money) {
        List<List<Integer>> totalLotto = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            totalLotto.add(create());
        }
        return totalLotto;
    }

    public List<Integer> sort(List<Integer> lotto) {
        List<Integer> sortedLotto = new ArrayList<>(lotto);
        Collections.sort(sortedLotto);

        return sortedLotto;
    }

    public int check(List<Integer> lotto, List<Integer> lucky) {
        int count = 0;

        for (Integer luck : lucky) {
            count += getCount(lotto, luck);
        }

        return count;
    }

    private int getCount(List<Integer> lotto, Integer luck) {
        if (lotto.contains(luck)) {
            return 1;
        }
        return 0;
    }

    public Map<Integer, Integer> getWinInfo(List<List<Integer>> lottos, List<Integer> lucky) {
        Map<Integer, Integer> winInfo = new HashMap<>();
        winInfo.put(5000, 0);
        winInfo.put(50000, 0);
        winInfo.put(1500000, 0);
        winInfo.put(2000000000, 0);

        for (List<Integer> lotto : lottos) {
            Integer key = winningPriceInfo.get(check(lotto, lucky));
            winInfo.put(key, winInfo.get(key) + 1);
        }
        return winInfo;
    }
}
