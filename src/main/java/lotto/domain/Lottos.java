package lotto.domain;

import java.util.ArrayList;

import lotto.dto.LottoResult;

public class Lottos extends ArrayList<Lotto> {

    public LottoResults match(Lotto winningLotto) {
        LottoResults lottoResults = new LottoResults();
        this.stream()
                .map(lotto -> new LottoResult(lotto.getCorrectCount(winningLotto.getNumbers())))
                .forEach(lottoResults::add);
        return lottoResults;
    }
}
