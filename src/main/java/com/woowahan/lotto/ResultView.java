package com.woowahan.lotto;

import java.util.List;

public class ResultView {
    public void printMyLottoInfo(List<Lotto> myLotto) {
        for (Lotto lotto : myLotto) {
            System.out.println(myLotto);
        }
    }
}
