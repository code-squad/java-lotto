package lotto.domain;

import java.util.function.Predicate;
import java.util.stream.Stream;

public enum LottoRank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000), // in case of having lucky number
    JACKPOT(6, 2000000000),
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

    public static LottoRank getLottoRank(int count, boolean bonusNumber) {
        count = modifyCount(count);
        if (!hasCount(count)) throw new IllegalArgumentException();
        return Stream.of(LottoRank.values())
                .filter(sameCount(count).and(ifCountEquals5(count, bonusNumber)))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static boolean hasCount(int count) {
        return Stream.of(LottoRank.values()).anyMatch(sameCount(count));
    }

    private static int modifyCount(int count) {
        if (count < LottoRank.FIFTH.matchingCount) {
            count = LottoRank.REST.matchingCount;
        }
        return count;
    }

    private static Predicate<LottoRank> ifCountEquals5(int count, boolean bonusNumber) {
        return rank -> count != 5 ? true : bonusNumber ? rank.equals(LottoRank.SECOND) : rank.equals(LottoRank.THIRD);
    }

    private static Predicate<LottoRank> sameCount(int count) {
        return rank->rank.matchingCount == count;
    }
}
