package dto;

import domain.Rank;
import domain.WinningLottos;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResults {

    private final List<WinningResult> winningResults;

    private double benefit;

    public WinningResults(WinningLottos winningLottos) {
        this.winningResults = getWinningResults(winningLottos);
        this.benefit = winningLottos.getRevenue();
    }

    private List<WinningResult> getWinningResults(WinningLottos winningLottos) {
        return Arrays.stream(Rank.values())
                     .filter(r -> !r.isFail())
                     .sorted(Comparator.comparingInt(Rank::getWinningMoney))
                     .map(r -> new WinningResult(r, winningLottos.getCountOfRank(r)))
                     .collect(Collectors.toList());
    }

    public List<WinningResult> getWinningResults() {
        return this.winningResults;
    }

    public double getBenefit() {
        return benefit;
    }

    class WinningResult {
        private static final String RESULT_PATTERN = "{0} - {1}개";

        private Rank rank;

        private int count;

        private WinningResult(Rank rank, int count) {
            this.rank = rank;
            this.count = count;
        }

        @Override
        public String toString() {
            return MessageFormat.format(RESULT_PATTERN, rank, count);
        }
    }
}
