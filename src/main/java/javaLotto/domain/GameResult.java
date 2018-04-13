package javaLotto.domain;

import java.util.*;

public class GameResult {
    private static List<Result> results = new ArrayList<>();

    public GameResult(List<Result> result) {
        this.results = result;
    }

    public List<Result> getResult() {
        return results;
    }

    public static int getPercent(int inputPrice) {
        int totalPrice = 0;
        for (Result results : results) {
            totalPrice += results.getRank().getWinningMoney();
        }
        return totalPrice / inputPrice * 100;
    }

    public static List<Statics> getGrade() {
        List<Statics> statics = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        //todo if문 제거
        for (Result result : results) {
            if (result.match(Rank.FIFTH.getCountOfMatch())) map.put(5, map.get(5) + 1);
            if (result.match(Rank.FOURTH.getCountOfMatch())) map.put(4, map.get(4) + 1);
            if (result.match(Rank.THIRD.getCountOfMatch()) && result.getRank().isBonus() == false)
                map.put(3, map.get(3) + 1);
            if (result.match(Rank.SECOND.getCountOfMatch()) && result.getRank().isBonus() == true)
                map.put(2, map.get(2) + 1);
            if (result.match(Rank.FIRST.getCountOfMatch())) map.put(1, map.get(1) + 1);

        }
        statics.add(new Statics(Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), map.get(1)));
        statics.add(new Statics(Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), map.get(2)));
        statics.add(new Statics(Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), map.get(3)));
        statics.add(new Statics(Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), map.get(4)));
        statics.add(new Statics(Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), map.get(5)));

        return statics;
    }

}
