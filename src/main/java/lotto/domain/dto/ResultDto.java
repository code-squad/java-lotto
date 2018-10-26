package lotto.domain.dto;

import lotto.domain.Rank;

import java.util.Map;

public class ResultDto {
    private Map<Rank, Integer> results;

    public ResultDto(Map<Rank, Integer> results) {
        this.results = results;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}
