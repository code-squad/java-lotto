package domain;

import java.util.List;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Lotto winningNumbers, LottoNumber bonusNumber) {
        checkIsNotNull(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers.getNumbers();
        this.bonusNumber = bonusNumber;
        checkWinningNumbersContainBonusNumber();
    }

    private void checkIsNotNull(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (bonusNumber == null || winningNumbers == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkWinningNumbersContainBonusNumber() {
        if (this.contain(this.bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contain(LottoNumber number) {
        return winningNumbers.stream()
                             .anyMatch(i -> i.equals(number));
    }

    public boolean isMatchBonus(LottoNumber number) {
        return bonusNumber.equals(number);
    }
}
