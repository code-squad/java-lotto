package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sangsik.kim
 */
public class WinningLotto {
    private List<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers.stream()
                .mapToInt(Integer::intValue)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    public boolean contains(LottoNumber number) {
        return this.winningNumbers.contains(number);
    }
}
