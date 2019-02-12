package lotto.domain;

import java.io.PipedReader;
import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public Rank matchNum(List<Integer> prize, int bonus) {
        if(matchList(prize).size() <3){
            return Rank.valueOf(0, bonusCheck(prize, bonus));
        }


        return Rank.valueOf(matchList(prize).size(), bonusCheck(prize, bonus));
    }

    public int winnerMoney(List<Integer> prize, int bonus){
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
        if (!matchList(prize).contains(bonus) && matchList(prize).size() == 5) {
            if (lotto.contains(bonus)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + lotto + "";
    }
}