package com.woowahan.lotto;

import java.util.List;

public class ResultView {
    public void printMyLottoInfo(List<Lotto> myLotto) {
        System.out.println(myLotto.size() + "개를 구매했습니다.");
        for (Lotto lotto : myLotto) {
            System.out.println(lotto);
        }
    }

    public void printLottoResult() {
        System.out.println("당첨 통계\n----------");
        for (PriceInfo value : PriceInfo.values()) {
            System.out.println(value.getValue() + "개 일치(" + value.getPrice() + "원)- " + value.getCount() + "개");
        }

    }
}
