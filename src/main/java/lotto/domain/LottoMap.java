package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMap {
   private static Map<Integer, Integer> map = new HashMap<>();

    public LottoMap() {
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
    }

    public void saveCountWinLotto(int count) {
        int tmp = map.get(count);
        map.put(count, ++tmp);
    }

    public Map getMap() {
        return map;
    }
}

