package enums;

import java.util.Arrays;

/**
 * Created by hoon on 2018. 1. 17..
 */
public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private Integer matched;
    private Integer money;

    private Rank(Integer matched, Integer money) {
        this.matched = matched;
        this.money = money;
    }

    public Integer getMatched() {
        return matched;
    }

    public Integer getMoney() {
        return money;
    }

    public static Rank valueOf(int matched) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matched == matched)
                .findFirst()
                .orElse(Rank.MISS);
    }

}
