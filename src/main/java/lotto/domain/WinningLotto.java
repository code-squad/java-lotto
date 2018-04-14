package lotto.domain;

import java.util.List;
import java.util.Set;

/**
 * @author sangsik.kim
 */
public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("INVALID WINNING NUMBERS");
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(Lotto.of(winningNumbers), LottoNumber.of(bonusNumber));
    }

    public static WinningLotto of(Lotto winningLotto, LottoNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public boolean contains(LottoNumber number) {
        return this.winningLotto.contains(number);
    }

    public Boolean matchBonusNumber(Set<LottoNumber> numbers) {
        return numbers.contains(this.bonusNumber);
    }
}
