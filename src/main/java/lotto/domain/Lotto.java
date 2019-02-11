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

    public int matchNum(List<Integer> prize) {
        if(matchList(prize).size() < 3){
            return 0;
        }

       return matchList(prize).size();
    }

    public List<Integer> matchList(List<Integer> prize){
        List<Integer> match = new ArrayList<>();
        for (Integer integer : lotto) {
            if(prize.contains(integer)) {
                match.add(integer);
            }
        }
        return match;
    }

    public boolean bonusCheck(List<Integer> prize, int bonus){
        if(!matchList(prize).contains(bonus) && matchList(prize).size() == 5){
            if(lotto.contains(bonus)){
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