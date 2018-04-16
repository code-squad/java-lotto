package domain;

import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public static Lotto buyingLottos() {
        return new Lotto(LottoNumGenerator.createLotto());
    }

    public Rank matchedLotto(WinningNum winningNum, int bonusBall) {
        List<Integer> winningLotto = winningNum.getPreWinNums();
        int count = 0;
        boolean checkBonusBall = false;
        for (Integer num : winningLotto) {
            count = countMatchedNumbs(num, count);
            checkBonusBall = checkForBonusBall(bonusBall);
        }
        return Rank.valueOf(count, checkBonusBall);
    }

    private int countMatchedNumbs(int num, int count) {
        if (lotto.contains(num)) {
            return ++count;
        }
        return count;
    }

    private boolean checkForBonusBall(int bonusBall) {
        return lotto.contains(bonusBall);
    }
}
