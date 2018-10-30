package domain;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoryManager {

    private Map<Rank, Integer> rankMap = new HashMap<>();

    LottoryManager() {
        // key 로또와 당첨번호와 같은 개수, value 등수와 같은 자동로또 수
        for (Rank type : Rank.values()) {
            rankMap.put(type, 0);
        }
    }

    void increase(int count, boolean bonus) {
        if (count >= 3 && count <= 6) {
            rankMap.put(Rank.valueOf(count, bonus), rankMap.get(Rank.valueOf(count, bonus)) + 1);
        }
    }


    public long percent(int input) {
        return 100L * Arrays.stream(Rank.values())
                .mapToInt(value -> value.multiplicationMoney(ranking(value)))
                .sum() / input;
    }

    public int ranking(Rank value) {
        return rankMap.get(value);
    }
}



