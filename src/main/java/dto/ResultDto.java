package dto;

import utils.Rank;

import java.util.Map;

public class ResultDto {
    private final Map<Rank, Integer> gameResults;
    private final int profitRate;

    public ResultDto(Map<Rank, Integer> gameResults, int profitRate) {
        this.gameResults = gameResults;
        this.profitRate = profitRate;
    }

    public Map<Rank, Integer> getGameResults() {
        return gameResults;
    }

    public int getProfitRate() {
        return profitRate;
    }
}
