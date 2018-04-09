package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private static final int THREE_MATCH = 3;
    private static final int FOUR_MATCH = 4;
    private static final int FIVE_MATCH = 5;
    private static final int SIX_MATCH = 6;

    private static final int THREE_MATCH_MONEY = 5000;
    private static final int FOUR_MATCH_MONEY = 50000;
    private static final int FIVE_MATCH_MONEY = 1500000;
    private static final int SIX_MATCH_MONEY = 2000000000;

    public Map<Integer, Integer> result;

    public LottoStatistics(List<Lotto> lottos, List<Integer> luckyNumbers) {

        initResult();

        for (Lotto lotto : lottos) {
            Integer key = getMatchNumber(luckyNumbers, lotto);
            Integer count = result.get(key);

            if (count != null) {
                result.put(key, ++count);
            }
        }
    }

    static int getMatchNumber(List<Integer> luckyNumbers, Lotto lotto) {
        return lotto.matchesNumber(luckyNumbers);
    }

    private void initResult() {
        result = new HashMap<>();
        result.put(THREE_MATCH, 0);
        result.put(FOUR_MATCH, 0);
        result.put(FIVE_MATCH, 0);
        result.put(SIX_MATCH, 0);
    }

    public int rateOfReturn(int money) {
        return getTotal() * 100 / money;
    }

    int getTotal() {
        int total = 0;
        total += result.get(THREE_MATCH) * THREE_MATCH_MONEY;
        total += result.get(FOUR_MATCH) * FOUR_MATCH_MONEY;
        total += result.get(FIVE_MATCH) * FIVE_MATCH_MONEY;
        total += result.get(SIX_MATCH) * SIX_MATCH_MONEY;
        return total;
    }
}
