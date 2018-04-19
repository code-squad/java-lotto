package com.codesquad.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBundle {
    private final List<Lotto> lotteries;

    public LottoBundle(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public WinningMatchResult match(final Lotto winLotto) {
        if (winLotto == null) {
            throw new IllegalArgumentException();
        }

        final Stream<WinType> winTypes = matchedWinTypes(winLotto);

        final Map<WinType, Long> winTypeCount = groupByWinType(winTypes);

        return new WinningMatchResult(winTypeCount);
    }

    private Map<WinType, Long> groupByWinType(final Stream<WinType> winTypes) {
        return winTypes.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Stream<WinType> matchedWinTypes(final Lotto winLotto) {
        return lotteries.stream()
                .map(lotto -> lotto.matchedCount(winLotto))
                .map(WinType::valueOf)
                .filter(WinType::isWin);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoBundle that = (LottoBundle) o;
        return Objects.equals(lotteries, that.lotteries);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lotteries);
    }

    public List<String> lotteriesString() {
        return lotteries.stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
    }

    public int count() {
        return lotteries.size();
    }
}
