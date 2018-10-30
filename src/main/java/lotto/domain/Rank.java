package lotto.domain;

import java.util.Arrays;

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

    public int getCountOfMatch(){
        return countOfMatch;
    }

    public int getWinningMoney(){
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus){
        return Arrays.stream(values())
                .filter(rank -> countOfMatch == SECOND.countOfMatch  ? (matchBonus? rank == Rank.SECOND : rank == Rank.THIRD)  : countOfMatch == rank.countOfMatch)
                .findFirst()
                .orElse(null);

//        for (Rank rank : values()) {
//            if(countOfMatch == SECOND.countOfMatch){
//                return matchBonus ? SECOND : THIRD;
//            }
//
//            if(rank.countOfMatch == countOfMatch){
//                return rank;
//            }
//        }
//        return null;
    }
}
