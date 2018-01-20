package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int mulMoney(int count) {
        return count * winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (matchBonus && checkCount(SECOND, countOfMatch)) {
            return SECOND;
        }
        Rank[] ranks = Rank.values();

        return Arrays.stream(ranks)
                .filter(rank -> rank != SECOND && checkCount(rank, countOfMatch))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private static boolean checkCount(Rank rank, int countOfMatch) {
        return rank.countOfMatch == countOfMatch;
    }

    public int compare(Rank rank) {
        return countOfMatch - rank.countOfMatch;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(countOfMatch);
        sb.append("개 일치 (");
        if (this == Rank.SECOND) {
            sb.delete(sb.length() - 2, sb.length());
            sb.append(", 보너스 볼 일치(");
        }
        sb.append(winningMoney);
        sb.append("원) - ");
        return sb.toString();
    }
}
