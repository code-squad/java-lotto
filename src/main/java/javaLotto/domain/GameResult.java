package javaLotto.domain;

import java.util.*;

public class GameResult {
    private static List<Result> results = new ArrayList<>();
    private static Map<String, Integer> map = new HashMap<>();

    public GameResult(List<Result> result) {
        this.results = result;
        map.put(Rank.FIRST.name(),0);
        map.put(Rank.SECOND.name(),0);
        map.put(Rank.THIRD.name(),0);
        map.put(Rank.FOURTH.name(),0);
        map.put(Rank.FIFTH.name(),0);
        map.put(Rank.MISS.name(),0);
    }

    public static int getPercent(int inputPrice) {
        int totalPrice = 0;
        for (Result result : results) {
            totalPrice += result.getRank().getWinningMoney();
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
        for(Rank rank : Rank.values()){
          statics.add(new Statics(rank , map.get(rank.name())));

        }
    }

    private static void resultDivide() {
        for (Result result : results) {
            map.put(result.getRank().name() , map.get(result.getRank().name())+1);
        }
    }
}
