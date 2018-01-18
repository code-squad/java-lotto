package model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LottoMapStrategy {
    public static Map<Rank, Integer> sortMap(Map<Rank, Integer> unsortedMap) {
        Map<Rank, Integer> sortedMap = new LinkedHashMap();
        TreeMap<Rank,Integer> treeMap = new TreeMap(Collections.reverseOrder());
        treeMap.putAll(unsortedMap);

        for (Rank rank : treeMap.keySet()) {
            sortedMap.put(rank, treeMap.get(rank));
        }

        return sortedMap;
    }
}
