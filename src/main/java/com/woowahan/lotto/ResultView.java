package com.woowahan.lotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultView {
    public void printMyLottoInfo(List<Lotto> myLotto) {
        System.out.println(myLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : myLotto) {
            System.out.println(lotto);
        }
    }

    public void printLottoResult(Map<PriceInfo, Integer> winInfo) {
        System.out.println("당첨 통계\n----------");
        for (PriceInfo priceInfo : new TreeMap<>(winInfo).keySet()) {
            System.out.println(priceInfo.getWinningCondition() + "개 일치(" + priceInfo.getPrice() + "원)- "
                    + winInfo.get(priceInfo) + "개");
        }
    }
}
