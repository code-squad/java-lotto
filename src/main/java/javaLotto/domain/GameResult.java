package javaLotto.domain;

import java.util.*;

public class GameResult {
    private static List<Result> results = new ArrayList<>();
    private static Map<Rank, Integer> map = new HashMap<>();

    public GameResult(List<Result> result) {
        this.results = result;
        map.put(Rank.FIRST, 0);
        map.put(Rank.SECOND, 0);
        map.put(Rank.THIRD, 0);
        map.put(Rank.FOURTH, 0);
        map.put(Rank.FIFTH, 0);
        map.put(Rank.MISS, 0);
    }

    public static int getPercent(int inputPrice) {
        int totalPrice = 0;
        for (Result result : results) {
            totalPrice += Result.returnMoney(result);
        }
        return totalPrice / inputPrice * 100;
    }

    public static List<Statics> getGrade() {
        List<Statics> statics = new ArrayList<>();
        resultDivide();
        addList(statics);
        return statics;
    }

    private static void addList(List<Statics> statics) {
        for (Rank rank : Rank.values()) {
            statics.add(new Statics(rank, map.get(rank)));
        }
    }

    private static void resultDivide() {
        for (Result result : results) {
            map.put(result.getRank(), map.get(result.getRank()) + 1);
        }
    }
}
