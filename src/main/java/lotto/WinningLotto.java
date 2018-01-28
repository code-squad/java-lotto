package lotto;

/**
 * Created by Joeylee on 2018-01-19.
 */
public class WinningLotto {
    private Lotto lotto;
    private LottoNo bonusNumber;

    public WinningLotto(Lotto lotto, LottoNo bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }

    public Rank getRankmatchCountAndMatchBonus(Lotto buyLotto) {
        int numOfMatchCount = buyLotto.countMatchingAnswer(lotto);
        boolean matchBonusNum = buyLotto.isBouseMatch(bonusNumber);

        return Rank.valueOf(numOfMatchCount, matchBonusNum);
    }

    public static WinningLotto createWinningLotto(Lotto lotto, LottoNo bonusNumber) {
        if(lotto.getLottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("로또번호와 보너스 볼이 겹칩니다");
        }
        return new WinningLotto(lotto, bonusNumber);
    }

}
