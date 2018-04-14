package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private final Money listPrice;
    private final LottoGenerator generator;

    public LottoMachine(final Money listPrice, final LottoGenerator generator) {
        this.listPrice = listPrice;
        this.generator = generator;
    }

    public List<LottoNumber> buy(final Money payment) {

        final int quotient = calcQtyFromPayment(payment);
        return generateLotteries(quotient);
    }

    private int calcQtyFromPayment(final Money payment) {
        return payment.divide(listPrice);
    }

    private List<LottoNumber> generateLotteries(final int quotient) {
        final List<LottoNumber> lotteries = new ArrayList<>();
        IntStream.range(0, quotient)
                .forEach(n -> {
                    lotteries.add(generator.generate());
                });
        return lotteries;
    }
}
