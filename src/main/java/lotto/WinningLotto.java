package lotto;

public class WinningLotto {
    private Lotto winningLotto;
    private String bonusNum;

    public WinningLotto(String winningNumber, String bonusNumber) {
        winningLotto = new Lotto(winningNumber);
        bonusNum = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public String getBonusNum() {
        return bonusNum;
    }
}
