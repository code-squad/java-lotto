package com.codesquad.lotto.view;

import com.codesquad.lotto.application.LottoGame;
import com.codesquad.lotto.application.LottoGameResult;

public class ResultView {
    public static void printLotto(final LottoGame lottoGame) {
        final LottoReceiptPresentationModel receipt = new LottoReceiptPresentationModel(lottoGame.getBundle());
        System.out.println(receipt.countMessage());
        System.out.println(receipt.lottoList());
    }

    public static void statistic(final LottoGameResult result) {
        final LottoStatsPresentationModel stats = new LottoStatsPresentationModel(result);
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(stats.winCountListMessage());
        System.out.println(stats.profitMessage());
    }
}
