package enums;

import java.util.*;
import java.util.stream.Collectors;

public enum WinningRules {
    NONE(0, 0),
    ONE_MATCHING(1, 0),
    TWO_MATCHING(2, 0),
    THREE_MATCHING(3, 5000),
    FOUR_MATCHING(4, 50000),
    FIVE_MATCHING(5, 150000),
    SIX_MATCHING(6, 200000000);

    private Integer matchCount;
    private Integer reward;
    private static Map<Integer, WinningRules> winningRules;

    static{

        winningRules = new HashMap<>();
        winningRules.put(0, WinningRules.NONE);
        winningRules.put(1, WinningRules.ONE_MATCHING);
        winningRules.put(2, WinningRules.TWO_MATCHING);
        winningRules.put(3, WinningRules.THREE_MATCHING);
        winningRules.put(4, WinningRules.FOUR_MATCHING);
        winningRules.put(5, WinningRules.FIVE_MATCHING);
        winningRules.put(6, WinningRules.SIX_MATCHING);

    }

    WinningRules(Integer matchCount, Integer reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static WinningRules findByMatchCount(Integer key) {
        return winningRules.get(key);
    }

    public static Map<WinningRules, Integer> getNewKeyMap() {
        Map<WinningRules, Integer> winningRulesKeyMap =new HashMap<>();

        winningRulesKeyMap.put(WinningRules.THREE_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.FOUR_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.FIVE_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.SIX_MATCHING, 0);

        return winningRulesKeyMap;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public Integer getReward() {
        return reward;
    }
}
