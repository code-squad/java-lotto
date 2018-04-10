package LottoGame;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public class Result {

    private Match match;
    private int count;

    public Result(Match match) {
        this.match = match;
    }

    public boolean equalMatchValue(Match match) {
        return this.match == match;
    }

    public int calculatePrice() {
        return match.calculatePrice(count);
    }

    public void plusCount() {
        count++;
    }

    public Match getMatch() {
        return match;
    }

    public int getCount() {
        return count;
    }

}