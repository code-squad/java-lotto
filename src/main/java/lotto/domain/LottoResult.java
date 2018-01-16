package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoResult {

    private Map<LottoRank, List<Lotto>> lottoMap;
    private Lotto jackpot;

    public LottoResult(Lotto jackpot, List<Lotto> lottoList) {
        Objects.requireNonNull(jackpot);
        if(lottoList == null || lottoList.isEmpty()) throw new IllegalArgumentException();

        this.jackpot = jackpot;
        lottoMap = new HashMap<>();

        putWinLotto(lottoList);
        putNoPriceLotto(lottoList);
    }

    public int matchCount(Lotto lotto) {
        return jackpot.containCount(lotto);
    }

    private void putWinLotto(List<Lotto> lottoList) {
        Stream.of(LottoRank.values()).forEach(lottoRank ->
                lottoMap.put(lottoRank, matchCount(lottoRank, lottoList))
        );
    }

    private List<Lotto> matchCount(LottoRank lottoRank, List<Lotto> lottoList) {
        return lottoList.stream()
                .filter(lotto -> lottoRank.getMatchingCount() == matchCount(lotto))
                .collect(Collectors.toList());
    }

    private void putNoPriceLotto(List<Lotto> lottoList) {
        lottoMap.put(LottoRank.REST, noPriceLottoList(lottoList));
    }

    private List<Lotto> noPriceLottoList(List<Lotto> lottoList) {
        return lottoList.stream()
                .filter(lotto -> !getRankedList().contains(lotto))
                .collect(Collectors.toList());
    }

    private List<Lotto> getRankedList() {
        List<Lotto> rankedList = new ArrayList<>();
        Stream.of(LottoRank.values())
                .filter(lottoRank -> !LottoRank.REST.equals(lottoRank))
                .forEach(lottoRank -> rankedList.addAll(lottoMap.get(lottoRank))
        );
        return rankedList;
    }

    public int totalCount() {
        return lottoMap.values().stream().mapToInt(lottoList->lottoList.size()).sum();
    }

    public int getLottoCount(LottoRank lottoRank) {
        return lottoMap.computeIfAbsent(lottoRank, k -> new ArrayList<>()).size();
    }
}