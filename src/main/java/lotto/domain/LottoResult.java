package lotto.domain;

import java.util.*;

public class LottoResult {

    private Map<LottoRank, List<Lotto>> lottoMap;

    public LottoResult() {
        lottoMap = new HashMap<>();
    }

    public int totalCount() {
        return lottoMap.values().stream().mapToInt(lottoList->lottoList.size()).sum();
    }

    public int getLottoCount(LottoRank lottoRank) {
        return lottoMap.computeIfAbsent(lottoRank, k -> new ArrayList<>()).size();
    }

    public void put(LottoRank lottoRank, List<Lotto> lottoList) {
        Objects.requireNonNull(lottoRank);
        Objects.requireNonNull(lottoList);
        if (!lottoList.isEmpty()) {
            lottoMap.put(lottoRank, lottoList);
        }
    }
}