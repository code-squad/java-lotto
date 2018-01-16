package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoRecorder {

    private Lotto jackpot;
    private LottoResult lottoResult;

    public LottoRecorder(Lotto jackpot, List<Lotto> lottoList) {
        Objects.requireNonNull(jackpot);
        this.jackpot = jackpot;
        this.lottoResult = new LottoResult();
        recordResult(lottoList);
    }

    private void recordResult(List<Lotto> lottoList) {
        Stream.of(LottoRank.values()).forEach(lottoRank ->
                lottoResult.put(lottoRank, matchCount(lottoRank, lottoList))
        );
    }

    private List<Lotto> matchCount(LottoRank lottoRank, List<Lotto> lottoList) {
        return lottoList.stream()
                .filter(lotto ->
                        lottoRank.equals(LottoRank.REST) ?
                                matchCount(lotto) < 3 :
                                lottoRank.getMatchingCount() == matchCount(lotto)
                )
                .collect(Collectors.toList());
    }

    public int matchCount(Lotto lotto) {
        return jackpot.containCount(lotto);
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