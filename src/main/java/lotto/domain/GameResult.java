package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class GameResult {

    private final Lotto winning;
    private final Map<Rank, Integer> rank;

    public GameResult(List<String> winningNumbers) {
        this.winning = new Lotto(winningNumbers);
        this.rank = new HashMap<>();
        rank.put(Rank.FIRST, 0);
        rank.put(Rank.SECOND, 0);
        rank.put(Rank.THIRD, 0);
        rank.put(Rank.FORTH, 0);
    }

    public void record(final List<Lotto> lottos) {
        rank.forEach((key, value) -> rank.put(key, match(lottos, key.matchCount())));
    }

    int match(final List<Lotto> lottos, final int matchCount) {
        long count = lottos.stream()
                .filter(lotto -> countMatchNumber(lotto) == matchCount)
                .count();

        return (int) count;
    }

    private int countMatchNumber(final Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winning.getNumbers();

        long count = numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return (int) count;
    }

    long totalPrizeMoney() {
        AtomicLong totalPrizeMoney = new AtomicLong(0L);
        rank.forEach((key, value) -> totalPrizeMoney.addAndGet(key.prizeMoney() * value));
        return totalPrizeMoney.longValue();
    }

    public int rateOfReturn(long amount) {
        return (int)(((double)totalPrizeMoney() / (double)amount) * 100);
    }

    public Lotto getWinning() {
        return winning;
    }

    public Map<Rank, Integer> getRank() {
        return rank;
    }
}
