package com.codesquad.lotto.app;

import com.codesquad.lotto.domain.*;
import com.codesquad.lotto.infrastructure.DefaultShuffler;
import com.codesquad.lotto.view.InputView;
import com.codesquad.lotto.view.LottoReceiptPresentationModel;
import com.codesquad.lotto.view.ResultView;

import java.util.List;

public class ConsoleLottoApp {
    public static void main(final String[] args) {
        final LottoMachine machine = prepareLottoMachine(1000);

        final Money payment = InputView.inputPayment();
        final List<Lotto> lotteries = machine.buy(payment);

        final LottoReceiptPresentationModel model = new LottoReceiptPresentationModel(lotteries);
        ResultView.print(model);

        final Lotto winLotto = InputView.inputWinLotto();
        
//        ResultView.printStats();
    }

    private static LottoMachine prepareLottoMachine(int listPrice) {
        final LottoNumberGenerator generator = createGenerator();
        return new LottoMachine(new Money(listPrice), generator);
    }

    private static LottoNumberGenerator createGenerator() {
        final Shuffler shuffler = new DefaultShuffler();
        return new DefaultLottoNumberGenerator(shuffler);
    }
}
