package lotto.lotto.domain;

import java.util.Map;

import static lotto.lotto.domain.Rank.*;

public class ResultDTO {

    private Map<Rank, Integer> result;
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;
    private int money;

    public ResultDTO(Map<Rank, Integer> result, int money) {
        this.result = result;
        inputResult(result);
        this.money = money;
    }

    public void inputResult(Map<Rank, Integer> result) {
        this.first = result.get(Rank.FIRST);
        this.second = result.get(Rank.SECOND);
        this.third = result.get(Rank.THIRD);
        this.fourth = result.get(Rank.FOURTH);
        this.fifth = result.get(Rank.FIFTH);
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public double getMoney() {
        double incomeMoney = 0;
        for (Rank rankNum : Rank.values()) {
            incomeMoney += (rankNum.getWinningMoney() * result.get(rankNum));
        }
        return 100 * (incomeMoney - money) / money;
    }
}
