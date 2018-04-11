package lotto.domain;

import java.util.List;

/**
 * @author sangsik.kim
 */
public class WinningLotto {
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    public boolean contains(Integer number) {
        return this.winningNumbers.contains(number);
    }
}
