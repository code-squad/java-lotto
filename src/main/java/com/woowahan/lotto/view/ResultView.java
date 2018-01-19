package com.woowahan.lotto.view;

import com.woowahan.lotto.model.LottoResult;
import com.woowahan.lotto.model.PriceInfo;
import com.woowahan.lotto.model.Lotto;

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

    public void printLottoResult(LottoResult lottoResult, int benefit) {
        System.out.println("당첨 통계\n----------");
        for (PriceInfo priceInfo : lottoResult.getSortedWinInfo().keySet()) {
            System.out.println(priceInfo.toString() + " - " + lottoResult.getCount(priceInfo) + "개");
        }
        System.out.println("총 수익률은 " + benefit + "%입니다.");
    }
}
