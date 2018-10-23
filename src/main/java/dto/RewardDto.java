package dto;

import java.util.Map;

public class RewardDto {
    private int profit;
    private Map<Integer, Integer> rewardResult;
    private Map<Integer, Integer> rewardMapper;

    public RewardDto(int profit, Map<Integer, Integer> rewardResult, Map<Integer, Integer> rewardMapper) {
        this.profit = profit;
        this.rewardResult = rewardResult;
        this.rewardMapper = rewardMapper;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public Map<Integer, Integer> getRewardResult() {
        return rewardResult;
    }

    public void setRewardResult(Map<Integer, Integer> rewardResult) {
        this.rewardResult = rewardResult;
    }

    public Map<Integer, Integer> getRewardMapper() {
        return rewardMapper;
    }

    public void setRewardMapper(Map<Integer, Integer> rewardMapper) {
        this.rewardMapper = rewardMapper;
    }
}
