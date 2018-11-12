package domain;


import java.util.HashMap;
import java.util.Map;

public class LottoryManager {
    private Map<Rank, Integer> rankMap = new HashMap<>();
    private Money money;

    private LottoryManager(Money money) {
        // key 로또와 당첨번호와 같은 개수, value 등수와 같은 자동로또 수
        for (Rank type : Rank.values()) {
            rankMap.put(type, 0);
        }
        this.money = money;
    }

    void increase(int count, boolean bonus) {
        if (count >= 3 && count <= 6) {
            rankMap.put(Rank.valueOf(count, bonus), rankMap.get(Rank.valueOf(count, bonus)) + 1);
        }
    }

    static LottoryManager ofInt(int input) {
        return new LottoryManager(Money.of(input));
    }

    static LottoryManager of(Money input) {
        return new LottoryManager(input);
    }


    public long yield() {
        for (Rank rank : rankMap.keySet()) {
            money.increase(rank.multiplicationMoney(findRank(rank)));
        }
        return money.yield();
    }


    public int findRank(Rank value) {
        return rankMap.get(value);
    }

    public int count() {
        return money.count();
    }
}



