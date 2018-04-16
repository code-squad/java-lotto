package com.codesquad.lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoGameResult {

    private final Money payment;
    private final Map<WinType, Long> winTypeCount;

    public LottoGameResult(final Map<WinType, Long> winTypeCount, final Money payment) {
        if (Objects.isNull(winTypeCount)) {
            throw new IllegalArgumentException();
        }

        if (payment == null) {
            throw new IllegalArgumentException();
        }

        this.winTypeCount = winTypeCount;
        this.payment = payment;
    }

    public int getWiningCount(final WinType type) {
        if (winTypeCount.containsKey(type)) {
            return winTypeCount.get(type).intValue();
        }
        
        return 0;
    }

    public int getProfitRate() {
        Money sum = new Money(0);

        for (final Map.Entry<WinType, Long> entry : winTypeCount.entrySet()) {
            sum = sum.add(entry.getKey().calculatePrize(entry.getValue().intValue()));
        }

        return Money.calculateProfitRate(sum, payment);
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
                Objects.equals(winTypeCount, stats.winTypeCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(payment, winTypeCount);
    }
}
