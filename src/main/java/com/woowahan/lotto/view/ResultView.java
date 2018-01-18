package com.woowahan.lotto.view;

import com.woowahan.lotto.model.PriceInfo;
import com.woowahan.lotto.model.UserLotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultView {
    public void printMyLottoInfo(List<UserLotto> myLotto) {
        System.out.println(myLotto.size() + "개를 구매했습니다.");
        for (UserLotto lotto : myLotto) {
            System.out.println(lotto);
        }
    }

    public void printLottoResult(Map<PriceInfo, Integer> winInfo, int benefit) {
        System.out.println("당첨 통계\n----------");
        for (PriceInfo priceInfo : new TreeMap<>(winInfo).keySet()) {
            System.out.println(priceInfo.toString() + " - " + winInfo.get(priceInfo) + "개");
        }
        System.out.println("총 수익률은 " + benefit + "%입니다.");
    }
}
