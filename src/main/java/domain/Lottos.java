package domain;

import enums.LottoPrize;

import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getNumOfLottos() {
        return lottos.size();
    }

    public Map<LottoPrize,Integer> matchLottosWithWinnigNums(WinningNumber winningNumber) {
        return LottoChecker.getWinnerLottos(lottos, winningNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Lotto lotto : lottos)
            sb.append(lotto.toString()).append('\n');
        return sb.toString();
    }
}
