package lotto.lotto.domain;

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

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getTotalWinnerPrize(int count){
        return this.winningMoney*count;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        for (Rank lotto : Rank.values()) {
            if (countOfMatch == SECOND.countOfMatch) {
                return matchBonus ? SECOND : THIRD;
            }
            if (lotto.countOfMatch == countOfMatch) {
                return lotto;
            }
        }
        return null;
    }
}
