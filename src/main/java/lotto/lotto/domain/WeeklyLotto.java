package lotto.lotto.domain;

import java.util.*;

public class WeeklyLotto {

    private Lotto winningLotto;
    private int bonusBall;

    public WeeklyLotto(List<Integer> winningLotto, int bonusBall) {
        checkBonusBallException(winningLotto, bonusBall);
        this.winningLotto = new Lotto(winningLotto);
        this.bonusBall = bonusBall;
    }

    public static WeeklyLotto of(String winningLotto, int bonusBall) {
        List<Integer> weeklyLotto = Parse.parse(winningLotto);
        return new WeeklyLotto(weeklyLotto, bonusBall);
    }

    public Map<Rank, Integer> initRank() {
        Map<Rank, Integer> numberOfRank = new HashMap<>();
        for (Rank r : Rank.values()) {
            numberOfRank.put(r, 0);
        }
        return numberOfRank;
    }

    public Map<Rank, Integer> checkRank(List<Lotto> lottos) {  //등수를 확인한다.
        Map<Rank, Integer> numberOfRank = initRank();
        for (Lotto oneLotto : lottos) {
            Rank value = oneLotto.valueOfRank(this);
            putRank(numberOfRank, value);
        }
        return numberOfRank;
    }

    public void putRank(Map<Rank, Integer> numberOfRank, Rank value) {
        if (value != null) {
            numberOfRank.put(value, numberOfRank.get(value) + 1);
        }
    }

    public int coutOfMatchLotto(List<Integer> lotto) {
        int collectNum = 0;
        for (Integer num : lotto) {
            collectNum = collectNumber(num, collectNum);
        }
        return collectNum;
    }

    public int collectNumber(int num, int collectNum) {   //당첨번호가 포함되있으면 +1
        if (winningLotto.getLotto().contains(num)) {
            return collectNum + 1;
        }
        return collectNum;
    }

    public boolean collectBonusBall(List<Integer> lotto) {
        if (lotto.contains(bonusBall)) {
            return true;
        }
        return false;
    }

    public static double incomeMoneyRate(Map<Rank, Integer> result, int money) {
        double incomeMoney = 0;
        for (Rank rankNum : Rank.values()) {
            incomeMoney += (rankNum.getWinningMoney() * result.get(rankNum));
        }
        return 100 * (incomeMoney - money) / money;
    }

    public static void checkBonusBallException(List<Integer> winningLotto, int bonusBall) {
        Parse.overException(bonusBall);
        List<Integer> plusBonus = new ArrayList<>(winningLotto);
        plusBonus.add(bonusBall);

        HashSet<Integer> set = new HashSet<>(plusBonus);
        if (plusBonus.size() != set.size())
            throw new IllegalArgumentException("같은 번호가 입력 되었습니다");
    }
}
