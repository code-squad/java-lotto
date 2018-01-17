package dto;

import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> result;
    private int rate;

    public LottoResult(Map<Integer, Integer> result, int rate) {
        this.result = result;
        this.rate = rate;
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }

    public int getRate() {
        return rate;
    }

    public void setResult(Map<Integer, Integer> result) {
        this.result = result;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
