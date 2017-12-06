package lotto;

public enum Match {
    MATCH3(3, 5000, "3개 일치 (5000원) : "),
    MATCH4(4, 50000, "4개 일치 (50000원) : "),
    MATCH5(5, 1500000, "5개 일치 (1500000원) : "),
    MATCH6(6, 2000000000, "6개 일치 (2000000000원) : ");

    private int countOfMatch;
    private int winningMoney;
    private String message;

    private Match(int countOfMatch, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.message = message;
    }

    public static Match valueOf(int countOfMatch) {
        Match[] values = values();
        for (Match match : values) {
            if (match.countOfMatch == countOfMatch) {
                return match;
            }
        }
        return null;
    }
    
    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
    
    public String getWinningMsg() {
    	return message;
    }
}
