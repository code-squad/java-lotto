package lotto.domain;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum LottoRank {
    JACKPOT(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    REST(9999,0);

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

    public static LottoRank getLottoRank(int count) {
        if (!hasCount(count)) throw new IllegalArgumentException();
        return Stream.of(LottoRank.values()).filter(sameCount(count)).findFirst().get();
    }

    private static boolean hasCount(int count) {
        return Stream.of(LottoRank.values()).anyMatch(sameCount(count));
    }

    private static Predicate<LottoRank> sameCount(int count) {
        return rank->rank.matchingCount == count;
    }
}
