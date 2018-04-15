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

        payment = calculatePayment(lotteries.size());

        lotteries.stream()
                .map(lotto -> lotto.matchedCount(winLotto))
                .map(WinType::valueOf)
                .filter(WinType::isWin)
                .forEach(this::increaseCount);
    }

    private void initializeMap() {
        Arrays.stream(WinType.values())
                .filter(WinType::isWin)
                .forEach(type -> accumulatedCountMap.put(type, 0));
    }

    private Money calculatePayment(final int purchasedCount) {
        return LottoMachine.LIST_PRICE.multiply(purchasedCount);
    }

    private void increaseCount(final WinType winType) {
        final Integer count = accumulatedCountMap.get(winType);
        accumulatedCountMap.put(winType, count + 1);
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
