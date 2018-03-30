package lotto.lotto.domain;

import java.util.HashMap;
import java.util.List;

public class WeeklyLotto {

    private List<Integer> winningLotto;
    private int bonusBall;

    public WeeklyLotto(List<Integer> winningLotto, int bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WeeklyLotto of(String winningLotto, int bonusBall) {
        List<Integer> weeklyLotto = Parse.parse(winningLotto); //파싱, 예외체크 후 생성
        LottoException.checkBonusBallException(weeklyLotto, bonusBall);
        return new WeeklyLotto(weeklyLotto, bonusBall);
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
            Rank value = oneLotto.valueOfRank(this);
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

    public int getBonusBall() {
        return bonusBall;
    }
}
