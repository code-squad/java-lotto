package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LottoGame {

    private final List<Lotto> autoLottos;
    private final List<Lotto> manualLottos;

    LottoGame() {
        autoLottos = Collections.emptyList();
        manualLottos = Collections.emptyList();
    }

    public LottoGame(long amount, List<List<String>> manualLottos) {
        int count = count(amount) - manualLottos.size();
        this.autoLottos = buy(count);
        this.manualLottos = buy(manualLottos);
    }

    static List<Lotto> buy(int count) {
        return IntStream
                .range(0, count)
                .mapToObj(lotto -> new Lotto())
                .collect(toList());
    }

    static List<Lotto> buy(List<List<String>> manualLottos) {
        return manualLottos.stream()
                .map(Lotto::new)
                .collect(toList());
    }

    static int count(long amount) throws IllegalArgumentException {
        if(amount == 0) {
            throw new IllegalArgumentException();
        }

        return (int)(amount / LottoRule.DEFAULT_PRICE);
    }

    public GameResult play(List<String> winningNumber, String bonusNumber) {
        GameResult gameResult = new GameResult(winningNumber, bonusNumber);
        gameResult.record(getLottos());

        return gameResult;
    }

    private List<Lotto> getLottos() {
        return Stream.of(autoLottos, manualLottos)
                .flatMap(Collection::stream)
                .collect(toList());
    }

    public int sizeAutoLottos() {
        return autoLottos.size();
    }

    public int sizeManualLottos() {
        return manualLottos.size();
    }

    @Override
    public String toString() {
        return getLottos()
                .stream()
                .map(Lotto::toString)
                .collect(joining("\n"));
    }
}
