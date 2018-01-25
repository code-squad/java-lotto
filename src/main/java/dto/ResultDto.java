package dto;

import domain.LottoResult;
import domain.Lottos;
import domain.Rank;
import domain.WinningLotto;
import util.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultDto {
    private int price;
    private int handCount;
    private Lottos handMakeLottos;
    private Map<Rank, Integer> ranksCount;

    public ResultDto(int price, int handCount, Lottos handMakeLottos) {
        ranksCount = initRanksCount();
        this.price = price;
        this.handCount = handCount;
        this.handMakeLottos = handMakeLottos;
    }

    private Map<Rank, Integer> initRanksCount() {
        Map<Rank, Integer> ranksCount = new HashMap<>();
        Rank[] ranks = Rank.values();
        Arrays.stream(ranks)
                .forEach(rank -> ranksCount.put(rank, 0));

        return ranksCount;
    }

    public List<LottoResult> getResults() {
        Rank[] ranks = Rank.values();

        return Arrays.stream(ranks)
                .sorted((Rank o1, Rank o2) -> o1.compare(o2))
                .map(rank -> new LottoResult(rank, ranksCount.get(rank)))
                .collect(Collectors.toList());
    }

    public int calRevenue() {
        Rank[] ranks = Rank.values();
        float max = Arrays.stream(ranks)
                .map(rank -> rank.mulMoney(ranksCount.get(rank)))
                .reduce(0, (a, b) -> a + b);

        return Math.round(max / price * 100) - 100;
    }

    public void checkLastWinningNumbers(String lastWinningNumbers, int bonusBall, Lottos lottos) {
        WinningLotto winningLotto = new WinningLotto(parseInts(Utils.split(lastWinningNumbers)), bonusBall);
        lottos.addLottos(handMakeLottos);
        countRank(lottos.match(winningLotto));
    }

    public int countOfLotto() {
        return price / 1000;
    }

    public int autoMakeLottoCount() {
        return countOfLotto() - handCount;
    }

    private List<Integer> parseInts(String[] numbersText) {
        return Arrays.stream(numbersText)
                .map(number -> Utils.parseInt(number))
                .collect(Collectors.toList());
    }

    private Map<Rank, Integer> countRank(List<Rank> ranks) {
        ranks.stream().forEach(rank -> ranksCount.put(rank, ranksCount.get(rank) + 1));

        return ranksCount;
    }
}
