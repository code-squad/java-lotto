package lotto.domain;

/**
 * @author sangsik.kim
 */
public enum Rank {
    FIRST(6, 2000000000, "6개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1500000, "5개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    FIFTH(3, 5000, "3개 일치"),
    MISS(0, 0, "낙첨");

    private int countOfMatch;
    private int winningMoney;
    private String description;

    Rank(int countOfMatch, int winningMoney, String description) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.description = description;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

    public String getDescription() {
        return this.description;
    }

    public static Rank valueOf(Integer countOfMatch, Boolean matchBonus) {
        for (Rank rank : values()) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }
            if (countOfMatch == rank.countOfMatch) {
                return rank;
            }
        }
        return MISS;
    }
}
