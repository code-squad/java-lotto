package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.Arrays;
import java.util.List;

public class LottoRecorder {

    private LottoResult lottoResult;

    public LottoRecorder(Lotto jackpot, List<Lotto> lottoList) {
        this.lottoResult = new LottoResult(jackpot, lottoList);
    }

    public int matchCount(Lotto lotto) {
        return lottoResult.matchCount(lotto);
    }

    public int getLottoCount(LottoRank lottoRank) {
        return lottoResult.getLottoCount(lottoRank);
    }

    public int getPrize(LottoRank lottoRank) {
        return getLottoCount(lottoRank) * lottoRank.getPrice();
    }

    public int getProfit() {
        return Arrays.asList(LottoRank.values()).stream()
                .map(lottoRank -> getPrize(lottoRank))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getProfitRatio() {
        return (int)((getProfit() / (lottoResult.totalCount()*1000f)) * 100);
    }
}