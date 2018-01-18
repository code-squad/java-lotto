package dto;

import domain.LottoGame;

import java.util.Map;

public class LottoResult {
    private Map<LottoGame.Rank, Integer> result;
    private int rate;

    public LottoResult(Map<LottoGame.Rank, Integer> result, int rate) {
        this.result = result;
        this.rate = rate;
    }

    public Map<LottoGame.Rank, Integer> getResult() {
        return result;
    }

    public int getRate() {
        return rate;
    }

    public void setResult(Map<LottoGame.Rank, Integer> result) {
        this.result = result;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
