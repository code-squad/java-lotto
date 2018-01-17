package DTO;


import lombok.Getter;
import model.Rank;

import java.util.Map;

@Getter
public class LottoResult {
    private Map<Rank, Integer> lottoResult;
    private Double percentage;

    public LottoResult(Map<Rank, Integer> lottoResult, Double percentage) {
        this.lottoResult = lottoResult;
        this.percentage = percentage;
    }
}
