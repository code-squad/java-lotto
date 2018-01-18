package lotto.util;

import lotto.domain.*;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoRecorder {

    private WinningLotto winningLotto;
    private LottoResult lottoResult;

    public LottoRecorder(WinningLotto winningLotto, Lotteries lottoList) {
        if (nullCheck(winningLotto, lottoList)) throw new IllegalArgumentException();
        this.winningLotto = winningLotto;
        this.lottoResult = new LottoResult();
        recordResult(lottoList);
    }

    private boolean nullCheck(WinningLotto winningLotto, Lotteries lottoList) {
        return winningLotto == null || lottoList == null;
    }

    private void recordResult(Lotteries lottoList) {
        Stream.of(LottoRank.values()).forEach(lottoRank ->
                lottoResult.put(lottoRank, matchCount(lottoRank, lottoList))
        );
    }

    private Lotteries matchCount(LottoRank lottoRank, Lotteries lottoList) {
        return new Lotteries(lottoList.stream()
                .filter(sameCount(lottoRank))
                .collect(Collectors.toList()));
    }

    private Predicate<Lotto> sameCount(LottoRank lottoRank) {
        return lotto ->
                lottoRank.equals(LottoRank.getLottoRank(matchCount(lotto),lotto.contains(winningLotto.getLuckyNumber())));
    }

    public int matchCount(Lotto lotto) {
        return winningLotto.containCount(lotto);
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