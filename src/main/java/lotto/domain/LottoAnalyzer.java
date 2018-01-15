package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoAnalyzer {

    private Lotto jackpotLotto;
    private Map<LottoRank, List<Lotto>> lottoMap;
    private Object profit;

    public LottoAnalyzer() {
        this.jackpotLotto = LottoVendor.getInstance().getLastJackpotLotto();
        lottoMap = new HashMap<>();
    }

    public LottoAnalyzer(Lotto jackpotLotto) {
        this.jackpotLotto = jackpotLotto;
    }

    public int matchCount(Lotto lotto) {
        return this.jackpotLotto.containCount(lotto);
    }

    public LottoAnalyzer analyzeLottery(List<Lotto> lottoList) {
        putWinLotto(lottoList);
        putNoPriceLotto(lottoList);
        return this;
    }

    public int getLottoCount(LottoRank lottoRank) {
        return lottoMap.computeIfAbsent(lottoRank, k -> new ArrayList<>()).size();
    }

    private void putWinLotto(List<Lotto> lottoList) {
        Stream.of(LottoRank.values()).forEach(lottoRank ->
                lottoMap.put(lottoRank, matchCount(lottoRank, lottoList))
        );
    }

    private void putNoPriceLotto(List<Lotto> lottoList) {
        lottoMap.put(LottoRank.REST, noPriceLottoList(lottoList));
    }

    private List<Lotto> noPriceLottoList(List<Lotto> lottoList) {
        return lottoList.stream().filter(lotto -> !getRankedList().contains(lotto))
                .collect(Collectors.toList());
    }

    private List<Lotto> matchCount(LottoRank lottoRank, List<Lotto> lottoList) {
        return lottoList.stream().filter(lotto -> lottoRank.getMatchingCount() == matchCount(lotto))
                .collect(Collectors.toList());
    }

    private List<Lotto> getRankedList() {
        ArrayList<Lotto> rankList = new ArrayList<>();
        lottoMap.values().forEach(rankLottoList -> rankList.addAll(rankLottoList));
        return rankList;
    }

    public int getPrize(LottoRank lottoRank) {
        return lottoMap.computeIfAbsent(lottoRank, k -> new ArrayList<>()).size() * lottoRank.getPrice();
    }

    public int getProfit() {
        return Arrays.asList(LottoRank.values()).stream().map(lottoRank -> getPrize(lottoRank)).mapToInt(Integer::intValue).sum();
    }
}