package com.codesquad.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum WinType {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000),
    OUT(0, 0);

    private static final Map<Integer, WinType> map = new HashMap<>();
    private static final WinType bonusWinType = WinType.FIVE_WITH_BONUS;

    static {
        for (final WinType type : WinType.values()) {
            if (type == WinType.FIVE_WITH_BONUS) {
                continue;
            }

            map.put(type.matchCount, type);
        }
    }

    private final int matchCount;
    private final long prizePrice;

    WinType(final int matchCount, final long prizePrice) {
        this.matchCount = matchCount;
        this.prizePrice = prizePrice;
    }

    public static WinType valueOf(final int matchCount, final boolean matchBonus) {
        if (!map.containsKey(matchCount)) {
            return WinType.OUT;
        }

        if (bonusWinType.matchCount(matchCount) && matchBonus) {
            return WinType.FIVE_WITH_BONUS;
        }

        return map.get(matchCount);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치%s (%d원)", matchCount, bonusMessage(), prizePrice);
    }

    private String bonusMessage() {
        return this == WinType.FIVE_WITH_BONUS ? ", 보너스 볼 일치" : "";
    }

    public Money calculatePrize(final int count) {
        return new Money(prizePrice * count);
    }

    public boolean isWin() {
        return this != WinType.OUT;
    }

    private boolean matchCount(final int matchCount) {
        return this.matchCount == matchCount;
    }
}
