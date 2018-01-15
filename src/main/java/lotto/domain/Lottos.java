package lotto.domain;

import lotto.dto.LottoResult;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public LottoResults match(Lotto winningLotto) {
        return LottoResults.generate(lottos.stream()
                .map(lotto -> new LottoResult(lotto.getCorrectCount(winningLotto.getNumbers())))
                .collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
