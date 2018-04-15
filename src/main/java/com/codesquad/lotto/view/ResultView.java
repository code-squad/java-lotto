package com.codesquad.lotto.view;

public class ResultView {
    public static void print(final LottoReceiptPresentationModel receipt) {
        System.out.println(receipt.countMessage());
        System.out.println(receipt.lottoList());
    }

    public static void print(final LottoStatsPresentationModel statsModel) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(statsModel.winCountListMessage());
        System.out.println(statsModel.profitMessage());
    }
}
