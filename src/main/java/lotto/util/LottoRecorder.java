package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoRecorder {

    private Lotto jackpot;
    private LottoNumber luckyNumber;
    private LottoResult lottoResult;

    public LottoRecorder(Lotto jackpot, List<Lotto> lottoList, LottoNumber luckyNumber) {
        Objects.requireNonNull(jackpot);
        Objects.requireNonNull(lottoList);
        Objects.requireNonNull(luckyNumber);
        this.jackpot = jackpot;
        this.luckyNumber = luckyNumber;
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
                .filter(sameCount(lottoRank))
                .collect(Collectors.toList());
    }

    private Predicate<Lotto> sameCount(LottoRank lottoRank) {
        return lotto ->
                lottoRank.equals(LottoRank.getLottoRank(matchCount(lotto),lotto.contains(luckyNumber)));
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