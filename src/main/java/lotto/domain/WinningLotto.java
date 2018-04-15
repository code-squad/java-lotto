package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public boolean matchBonusNumber(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
