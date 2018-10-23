package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static Map<Rank, Integer> results = new HashMap<>();

    static {
        results.put(Rank.FIRST, 0);
        results.put(Rank.SECOND, 0);
        results.put(Rank.THIRD, 0);
        results.put(Rank.FOURTH, 0);
        results.put(Rank.FIFTH, 0);
    }

    public static void countMatchLotto(int countOfMatch, boolean matchBonus) {
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);
        if(rank != null) {
            int count = results.get(rank);
            results.put(rank, ++count);
        }
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }
}
