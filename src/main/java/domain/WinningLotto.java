package domain;

import java.util.List;

public class WinningLotto extends Lotto {

  private LottoNumber bonusNumber;

  public WinningLotto(List<Integer> numbers, int bonusNumber) {
    super(numbers);
    this.bonusNumber = new LottoNumber(bonusNumber);
  }

  public boolean isBonusNumber(int bonusNumber) {
    return this.bonusNumber.isEqualNumber(bonusNumber);
  }
}
