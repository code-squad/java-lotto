package com.codesquad.lotto.application;

import com.codesquad.lotto.domain.Money;
import com.codesquad.lotto.domain.WinningMatchResult;

import java.util.Objects;

public class LottoGameResult {

    private final Money payment;
    private final WinningMatchResult matchResult;

    public LottoGameResult(final WinningMatchResult matchResult, final Money payment) {
        if (Objects.isNull(matchResult)) {
            throw new IllegalArgumentException();
        }

        if (payment == null) {
            throw new IllegalArgumentException();
        }

        this.matchResult = matchResult;
        this.payment = payment;
    }

    public WinningMatchResult getMatchResult() {
        return matchResult;
    }


    public int calcProfitRate() {
        final Money totalPrize = this.matchResult.getTotalPrize();
        return Money.calculateProfitRate(totalPrize, payment);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoGameResult stats = (LottoGameResult) o;
        return Objects.equals(payment, stats.payment) &&
                Objects.equals(matchResult, stats.matchResult);
    }

    @Override
    public int hashCode() {

        return Objects.hash(payment, matchResult);
    }
}
