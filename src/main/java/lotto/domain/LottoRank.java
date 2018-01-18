package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoRank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000), // in case of having lucky number
    JACKPOT(6, 2000000000),
    REST(0,0);

    private final static int MIGHT_BE_HAVING_BONUS = 5;
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

    public static LottoRank getLottoRank(int matchingCount, boolean bonusNumber) {
        matchingCount = modifyCount(matchingCount);
        if (!hasCount(matchingCount)) throw new IllegalArgumentException();
        return getFirst(equalList(matchingCount), bonusNumber);
    }

    private static LottoRank getFirst(List<LottoRank> lottoRanks, boolean bonusNumber) {
        if (lottoRanks.get(0).matchingCount != MIGHT_BE_HAVING_BONUS) return lottoRanks.get(0);
        return lottoRanks.stream().filter(whichOneHas(bonusNumber)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    private static List<LottoRank> equalList(int count) {
        return Stream.of(LottoRank.values()).filter(sameCount(count)).collect(Collectors.toList());
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

    private static Predicate<LottoRank> whichOneHas(boolean bonusNumber) {
        return rank -> bonusNumber ? rank.equals(LottoRank.SECOND) : rank.equals(LottoRank.THIRD);
    }

    private static Predicate<LottoRank> sameCount(int count) {
        return rank -> rank.matchingCount == count;
    }
}
