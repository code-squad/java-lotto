package lotto;

public class WinLotto {
    private Lotto winLotto;
    int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber){

        if (bonusNumber < 1) {
            throw new IllegalArgumentException();
        }

        if(winLotto.getLotto().contains(bonusNumber)){
            throw new IllegalArgumentException();
        }

        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
