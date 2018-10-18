package dto;

import java.util.Map;

public class ResultDto {
    private final Map<Integer, Integer> matchResult;
    private final int profitRate;

    public ResultDto(Map<Integer, Integer> matchResult, int profitRate) {
        this.matchResult = matchResult;
        this.profitRate = profitRate;
    }

    public Map<Integer, Integer> getMatchResult() {
        return matchResult;
    }

    public int getProfitRate() {
        return profitRate;
    }
}
