package domain;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        if (lotto.isContainNumber(bonusNumber) || Lotto.isOutRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException("유효한 보너스번호가 아닙니다.");
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int match(Lotto otherLotto) {
        return lotto.match(otherLotto);
    }

    public boolean matchBonus(Lotto otherLotto) {
        return otherLotto.isContainNumber(bonusNumber);
    }

    @Override
    public String toString() {
        return "WinningLotto{" + "lotto=" + lotto.toString() + ", bonusNumber=" + bonusNumber + '}';
    }
}
