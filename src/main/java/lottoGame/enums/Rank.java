package lottoGame.enums;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public String resultString() {
        if(this.equals(Rank.SECOND)) {
            return this.countOfMatch + "개 일치, 보너스볼 일치 (" + winningMoney + "원) : ";
        }
        return  this.countOfMatch + "개 일치 (" + winningMoney + "원) : ";
    }
}
