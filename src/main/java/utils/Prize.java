package utils;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int matchPoint;
    private int prize;

    Prize(int matchPoint, int prize) {
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

    public static Prize of(int matchPoint) {
        Prize searchPrize = null;
        for (Prize prize : Prize.values()) {
            if (prize.isMatchPoint(matchPoint)) {
                searchPrize = prize;
                break;
            }
        }
        return searchPrize;
    }

    public static int getSize() {
        return Prize.values().length;
    }
}

