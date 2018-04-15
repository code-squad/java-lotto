package com.codesquad.lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoBundle {
    private final List<Lotto> lotteries;

    public LottoBundle(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }


    public LottoStats match(final Lotto winLotto) {
        if (winLotto == null) {
            throw new IllegalArgumentException();
        }

        final Map<WinType, Integer> accumulatedCountMap = initializeMap();
        final Money payment = calculatePayment();

        final Stream<WinType> winTypes = matchedWinTypes(winLotto);

        increaseCount(accumulatedCountMap, winTypes);

        return new LottoStats(accumulatedCountMap, payment);
    }

    private Stream<WinType> matchedWinTypes(final Lotto winLotto) {
        return lotteries.stream()
                .map(lotto -> lotto.matchedCount(winLotto))
                .map(WinType::valueOf)
                .filter(WinType::isWin);
    }

    private Map<WinType, Integer> initializeMap() {
        final Map<WinType, Integer> map = new HashMap<>();
        Arrays.stream(WinType.values())
                .filter(WinType::isWin)
                .forEach(type -> map.put(type, 0));
        return map;
    }

    private Money calculatePayment() {
        final int purchasedCount = lotteries.size();
        return LottoMachine.LIST_PRICE.multiply(purchasedCount);
    }

    private void increaseCount(final Map<WinType, Integer> map, final Stream<WinType> winTypes) {
        winTypes.forEach(t -> map.put(t, map.get(t) + 1));
    }
}
