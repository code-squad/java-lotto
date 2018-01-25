package lotto;

/**
 * Created by Joeylee on 2018-01-18.
 */
public enum Rank {

    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getProfit(int numOfLotto){
        return this.winningMoney * numOfLotto;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if(matchBonus && countOfMatch == SECOND.countOfMatch) {
            return SECOND;
        }
        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            if(rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }

        return null;
    }

    public String getState(int numOfMatchLotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.countOfMatch).append("개 일치")
            .append(this.equals(Rank.SECOND) ? ", 보너스 볼 일치 (" : " (")
            .append(this.winningMoney).append("원)- ")
            .append(numOfMatchLotto).append("개\n");

        return sb.toString();
    }


}
