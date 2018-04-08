package LottoGame;

/**
 * Created by hongjong-wan on 2018. 4. 8..
 */
public enum Match {
    THREE(3, 5000, "3개 일치 (5000원)- "),
    FOUR(4, 50000, "4개 일치 (50000원)- "),
    FIVE(5, 1500000, "5개 일치 (1500000원)- "),
    SIX(6, 2000000000, "6개 일치 (2000000000원)- ");

    private int matchCount;
    private int price;
    private String message;

    Match(int matchCount, int price, String message) {
        this.matchCount = matchCount;
        this.price = price;
        this.message = message;
    }

    public static Match ofMatch(int matchCount) {
        Match[] matches = values();
        for (Match match : matches) {
            if (match.matchCount == matchCount) {
                return match;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public int calculatePrice(int count) {
        return count * price;
    }
}
