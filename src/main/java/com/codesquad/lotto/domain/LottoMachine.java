package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private final Money listPrice;

    public LottoMachine(final Money listPrice) {
        this.listPrice = listPrice;
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
                    lotteries.add(generateLottery());
                });
        return lotteries;
    }

    private LottoNumber generateLottery() {
        //return new LottoNumber();
        return null;
    }
}
