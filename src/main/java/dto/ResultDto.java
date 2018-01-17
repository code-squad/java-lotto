package dto;

import java.util.Map;

public class ResultDto {
    private Map<Integer, Integer> winningPrice;
    private Map<Integer, Integer> winningCount;
    private int revenue;

    public ResultDto(Map<Integer, Integer> winningPrice, Map<Integer, Integer> winningCount, int revenue) {
        this.winningPrice = winningPrice;
        this.winningCount = winningCount;
        this.revenue = revenue;
    }

    public Map<Integer, Integer> getWinningPrice() {
        return winningPrice;
    }

    public Map<Integer, Integer> getWinningCount() {
        return winningCount;
    }

    public int getRevenue() {
        return revenue;
    }
}
