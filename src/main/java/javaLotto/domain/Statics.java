package javaLotto.domain;

public class Statics {
    private int count;
    private Rank rank;


    public Statics(Rank rank, Integer count) {
        this.rank = rank;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Rank getRank() { return rank;}

    public static int printMatch(Statics info) {
        return info.getRank().getCountOfMatch();
    }

    public static int printMoney(Statics info) {
        return info.getRank().getWinningMoney();
    }

    public static int printCount(Statics info) {
        return info.getCount();
    }
}
