package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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

    public static Map<Rank, Integer> combinedByRank(Map<Lotto, Rank> lottoRankMap) {
        Map<Rank, Integer> combinedMap = new HashMap();
        Integer cnt = 0;

        for (Rank rank: Rank.values()){
            for (Lotto lotto : lottoRankMap.keySet()) {
                if(lottoRankMap.get(lotto) == rank){
                    cnt ++;
                }
            }
            combinedMap.put(rank, cnt);
        }

        return putAllRank(combinedMap);
    }

    private static Map<Rank, Integer> putAllRank(Map<Rank, Integer> combinedMap) {
        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            if (!combinedMap.containsKey(rank)){
                combinedMap.put(rank, 0);
            }
        }

        return combinedMap;
    }
}
