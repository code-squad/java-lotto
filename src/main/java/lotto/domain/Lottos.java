package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.enums.Rank;

import static lotto.domain.WinningLotto.getWinningCount;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public LottoResult matchResult() {
        return LottoResult.generate(getWinningRank());
    }

    public List<Rank> getWinningRank() {
        return this.lottos.stream()
                .filter(WinningLotto::isWinningTarget)
                .map(lotto -> Rank.match(getWinningCount(lotto), lotto.hasBonusBall(WinningLotto.getBonusBall())))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
