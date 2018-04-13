package lotto.domain;

import org.apache.commons.lang3.StringUtils;

public enum Rank {
    FIRST(6, 2_000_000_000),
    BONUS(5, 30_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    BLANK(0, 0);

    private final int matchCount;
    private final long prizeMoney;

    Rank(int matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public long totalPrizeMoney(int count) {
        return prizeMoney * count;
    }

    public static Rank valueOf(int matchCount, boolean bonus) {
        if (bonus && BONUS.matchCount == matchCount) {
            return BONUS;
        }

        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return BLANK;
    }

    public String print(int count) {
        String bonusText = " ";
        if(StringUtils.equals(this.name(), Rank.BONUS.name())) {
            bonusText = ", 보너스 볼 일치";
        }
        return matchCount + "개 일치" + bonusText + "(" + prizeMoney + "원) - " + count + "개";
    }
}
