package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Integer> counts;
    private Lotto lotto;

    public List<Integer> match(List<Lotto> lottos, Lotto winningNumber) {
        counts = new ArrayList<>();
        for (Lotto lotto: lottos) {
            counts.add(countNumber(lotto, winningNumber));
        }
        return counts;
    }

    public Integer countNumber(Lotto lotto, Lotto winningNumber) {
        int count = 0;
        for(int i = 0; i < winningNumber.getLotto().size(); i++) {
            if (lotto.getLotto().contains(winningNumber.getLotto().get(i)))
                count++;
        }
        return count;
    }

    public int getCount(List<Integer> counts, int matchNumber) {
        int numberCount = 0;
        for(int i = 0; i < counts.size(); i++) {
            if(counts.get(i) == matchNumber)
                numberCount++;
        }
        return numberCount;
    }
}
