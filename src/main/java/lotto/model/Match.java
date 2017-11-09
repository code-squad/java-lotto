package lotto.model;

public enum Match {
    MATCH3(3, 5000),
    MATCH4(4, 50000),
    MATCH5(5, 1500000),
    MATCH6(6, 2000000000);
    
    private int countOfMatch;
    private int winningMoney;

    private Match(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Match valueOf(int countOfMatch) {
        Match[] values = values();
        for (Match match : values) {
            if (match.countOfMatch == countOfMatch) {
                return match;
            }
        }
        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    long winningMoney(int countOfMatchingLotto) {
        return winningMoney * countOfMatchingLotto;
    }
    
    public int getCountOfMatch() {
        return countOfMatch;
    }
    
    public int getWinningMoney() {
        return winningMoney;
    }
}