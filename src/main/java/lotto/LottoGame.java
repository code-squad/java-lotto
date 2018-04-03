package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Integer> allCounts;
    private List<Integer> winCounts;

    public List<Integer> match(List<Lotto> lottos, Lotto winningNumber) {
        allCounts = new ArrayList<>();
        for (Lotto lotto: lottos) {
            allCounts.add(lotto.countNumber(winningNumber));
        }
        return allCounts;
    }

    public int getCount(List<Integer> counts, int matchNumber) {
        int numberCount = 0;
        for(int i = 0; i < counts.size(); i++) {
            if(counts.get(i) == matchNumber)
                numberCount++;
        }
        return numberCount;
    }

    public List<Integer> getWinCounts(List<Integer> counts) {
        winCounts = new ArrayList<>();
        for(int i = 3; i < 7; i++)
            winCounts.add(getCount(counts, i));
        return winCounts;
    }
}
