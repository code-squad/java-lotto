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




    // TODO : 얘가 여기없으면 랭크 정보 등은 다 get 해야하나?
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

