package domain;

public class WinningLotto {
    private Lotto winLotto;
    private No bonusNum;

    private WinningLotto(Lotto winLotto, No bonusNum) {
        this.winLotto = winLotto;
        this.bonusNum = bonusNum;
    }

    public static WinningLotto init(Lotto winLotto, No bonusNum) {
        return new WinningLotto(winLotto, bonusNum);
    }

    public Rank compareWinLottoNum(Lotto lotto) {
        return Rank.findMatchRank(this.winLotto.compareLottoNumbs(lotto), lotto.checkBonusNum(this.bonusNum));
    }

}
