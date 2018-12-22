package dto;

import domain.Lotto;

import java.util.HashMap;
import java.util.Map;

public class ResultDto {
    private Map<Integer, Integer> result;

    public ResultDto() {
        this.result = new HashMap<>();
        for (int i = 0; i <= Lotto.LOTTOSIZE; i++) {
            result.put(i, 0);
        }
    }

    public void pushResult(int lottoMatchCount) {
        result.put(lottoMatchCount, result.get(lottoMatchCount) + 1);
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }
}
