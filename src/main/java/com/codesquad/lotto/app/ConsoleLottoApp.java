package com.codesquad.lotto.app;

import com.codesquad.lotto.domain.*;
import com.codesquad.lotto.infrastructure.DefaultShuffler;
import com.codesquad.lotto.view.InputView;
import com.codesquad.lotto.view.LottoReceiptPresentationModel;
import com.codesquad.lotto.view.LottoStatsPresentationModel;
import com.codesquad.lotto.view.ResultView;

import java.util.List;

public class ConsoleLottoApp {
    public static void main(final String[] args) {
        final LottoMachine machine = prepareLottoMachine();

        final Money payment = InputView.inputPayment();
        final List<Lotto> lotteries = machine.buy(payment);

        final LottoReceiptPresentationModel receiptModel = new LottoReceiptPresentationModel(lotteries);
        ResultView.print(receiptModel);
        
        System.out.println();

        final Lotto winLotto = InputView.inputWinLotto();
        final LottoStats stats = new LottoStats(lotteries, winLotto);
        final LottoStatsPresentationModel statsModel = new LottoStatsPresentationModel(stats);
        ResultView.print(statsModel);
    }

    private static LottoMachine prepareLottoMachine() {
        final LottoNumberGenerator generator = createGenerator();
        return new LottoMachine(generator);
    }

    private static LottoNumberGenerator createGenerator() {
        final Shuffler shuffler = new DefaultShuffler();
        return new DefaultLottoNumberGenerator(shuffler);
    }
}
