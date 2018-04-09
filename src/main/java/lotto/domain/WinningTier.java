package lotto.domain;

/**
 * @author sangsik.kim
 */
public enum WinningTier {
    FAIL(0, 0), FOURTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000);

    private Integer value;
    private Integer prize;

    WinningTier(Integer value, Integer prize) {
        this.value = value;
        this.prize = prize;
    }

    public Integer equalCount() {
        return this.value;
    }

    public Integer prizeAmount() {
        return this.prize;
    }

    public static WinningTier get(Integer value) {
        switch (value) {
            case 6:
                return FIRST;
            case 5:
                return SECOND;
            case 4:
                return THIRD;
            case 3:
                return FOURTH;
            default:
                return FAIL;
        }
    }
}
