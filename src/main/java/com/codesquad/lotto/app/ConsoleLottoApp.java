package com.codesquad.lotto.app;

import com.codesquad.lotto.domain.*;
import com.codesquad.lotto.infrastructure.DefaultShuffler;
import com.codesquad.lotto.view.InputView;
import com.codesquad.lotto.view.LottoReceiptPresentationModel;
import com.codesquad.lotto.view.ResultView;

import java.util.List;

public class ConsoleLottoApp {
    public static void main(final String[] args) {
        final Money payment = InputView.inputPayment();
        LottoNumberGenerator generator = createGenerator();
        final LottoMachine machine = new LottoMachine(new Money(1000), generator);
        final List<Lotto> lotteries = machine.buy(payment);
        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(lotteries);
        ResultView.print(model);
//
//        InputView.inputWinningNumber();
//        ResultView.printStats();
    }

    private static LottoNumberGenerator createGenerator() {
        Shuffler shuffler = new DefaultShuffler();
        return new DefaultLottoNumberGenerator(shuffler);
    }
}
