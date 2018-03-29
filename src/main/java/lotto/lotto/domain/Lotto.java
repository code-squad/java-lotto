package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    private Rank value = null;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public Lotto() {
        this(LottoUtils.createLotto());
    }

    public Rank coutOfMatchLotto(List<Integer> winningLotto) {     //당첨번호와 비교한다.
        int collectNum = 0;
        for (Integer num : winningLotto) {
            collectNum = collectNumber(num, collectNum);
        }
        return rankCheck(collectNum);
    }

    public Rank rankCheck(int collectNum) {
        return Rank.valueOf(collectNum);
    }

    public int collectNumber(int num, int collectNum) {   //당첨번호가 포함되있으면 +1
        if (lotto.contains(num)) {
            return collectNum + 1;
        }
        return collectNum;
    }

    public Rank getValue() {
        return value;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}