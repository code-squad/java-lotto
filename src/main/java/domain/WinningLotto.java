package domain;

import java.util.List;

public class WinningLotto {

  private Lotto lotto;
  private LottoNumber bonusNumber;

  public WinningLotto(Lotto lotto, int bonusNumber) {
    this.lotto = lotto;
    if (isContainLottoNumber(bonusNumber)) {
      throw new IllegalArgumentException("this bonusNumber contains lotto numbers.");
    }
    this.bonusNumber = new LottoNumber(bonusNumber);
  }

  public boolean isBonusNumber(int bonusNumber) {
    return this.bonusNumber.isEqualNumber(bonusNumber);
  }

  private boolean isContainLottoNumber(int bonusNumber) {
    return lotto.getNumbers().contains(new LottoNumber(bonusNumber));
  }

  public List<LottoNumber> getNumbers() {
    return lotto.getNumbers();
  }
}
