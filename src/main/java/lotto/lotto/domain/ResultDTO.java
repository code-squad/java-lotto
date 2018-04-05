package lotto.lotto.domain;

import java.util.Map;

import static lotto.lotto.domain.Rank.*;

public class ResultDTO {

    private Map<Rank, Integer> result;
    private int money;

    public ResultDTO(Map<Rank, Integer> result, int money) {
        this.result = result;
        this.money = money;
    }

    public int getFirst() {
        return result.get(Rank.FIRST);
    }

    public int getSecond() {
        return result.get(Rank.SECOND);
    }

    public int getThird() {
        return result.get(Rank.THIRD);
    }

    public int getFourth() {
        return result.get(Rank.FOURTH);
    }

    public int getFifth() {
        return result.get(Rank.FIFTH);
    }

    public double getMoney() {
        double incomeMoney = 0;
        for (Rank rankNum : Rank.values()) {
            incomeMoney += rankNum.getTotalWinnerPrize(result.get(rankNum));
        }
        return 100 * (incomeMoney - money) / money;
    }
}
