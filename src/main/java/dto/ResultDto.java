package dto;

import domain.Lottos;
import domain.Rank;
import domain.UserLotto;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultDto {
    private int price;
    private List<Rank> ranks;
    private Map<Rank, Integer> ranksCount;

    public ResultDto(int price) {
        ranks = new ArrayList<>();
        ranksCount = initRanksCount();
        this.price = price;
    }

    private Map<Rank, Integer> initRanksCount() {
        Map<Rank, Integer> ranksCount = new HashMap<>();
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            ranksCount.put(rank, 0);
        }
        return ranksCount;
    }

    public Map<Rank, Integer> getRanksCount() {
        return ranksCount;
    }

    public int calRevenue() {
        float max = 0;
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            max += ranksCount.get(rank) * rank.getWinningMoney();
        }
        return Math.round(max / price * 100) - 100;
    }

    public void checkLastWinningNumbers(String lastWinningNumbers, int bonusBall, Lottos lottos) {
        WinningLotto numbers = new WinningLotto(parseInts(split(lastWinningNumbers)), bonusBall);
        int size = lottos.size();
        for (int i = 0; i < size; i++) {
            calRanks(numbers, lottos.get(i));
        }
        countRank(ranks);
    }

    private void calRanks(WinningLotto winningLotto, UserLotto userLotto) {
        try {
            ranks.add(winningLotto.checkTheWinningNumbers(userLotto));
        } catch (IllegalArgumentException iae) {
        }
    }

    public int countOfLotto() {
        return price / 1000;
    }

    private String[] split(String text) {
        return text.split("(, )");
    }

    private List<Integer> parseInts(String[] numbersText) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberText : numbersText) {
            int a = parseInt(numberText);
            numbers.add(a);
        }
        return numbers;
    }

    private int parseInt(String numberText) {
        return Integer.parseInt(numberText);
    }

    private Map<Rank, Integer> countRank(List<Rank> ranks) {
        for (Rank rank : ranks) {
            ranksCount.put(rank, ranksCount.get(rank) + 1);
        }
        return ranksCount;
    }
}
