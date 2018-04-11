package LottoGame;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public enum Rank {
    FIRST(6, 2000000000, "6개 일치 (2000000000원)- "),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치(30000000원)- "),
    THIRD(5, 1500000, "5개 일치 (1500000원)- "),
    FOURTH(4, 50000, "4개 일치 (50000원)- "),
    FIFTH(3, 5000, "3개 일치 (5000원)- ");

    private int countOfMatch;
    private int winningMoney;
    private String message;

    Rank(int countOfMatch, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (rank.countOfMatch == countOfMatch) {
                return getRank(rank, matchBonus);
            }
        }
        return null;
    }

    public static Rank getRank(Rank rank, boolean matchBonus) {
        if(rank == Rank.SECOND) {
            if(matchBonus) { return Rank.SECOND; }
            return Rank.THIRD;
        }
        return rank;
    }

    public int calculateReward(int count) {
        return this.winningMoney * count;
    }

    public String getMessage() {
        return message;
    }
}