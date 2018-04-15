package com.codesquad.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final Money listPrice;
    private final LottoNumberGenerator numberGenerator;

    public LottoMachine(final Money listPrice, final LottoNumberGenerator numberGenerator) {
        this.listPrice = listPrice;
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> buy(final Money payment) {

        final int quotient = calcQtyFromPayment(payment);
        return generateLotteries(quotient);
    }

    private int calcQtyFromPayment(final Money payment) {
        return payment.divide(listPrice);
    }

    private List<Lotto> generateLotteries(final int quotient) {
        return IntStream.range(0, quotient)
                .mapToObj(n -> numberGenerator.generate())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
