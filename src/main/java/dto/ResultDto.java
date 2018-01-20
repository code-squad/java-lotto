package dto;

import domain.Lottos;
import domain.Rank;
import domain.WinningLotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultDto {
    private int price;
    private Map<Rank, Integer> ranksCount;

    public ResultDto(int price) {
        ranksCount = initRanksCount();
        this.price = price;
    }

    private Map<Rank, Integer> initRanksCount() {
        Map<Rank, Integer> ranksCount = new HashMap<>();
        Rank[] ranks = Rank.values();
        Arrays.stream(ranks)
                .forEach(rank -> ranksCount.put(rank, 0));

        return ranksCount;
    }

    public Map<Rank, Integer> getRanksCount() {
        return ranksCount;
    }

    public int calRevenue() {
        Rank[] ranks = Rank.values();
        float max = Arrays.stream(ranks)
                .map(rank -> rank.mulMoney(ranksCount.get(rank)))
                .reduce(0, (a, b) -> a + b);

        return Math.round(max / price * 100) - 100;
    }

    public void checkLastWinningNumbers(String lastWinningNumbers, int bonusBall, Lottos lottos) {
        WinningLotto winningLotto = new WinningLotto(parseInts(split(lastWinningNumbers)), bonusBall);

        countRank(lottos.match(winningLotto));
    }

    public int countOfLotto() {
        return price / 1000;
    }

    private String[] split(String text) {
        return text.split("(, )");
    }

    private List<Integer> parseInts(String[] numbersText) {
        return Arrays.stream(numbersText)
                .map(number -> parseInt(number))
                .collect(Collectors.toList());
    }

    private int parseInt(String numberText) {
        return Integer.parseInt(numberText);
    }

    private Map<Rank, Integer> countRank(List<Rank> ranks) {
        ranks.stream().forEach(rank -> ranksCount.put(rank, ranksCount.get(rank) + 1));

        return ranksCount;
    }
}
