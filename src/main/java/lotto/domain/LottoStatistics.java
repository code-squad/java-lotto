package lotto.domain;

import java.util.List;

/**
 * @author sangsik.kim
 */
public class LottoStatistics {
    List<Lotto> lottos;
    List<Integer> winningNumbers;

    public LottoStatistics(LottoGame lottoGame, List<Integer> winningNumbers) {
        this.lottos = lottoGame.getLottos();
        this.winningNumbers = winningNumbers;
    }

    public int count(WinningTier tier) {
        return new Long(this.lottos
                .stream()
                .filter(lotto -> lotto.compareWithWinningNumbers(winningNumbers) == tier.getEqualNumbersCount())
                .count())
                .intValue();
    }
}
