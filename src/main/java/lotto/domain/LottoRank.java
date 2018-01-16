package lotto.domain;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum LottoRank {
    JACKPOT(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    REST(0,0);

    private int matchingCount;
    private int price;

    LottoRank(int matchingCount, int price) {
        this.matchingCount = matchingCount;
        this.price = price;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrice() {
        return price;
    }
}
