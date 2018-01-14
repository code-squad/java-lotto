package domain;

import enums.LottoPrize;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private List<Lotto> lottos;

    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getNumOfLottos() {
        return lottos.size();
    }

    public Map<LottoPrize,Integer> matchLottosWithWinnigNums(WinningLotto winningLotto) {
        return LottoChecker.getWinnerLottos(lottos, winningLotto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos)
            sb.append(lotto.toString()).append('\n');
        return sb.toString();
    }
}
