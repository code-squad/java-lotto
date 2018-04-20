package com.codesquad.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public final static Money LIST_PRICE = new Money(1000);
    private final LottoNumberGenerator numberGenerator;

    public LottoMachine(final LottoNumberGenerator numberGenerator) {
        if (numberGenerator == null) {
            throw new IllegalArgumentException("번호생성기가 필요합니다.");
        }

        this.numberGenerator = numberGenerator;
    }

    public LottoBundle buy(final Money payment) {
        if (payment == null) {
            throw new IllegalArgumentException("구매금액이 필요합니다.");
        }

        final int quotient = calcQtyFromPayment(payment);
        return new LottoBundle(generateLotteries(quotient));
    }

    private int calcQtyFromPayment(final Money payment) {
        return payment.divide(LIST_PRICE);
    }

    private List<Lotto> generateLotteries(final int quotient) {
        return IntStream.range(0, quotient)
                .mapToObj(n -> numberGenerator.generate())
                .map(Lotto::fromLottoNumbers)
                .collect(Collectors.toList());
    }
}
