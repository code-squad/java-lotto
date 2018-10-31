package lotto.dto;

import lotto.domain.Rank;

import java.util.Collections;
import java.util.Map;

public class ResultDto {
    private Map<Rank, Integer> results;
    private int rateOfReturn;

    public ResultDto(Map<Rank, Integer> results, int rateOfReturn) {
        this.results = results;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Rank, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public int getRateOfReturn() {
        return rateOfReturn;
    }
}

