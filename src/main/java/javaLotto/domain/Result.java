package javaLotto.domain;

public class Result {
    private Rank rank;

    public Result(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }


    public static int returnMoney(Result result) {
        return result.getRank().getWinningMoney();
    }
}
