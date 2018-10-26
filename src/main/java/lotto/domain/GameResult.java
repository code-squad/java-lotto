package lotto.domain;

import lotto.domain.dto.ResultDto;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private Map<Rank, Integer> results = new HashMap<>();

    public GameResult() {
        results.put(Rank.FIRST, 0);
        results.put(Rank.SECOND, 0);
        results.put(Rank.THIRD, 0);
        results.put(Rank.FOURTH, 0);
        results.put(Rank.FIFTH, 0);
    }

    public void countMatchLotto(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);
        if(rank != null) {
            int count = results.get(rank);
            results.put(rank, ++count);
        }
    }

    public ResultDto createResultDto() {
        return new ResultDto(results);
    }
}
