package lotto.domain;

import java.util.List;

/**
 * @author sangsik.kim
 */
public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    public boolean contains(LottoNumber number) {
        return this.winningNumbers.contains(number);
    }
}
