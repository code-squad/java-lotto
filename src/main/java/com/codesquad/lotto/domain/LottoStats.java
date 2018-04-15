package com.codesquad.lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoStats {

    private final Money payment;
    private final Map<WinType, Integer> accumulatedCountMap;

    public LottoStats(final Map<WinType, Integer> accumulatedCountMap, final Money payment) {
        if (Objects.isNull(accumulatedCountMap)) {
            throw new IllegalArgumentException();
        }

        if (payment == null) {
            throw new IllegalArgumentException();
        }

        this.accumulatedCountMap = accumulatedCountMap;
        this.payment = payment;
    }

    public int getWiningCount(final WinType type) {
        return accumulatedCountMap.get(type);
    }

    public int getProfitRate() {
        Money sum = new Money(0);

        for (final Map.Entry<WinType, Integer> entry : accumulatedCountMap.entrySet()) {
            sum = sum.add(entry.getKey().calculatePrize(entry.getValue()));
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
        final LottoStats stats = (LottoStats) o;
        return Objects.equals(payment, stats.payment) &&
                Objects.equals(accumulatedCountMap, stats.accumulatedCountMap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(payment, accumulatedCountMap);
    }
}
