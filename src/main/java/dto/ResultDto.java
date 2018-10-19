package dto;

import java.util.Map;

public class ResultDto {
    private final Map<Integer, Integer> strikeResults;
    private final int profitRate;

    public ResultDto(Map<Integer, Integer> strikeResults, int profitRate) {
        this.strikeResults = strikeResults;
        this.profitRate = profitRate;
    }

    public Map<Integer, Integer> getStrikeResults() {
        return strikeResults;
    }

    public int getProfitRate() {
        return profitRate;
    }
}
