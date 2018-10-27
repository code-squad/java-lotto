package lotto.dto;

import lotto.domain.Rank;

import java.util.Map;

public class ResultDto {
    private Map<Rank, Integer> results;
    private int money;

    public ResultDto(Map<Rank, Integer> results, int money) {
        this.results = results;
        this.money = money;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public int getMoney() {
        return money;
    }
}
