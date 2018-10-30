package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public int checkRank(Lotto lotto) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.isContains(this.lotto.get(i))) cnt++;
        }
        return cnt;
    }

    private boolean isContains(int number) {
        return this.lotto.contains(number);
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
