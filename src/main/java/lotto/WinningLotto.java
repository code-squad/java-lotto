package lotto;

/**
 * Created by Joeylee on 2018-01-19.
 */
public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Rank getRankmatchCountAndMatchBonus(Lotto buyLotto) {
        int numOfMatchCount = buyLotto.countMatchingAnswer(lotto);
        boolean matchBonusNum = buyLotto.isBouseMatch(bonusNumber);

        return Rank.valueOf(numOfMatchCount, matchBonusNum);
    }


}
