package domain;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    // TODO : 보너스 넘버 체킹
    public int match(Lotto otherLotto) {
        return lotto.match(otherLotto);
    }

    @Override
    public String toString() {
        return "WinningLotto{" + "lotto=" + lotto.toString() + ", bonusNumber=" + bonusNumber + '}';
    }
}
