package lotto;

public class WinningLotto {
    private Lotto winningNumber;
    private int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.winningNumber = winningNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
