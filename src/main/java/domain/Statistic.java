package domain;

import vo.Prize;

import java.util.LinkedHashMap;
import java.util.Map;

public class Statistic {
    private final int MIN = 3;
    private Map<Prize, Integer> winnerInfo = new LinkedHashMap<>();

    void initWinnerInfo() {
        for (Prize value : Prize.values()) {
            winnerInfo.put(value, 0);
        }
    }

    void makeResult(int matchedNumberCnt) {
        if (matchedNumberCnt >= MIN) {
            Prize prize = Prize.getPrize(matchedNumberCnt);
            winnerInfo.put(prize, winnerInfo.get(prize) + 1);
        }
    }

    public int AccumulatedNumber(Prize prize) {
        return winnerInfo.get(prize);
    }
}
