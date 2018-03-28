package domain.result;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int matchPoint;
    private int prize;

    Rank(int matchPoint, int prize) {
        this.matchPoint = matchPoint;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchPoint() {
        return matchPoint;
    }

    private boolean isMatchPoint(int matchPoint) {
        return this.matchPoint == matchPoint;
    }

    public static Rank of(int matchPoint) {
        Rank searchRank = null;
        for (Rank rank : Rank.values()) {
            if (rank.isMatchPoint(matchPoint)) {
                searchRank = rank;
                break;
            }
        }
        return searchRank;
    }

    public static Rank of(boolean isBonusMatch) {
        if (isBonusMatch) {
            return SECOND;
        }
        return THIRD;
    }

    public static boolean isNotRank(int matchPoint) {
        return Rank.of(matchPoint) == null;
    }

    public static boolean isBonusSituation(int matchPoint) {
        return Rank.SECOND.matchPoint == matchPoint;
    }

    public static String buildRankMessage(LottoResults results) {
        List<Rank> ranks = Arrays.asList(Rank.values());
        StringBuilder builder = new StringBuilder();
        for (Rank rank : ranks) {
            builder.append(doBuild(rank, results));
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String doBuild(Rank rank, LottoResults results) {
        return rank.matchPoint + "개 일치 (" + rank.prize + ") - " + results.calcRankNum(rank) + "개";
    }

    @Override
    public String toString() {
        return "Rank{" +
                "matchPoint=" + matchPoint +
                ", prize=" + prize +
                '}';
    }
}

