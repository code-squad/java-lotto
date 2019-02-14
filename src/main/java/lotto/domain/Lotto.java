package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int FIFTH_RANK = 3;

    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public Rank matchNum(List<Integer> prize, int bonus) {
        if (matchList(prize).size() < FIFTH_RANK) {
            return Rank.valueOf(0, bonusCheck(prize, bonus));
        }
        return Rank.valueOf(matchList(prize).size(), bonusCheck(prize, bonus));
    }

    public int winnerMoney(List<Integer> prize, int bonus) {
        return matchNum(prize, bonus).getWinningMoney();
    }

    private List<Integer> matchList(List<Integer> prize) {
        List<Integer> match = new ArrayList<>();
        for (Integer integer : lotto) {
            if (prize.contains(integer)) {
                match.add(integer);
            }
        }
        return match;
    }

    public boolean bonusCheck(List<Integer> prize, int bonus) {
       return !matchList(prize).contains(bonus) && matchList(prize).size() == 5 && lotto.contains(bonus);
    }

    @Override
    public String toString() {
        return "" + lotto + "";
    }
}