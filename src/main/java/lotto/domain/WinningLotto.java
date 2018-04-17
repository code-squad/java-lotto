package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(LottoNumber number) {
        return winningNumbers.contains(number);
    }

    public boolean matchBonusNumber(List<LottoNumber> numbers) {
        return numbers.contains(bonusNumber);
    }
}
