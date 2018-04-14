package com.codesquad.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
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
        return IntStream.range(0, quotient)
                .mapToObj(n -> generator.generate())
                .collect(Collectors.toList());
    }
}
