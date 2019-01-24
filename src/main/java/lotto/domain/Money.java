package lotto.domain;

import java.util.List;

public class Money {

    private List<Integer> prizeMoney;

    public Money(List<Integer> prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public double profitRate(List<Rank> ranks, int amountUsed) {
        int input = 0;
        for (int i = 0; i < prizeMoney.size(); i++) {
            input = prizeMoney.get(i) * ranks.get(i).getWinningMoney();
        }
        return (double)input / amountUsed;
    }

    @Override
    public String toString() {
        return "Money{" +
                "prizeMoney=" + prizeMoney +
                '}';
    }
}