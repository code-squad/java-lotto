package domain;

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

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (matchBonus && countOfMatch == 5) {
            return SECOND;
        }
        if (countOfMatch == 6) {
            return FIRST;
        }
        if (countOfMatch == 5) {
            return THIRD;
        }
        if (countOfMatch == 4) {
            return FOURTH;
        }
        if (countOfMatch == 3) {
            return FIFTH;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(countOfMatch);
        sb.append("개 일치 (");
        if (this == Rank.SECOND) {
            sb.delete(sb.length() - 2, sb.length());
            sb.append(", 보너스 볼 일치(");
        }
        sb.append(winningMoney);
        sb.append("원) - ");
        return sb.toString();
    }
}
