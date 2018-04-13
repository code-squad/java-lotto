package lotto;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public enum Prize {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    private static Map<Integer, Prize> prizeMap = Arrays.stream(Prize.values()).collect(toMap(o -> o.matchCount, o -> o));
    private final int matchCount;
    private final int money;

    Prize(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public static Prize findPrize(int matchCount) {
        return prizeMap.getOrDefault(matchCount, null);
    }
}