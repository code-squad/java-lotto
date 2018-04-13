package lotto.domain;

import lotto.Prize;

import java.util.Map;

public class LottoGameResult {

    private Map<Prize, Integer> lottoGameResult;
    private int calculatedEarningRate;

    public LottoGameResult(Map<Prize, Integer> lottoGameResult, int calculatedEarningRate) {
        this.lottoGameResult = lottoGameResult;
        this.calculatedEarningRate = calculatedEarningRate;
    }

    public int get(Prize prize) {
        return this.lottoGameResult.get(prize);
    }

    public Map<Prize, Integer>  getLottoGameResult() {
        return this.lottoGameResult;
    }

    public int getCalculatedEarningRate() {
        return this.calculatedEarningRate;
    }
}
