package lotto.lotto.domain;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WeeklyLotto {

    private List<Integer> winningLotto;

    public WeeklyLotto(String winningLotto) {
        this.winningLotto = Parse.parse(winningLotto);   //파싱, 예외체크 후 생성
    }

    public HashMap<Rank, Integer> initRank() {
        HashMap<Rank, Integer> numberOfRank = new HashMap<>();
        for (Rank r : Rank.values()) {
            numberOfRank.put(r, 0);
        }
        return numberOfRank;
    }

    public HashMap<Rank, Integer> checkRank(List<Lotto> lottos) {  //등수를 확인한다.
        HashMap<Rank, Integer> numberOfRank = initRank();
        for (Lotto oneLotto : lottos) {
            Rank value = oneLotto.coutOfMatchLotto(this);
            putRank(numberOfRank, value);
        }
        return numberOfRank;
    }

    public void putRank(HashMap<Rank, Integer> numberOfRank, Rank value) {
        if (value != null) {
            numberOfRank.put(value, numberOfRank.get(value) + 1);
        }
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }
}
