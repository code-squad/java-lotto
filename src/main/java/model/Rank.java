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
        Rank pickOne = null;

        switch (countOfMatch){
            case 6:
                pickOne = FIRST;
                break;
            case 5:
                if(matchBonus){
                    pickOne = SECOND;
                    break;
                }
                pickOne = THIRD;
                break;
            case 4:
                pickOne = FOURTH;
                break;
            case 3:
                pickOne =FIFTH;
                break;
        }

        return pickOne;
    }
}
