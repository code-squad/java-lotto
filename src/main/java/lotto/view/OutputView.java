package lotto.view;

import lotto.Prize;

import java.util.Map;

public interface OutputView {

    void printPurchasedLotto();

    void printLottoResult(Map<Prize, Integer> result, int calculateEarningRate);
}
