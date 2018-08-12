package lotto;

public class WinLotto {
    private Lotto winLotto;
    private LottoNo bonusNumber;    //LottoNo를 사용하면 Range Check가 불필요하다.

    public WinLotto(Lotto winLotto, int bonusNumber){
        LottoNo bunusLottoNo = new LottoNo(bonusNumber);
        if(winLotto.contains(bunusLottoNo)){
            throw new IllegalArgumentException();
        }
        this.winLotto = winLotto;
        this.bonusNumber = new LottoNo(bonusNumber);
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }

}
