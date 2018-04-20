package com.codesquad.lotto.domain;

import java.util.Map;
import java.util.Objects;

public class WinningMatchResult {

    private final Map<WinType, Long> matchMap;
    private final Money totalPrize;

    public WinningMatchResult(final Map<WinType, Long> winTypeCount) {
        if (winTypeCount == null) {
            throw new IllegalArgumentException();

        }
        this.matchMap = winTypeCount;
        this.totalPrize = sumTotalPrize();
    }

    public int getCountByWinType(final WinType type) {
        if (matchMap.containsKey(type)) {
            return matchMap.get(type).intValue();
        }
        return 0;
    }

    public Money getTotalPrize() {
        return this.totalPrize;
    }

    private Money sumTotalPrize() {
        Money sum = new Money(0);
        for (final Map.Entry<WinType, Long> entry : matchMap.entrySet()) {
            sum = sum.add(entry.getKey().calculatePrize(entry.getValue().intValue()));
        }
        return sum;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final WinningMatchResult that = (WinningMatchResult) o;
        return Objects.equals(matchMap, that.matchMap) &&
                Objects.equals(totalPrize, that.totalPrize);
    }

    @Override
    public int hashCode() {

        return Objects.hash(matchMap, totalPrize);
    }
}
