package lotto.domain;

import java.util.Objects;

public class WinningNumbers {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningNumbers(String lottoNumbers, int bonusNumber) {
        winningLotto = Lotto.winningLotto(lottoNumbers);
        if(winningLotto.isContainBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.bonusNumber = LottoNumber.ofInteger(bonusNumber);
    }

    public int compare(Lotto lotto) {
        return lotto.compare(winningLotto);
    }

    @Override
    public String toString() {
        return "WinningNumbers{" +
                "lotto=" + winningLotto +
                ", bonusNumber=" + bonusNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningLotto, that.winningLotto) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }
}
