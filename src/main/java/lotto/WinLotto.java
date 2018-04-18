package lotto;

public class WinLotto {
    private Lotto winLotto;
    private int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber){

        if (bonusNumber < 1) {
            throw new IllegalArgumentException();
        }

        LottoNo bunusLottoNo = new LottoNo(bonusNumber);

        if(winLotto.contains(bunusLottoNo)){
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

    public boolean contain(Integer number) {
        LottoNo lottoNo = new LottoNo(number);
        return winLotto.contains(lottoNo);
    }
}
