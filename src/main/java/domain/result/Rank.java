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

    public static Rank of(int matchPoint, boolean isBonusMatch) {
        if (isNotRank(matchPoint)) {
            return null;
        }
        return searchRank(matchPoint, isBonusMatch);
    }

    private static Rank searchRank(int matchPoint, boolean isBonusMatch) {
        if (isBonusSituation(matchPoint)) {
            return isBonusMatch ? Rank.SECOND : Rank.THIRD;
        }
        return Arrays.stream(Rank.values()).filter(rank -> rank.matchPoint == matchPoint).findFirst().get();
    }

    private static boolean isNotRank(int matchPoint) {
        return Arrays.stream(Rank.values()).map(rank -> rank.matchPoint).noneMatch(rankMatchPoint -> rankMatchPoint == matchPoint);
    }

    private static boolean isBonusSituation(int matchPoint) {
        return matchPoint == 5;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "matchPoint=" + matchPoint +
                ", prize=" + prize +
                '}';
    }
}

