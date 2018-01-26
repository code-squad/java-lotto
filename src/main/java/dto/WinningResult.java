package dto;

import domain.lotto.LottoNumber;
import enums.WinningRules;

import java.util.*;

public class WinningResult {
    public static final Integer WINNING_RESTRICTION_NUMBER = 2;

    private Integer winningPercent;
    private Map<WinningRules, Integer> counts;
    private static Map<Integer, WinningRules> winningRules;

    static {
        winningRules = new HashMap<>();
        winningRules.put(0, WinningRules.NONE);
        winningRules.put(1, WinningRules.NONE);
        winningRules.put(2, WinningRules.NONE);
        winningRules.put(3, WinningRules.THREE_MATCHING);
        winningRules.put(4, WinningRules.FOUR_MATCHING);
        winningRules.put(5, WinningRules.FIVE_MATCHING);
        winningRules.put(6, WinningRules.SIX_MATCHING);
    }

    public static WinningRules findByMatchCount(Integer key, boolean isBonus) {
        if(isBonus)
            return WinningRules.BONUS_MATCHING;

        return winningRules.get(key);
    }

    public WinningResult(Integer inputMoney, List<WinningRules> rules) {
        this.counts = this.countRules(rules);

        this.winningPercent = this.calculateWinningPercent(
                Float.intBitsToFloat(inputMoney)
                , Float.intBitsToFloat(this.calculateWinningMoney(counts))
        );
    }

    public Map<WinningRules, Integer> countRules(List<WinningRules> rules) {

        Map<WinningRules, Integer> rulesMap = getNewKeyMap();

        for (WinningRules rule : rules) {
            rulesMap.put(rule, rulesMap.get(rule) + 1);
        }

        return rulesMap;
    }

    public static Map<WinningRules, Integer> getNewKeyMap() {
        EnumMap<WinningRules, Integer> winningRulesKeyMap = new EnumMap<>(WinningRules.class);

        winningRulesKeyMap.put(WinningRules.THREE_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.FOUR_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.FIVE_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.BONUS_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.SIX_MATCHING, 0);

        return winningRulesKeyMap;
    }

    public Integer calculateWinningMoney(Map<WinningRules, Integer> countRules) {
        return countRules.entrySet().stream().mapToInt(value -> value.getKey().getReward() * value.getValue()).sum();
    }

    public int calculateWinningPercent(float payedMoney, float winningMoney) {
        return (int) (((winningMoney - payedMoney) / payedMoney) * 100);
    }

    public Integer getWinningPercent() {
        return winningPercent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        this.counts.forEach((rule, integer) -> {
            builder.append(rule.getMatchCount() + "개 일치 ("
                    + rule.getReward() + "원)- "
                    + this.counts.get(rule) + "개");
            builder.append("\n");
        });

        return builder.toString();
    }
}
