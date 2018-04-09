package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private final List<Lotto> lottos;

    public LottoGame() {
        lottos = new ArrayList<>();
    }

    public LottoGame(long amount) {
        this.lottos = buy(amount);
    }

    static List<Lotto> buy(long amount) {
        List<Lotto> lottos = IntStream
                .range(0, count(amount))
                .mapToObj(lotto -> new Lotto())
                .collect(Collectors.toList());

        return Collections.unmodifiableList(lottos);
    }

    static int count(long amount) throws IllegalArgumentException {
        if(amount == 0) {
            throw new IllegalArgumentException();
        }

        return (int)(amount / Lotto.DEFAULT_PRICE);
    }

    public GameResult play(List<String> winningNumber) {
        GameResult gameResult = new GameResult(winningNumber);
        gameResult.record(lottos);

        return gameResult;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
