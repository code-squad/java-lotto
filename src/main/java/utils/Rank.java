package utils;

import static utils.LottoGameValues.*;

public enum Rank {
    FIFTH(3, THREE_MATCH_PRIZE),
    FOURTH(4, FOUR_MATCH_PRIZE),
    THRID(5, FIVE_MATCH_PRIZE),
    SECOND(5, FIVE_MATCH_BONUS_PRIZE),
    FIRST(6, SIX_MATCH_PRIZE);

    private int countOfStrike;
    private int winningMoney;

    private Rank(int countOfStrike, int winningMoney) {
        this.countOfStrike = countOfStrike;
        this.winningMoney = winningMoney;
    }

    public boolean isEqual(int target) {
        return countOfStrike == target;
    }

    public int getCountOfStrike() {
        return countOfStrike;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int strikePoint, boolean strikeBonus) {
        for (Rank rank : values()) {
            if (strikePoint == SECOND.countOfStrike) {
                return strikeBonus ? SECOND : THRID;
            }

            if (rank.isEqual(strikePoint)) {
                return rank;
            }
        }
        return null;
    }
}

