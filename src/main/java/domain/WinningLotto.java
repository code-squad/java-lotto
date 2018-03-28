package domain;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
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
