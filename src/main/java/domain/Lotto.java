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

    public Rank matchedLotto(WinningNum winningNum) {
        List<Integer> winningLotto = winningNum.getPreWinNums();
        int count = 0;

        for (Integer num : winningLotto) {
            count = countMatchedNumbs(num, count);
        }
        return Rank.valueOf(count);
    }

    private int countMatchedNumbs(int num, int count) {
        if (lotto.contains(num)) {
            return ++count;
        }
        return count;
    }
}
