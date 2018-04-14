package com.codesquad.lotto.app;

import com.codesquad.lotto.domain.LottoMachine;
import com.codesquad.lotto.view.InputView;
import com.codesquad.lotto.vo.Money;

public class ConsoleLottoApp {
    public static void main(final String[] args) {
        final Money payment = InputView.inputPayment();
        final LottoMachine machine = new LottoMachine(new Money(1000));
//        final LottoBundle lottoBundle = machine.buy(payment);
//        ResultView.printPurchased(lottoBundle);
//
//        InputView.inputWinningNumber();
//        ResultView.printStats();
    }
}
