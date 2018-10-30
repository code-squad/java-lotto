package utils;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THRID(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int countOfStrike;
    private int winningMoney;

    private Rank(int countOfStrike, int winningMoney) {
        this.countOfStrike = countOfStrike;
        this.winningMoney = winningMoney;
    }

    public static int findWinningMoney(Rank rank) {
        return Arrays.stream(values())
                .filter(aRank -> aRank == rank)
                .findAny().get().winningMoney;
    }

    public int getCountOfStrike() {
        return countOfStrike;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int strikePoint, boolean strikeBonus) {
        return Arrays.stream(values())
                .filter(rank -> strikePoint == SECOND.countOfStrike ? decideSecond(rank, strikeBonus) : rank.countOfStrike == strikePoint)
                .findAny()
                .orElse(null);
    }

    private static boolean decideSecond(Rank rank, boolean strikeBonus) {
        if (strikeBonus) {
            return rank == SECOND;
        }
        return rank == THRID;
    }
}

