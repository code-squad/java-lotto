package com.codesquad.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum WinType {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    OUT(0, 0);

    private static final Map<Integer, WinType> map = new HashMap<>();

    static {
        for (final WinType type : WinType.values()) {
            map.put(type.matchCount, type);
        }
    }

    private final int matchCount;
    private final int prizePrice;

    WinType(final int matchCount, final int prizePrice) {
        this.matchCount = matchCount;
        this.prizePrice = prizePrice;
    }

    public static WinType valueOf(final int matchCount) {
        if (!map.containsKey(matchCount)) {
            return WinType.OUT;
        }

        return map.get(matchCount);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchCount, prizePrice);
    }


    public Money calculatePrize(final int count) {
        return new Money(prizePrice * count);
    }

    public boolean isWin() {
        return this != WinType.OUT;
    }
}
