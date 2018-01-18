package lotto.domain;

import java.util.*;

public class LottoResult {

    private Map<LottoRank, Lotteries> lottoMap;

    public LottoResult() {
        lottoMap = new HashMap<>();
    }

    public int totalCount() {
        return lottoMap.values().stream().mapToInt(lottoList->lottoList.size()).sum();
    }

    public int getLottoCount(LottoRank lottoRank) {
        return lottoMap.computeIfAbsent(lottoRank, k -> new Lotteries()).size();
    }

    public void put(LottoRank lottoRank, Lotteries lottoList) {
        Objects.requireNonNull(lottoRank);
        Objects.requireNonNull(lottoList);
        if (!lottoList.isEmpty()) {
            lottoMap.put(lottoRank, lottoList);
        }
    }
}