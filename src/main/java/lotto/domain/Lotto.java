package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto extends Exception{

    private List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto){
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public int matchNum (List<Integer> prize){
        int match = 0;
        for (Integer integer : prize) {
            if(lotto.contains(integer)){
                match++;
            }
        }

        if(match < 3){
            return 0;
        }
        return match;
    }

    @Override
    public String toString() {
        return "" + lotto + "";
    }
}