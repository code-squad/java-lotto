package dto;

import domain.Reward;

import java.util.Map;

public class RewardDto {
    private int profit;
    private Map<Reward, Integer> rewardResult;

    public RewardDto(int profit, Map<Reward, Integer> rewardResult) {
        this.profit = profit;
        this.rewardResult = rewardResult;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Map<Reward, Integer> getRewardResult() {
        return rewardResult;
    }

    public void setRewardResult(Map<Reward, Integer> rewardResult) {
        this.rewardResult = rewardResult;
    }
}
