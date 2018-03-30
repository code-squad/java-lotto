package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto of(String lotto) {
        return new Lotto(Parse.parse(lotto));
    }

    public static Lotto automaticLotto() {
        return new Lotto(LottoUtils.createLotto());
    }

    public Rank valueOfRank(WeeklyLotto weeklyLotto) {     //당첨번호와 비교한다.
        List<Integer> winningLotto = weeklyLotto.getWinningLotto();
        int bonusBall = weeklyLotto.getBonusBall();
        int collectNum = coutOfMatchLotto(winningLotto);
        boolean matchBonus = collectBonusBall(bonusBall);

        return Rank.valueOf(collectNum, matchBonus);
    }

    public int coutOfMatchLotto(List<Integer> winningLotto) {
        int collectNum = 0;
        for (Integer num : winningLotto) {
            collectNum = collectNumber(num, collectNum);
        }
        return collectNum;
    }

    public int collectNumber(int num, int collectNum) {   //당첨번호가 포함되있으면 +1
        if (lotto.contains(num)) {
            return collectNum + 1;
        }
        return collectNum;
    }

    public boolean collectBonusBall(int bonusBall) {
        if (lotto.contains(bonusBall)) {
            return true;
        }
        return false;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}