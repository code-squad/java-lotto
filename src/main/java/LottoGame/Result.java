package LottoGame;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class Result {

    private Rank rank;
    private int count;

    public Result(Rank rank) {
        this.rank = rank;
    }

    public int calculateReward() {
        return rank.calculateReward(count);
    }

    public void plusCount() {
        count++;
    }

    public boolean equal(Rank rank) {
        if (this.rank == rank) {
            return true;
        }
        return false;
    }

    public Rank getRank() {
        return rank;
    }

    public int getCount() {
        return count;
    }
}