package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.enums.Rank;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public LottoResult matchResult(WinningLotto winningLotto) {
        return LottoResult.generate(getWinningRank(winningLotto));
    }

    public List<Rank> getWinningRank(WinningLotto winningLotto) {
        return this.lottos.stream()
                .filter(winningLotto::isWinningTarget)
                .map(lotto -> Rank.match(winningLotto.getWinningCount(lotto), lotto.hasBonusBall(winningLotto.getBonusBall())))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
