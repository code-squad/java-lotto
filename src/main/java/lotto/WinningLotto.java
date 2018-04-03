package lotto;

public class WinningLotto {
    private Lotto winningLotto;
    private String bonusNum;

    public WinningLotto(String winningNumber, String bonusNumber) {
        Lotto winnigLotto = new Lotto(winningNumber);
        String bonusNum = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public String getBonusNum() {
        return bonusNum;
    }
}
