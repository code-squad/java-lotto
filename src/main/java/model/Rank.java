package model;

import lombok.Getter;

@Getter
public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Rank[] ranks = Rank.values();
        Rank pick = null;
        if (countOfMatch == 5 && matchBonus){
            pick = Rank.SECOND;
        }

        for (Rank rank : ranks) {
            if (rank.getCountOfMatch() == countOfMatch){
                pick = rank;
            }
        }
        return pick;
    }
}
