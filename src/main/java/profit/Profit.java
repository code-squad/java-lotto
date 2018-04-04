package profit;

import rank.Rank;

import java.util.List;

public class Profit {
    public int earn(List<Rank> ranks) {
        int sum = 0;
        for (Rank rank: ranks) {
            sum += rank.getWinningMoney();
        }
        return sum;
    }

    public int percent(List<Rank> ranks) {
        return (earn(ranks) / (ranks.size() * 1000)) * 100;
    }
}
