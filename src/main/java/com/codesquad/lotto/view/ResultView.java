package com.codesquad.lotto.view;

public class ResultView {
    public static void print(final LottoReceiptPresentationModel receipt) {
        System.out.println(receipt.countMessage());
        System.out.println(receipt.lottoList());
    }
}
