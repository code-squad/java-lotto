package DTO;


import lombok.Getter;

import java.util.List;

@Getter
public class LottoResult {
    private List<Integer> hitNumbersByALotto;
    private List<Integer> countThreeFourFiveHits;
    private Double percentage;

    public LottoResult(List<Integer> hitNumbersByALotto, List<Integer> countThreeFourFiveHits, Double percentage) {
        this.hitNumbersByALotto = hitNumbersByALotto;
        this.countThreeFourFiveHits = countThreeFourFiveHits;
        this.percentage = percentage;
    }
}
