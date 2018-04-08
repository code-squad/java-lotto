package lotto.domain;

/**
 * @author sangsik.kim
 */
public enum WinningTier {
    FOURTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000);

    private Integer equalNumbersCount;
    private Integer prizeAmount;

    WinningTier(Integer equalNumbersCount, Integer prizeAmount) {
        this.equalNumbersCount = equalNumbersCount;
        this.prizeAmount = prizeAmount;
    }

    public Integer getEqualNumbersCount() {
        return this.equalNumbersCount;
    }

    public Integer getPrizeAmount() {
        return this.prizeAmount;
    }
}
