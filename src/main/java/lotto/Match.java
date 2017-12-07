package lotto;

public enum Match {
    MATCH3(3, false, 5000, "(5등) 3개 일치 (5000원) : "),
    MATCH4(4, false, 50000, "(4등) 4개 일치 (50000원) : "),
    MATCH5(5, false, 1500000, "(3등) 5개 일치 (1500000원) : "),
    MATCH5_2(5, true, 30000000, "(2등) 5개 일치 + 보너스번호 일치 (30000000원) : "),
    MATCH6(6, false, 2000000000, "(1등) 6개 일치 (2000000000원) : ");

    private int countOfMatch;
    private boolean bonusRight;
    private int winningMoney;
    private String message;
    
    //생성자.
    private Match(int countOfMatch, boolean bonusRight, int winningMoney, String message) {
        this.countOfMatch = countOfMatch;
        this.bonusRight = bonusRight;
        this.winningMoney = winningMoney;
        this.message = message;
    }
    //match값을 반환해주는 메소드. 맞은 값의 수와 보너스 번호 일치 여부를 가지고 일치하는 match를 반환해주는 메소드.
    public static Match valueOf(int countOfMatch, boolean bonusRight) {
        Match[] values = values();
        for (Match match : values) {
            if (match.countOfMatch == countOfMatch && match.bonusRight == bonusRight) {
                return match;
            }
        }
        return null;
    }
    //몇 개 맞았는지 리턴.
    public int getCountOfMatch() {
        return countOfMatch;
    }
    //보너스 번호가 맞았는지 리턴.
    public boolean getBonusResult() {
    		return bonusRight;
    }
    //상금을 리턴.
    public int getWinningMoney() {
        return winningMoney;
    }
    //등수(당첨 등수) 메세지 리턴.
    public String getWinningMsg() {
    		return message;
    }
}
