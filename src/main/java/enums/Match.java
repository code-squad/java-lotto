package enums;

import java.util.Arrays;

/**
 * Created by hoon on 2018. 1. 17..
 */
public enum Match {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private Integer matched;
    private Integer money;

    private Match(Integer matched, Integer money) {
        this.matched = matched;
        this.money = money;
    }

    public Integer getMatched() {
        return matched;
    }

    public Integer getMoney() {
        return money;
    }

    public static Match valueOf(int matched) {
        return Arrays.stream(Match.values())
                .filter(match -> match.matched == matched)
                .findFirst()
                .orElse(Match.ZERO);
    }

}
