package com.codesquad.lotto.domain;

import java.util.*;

public class LottoStats {

    private final Money payment;
    private final Map<WinType, Integer> accumulatedCountMap = new HashMap<>();

    public LottoStats(final List<Lotto> lotteries, final Lotto winLotto) {
        if (Objects.isNull(lotteries)) {
            throw new IllegalArgumentException();
        }

        if (Objects.isNull(winLotto)) {
            throw new IllegalArgumentException();
        }

        initializeMap();

        payment = LottoMachine.LIST_PRICE.multiply(lotteries.size());

        lotteries.stream()
                .map(lotto -> lotto.matchedCount(winLotto))
                .map(WinType::valueOf)
                .filter(type -> isWin(type))
                .forEach(this::increaseCount);
    }

    private void initializeMap() {
        Arrays.stream(WinType.values())
                .filter(type -> isWin(type))
                .forEach(type -> accumulatedCountMap.put(type, 0));
    }

    private void increaseCount(final WinType winType) {
        final Integer count = accumulatedCountMap.get(winType);
        accumulatedCountMap.put(winType, count + 1);
    }

    private boolean isWin(final WinType winType) {
        return !winType.equals(WinType.OUT);
    }

    public int getWiningCount(final WinType type) {
        return accumulatedCountMap.get(type);
    }

    public int getProfitRate() {
        Money sum = new Money(0);

        for (final Map.Entry<WinType, Integer> entry : accumulatedCountMap.entrySet()) {
            sum = sum.add(entry.getKey().calculatePrize(entry.getValue()));
        }

        return Money.calculateProfitRate(sum, payment);
    }
}
