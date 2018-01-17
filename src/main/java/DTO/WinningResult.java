package DTO;

import domain.lotto.LottoTicket;
import enums.WinningRules;

import java.util.*;

public class WinningResult {
    private static final Integer WINNING_RESTRICTION_NUMBER = 2;

    private Integer inputMoney;
    private Integer winningMoney;
    private Integer winningPercent;
    private Map<WinningRules, Integer> counts;

    public WinningResult(Integer inputMoney, LottoTicket winningTicket, List<LottoTicket> purchasedLottoTicket) {
        Map<WinningRules, Integer> countRules = this.countRules(this.findMatching(winningTicket, purchasedLottoTicket));
        this.inputMoney = inputMoney;
        this.counts = countRules;
        this.winningMoney = this.calculateWinningMoney(countRules);
        this.winningPercent = this.calculateWinningPercent(Float.intBitsToFloat(this.inputMoney)
                , Float.intBitsToFloat(this.winningMoney));
    }

    public List<WinningRules> findMatching(LottoTicket winningTicket, List<LottoTicket> purchasedLottoTicket) {
        List<WinningRules> machingRules = new ArrayList<>();

        for (LottoTicket ticket : purchasedLottoTicket) {
            WinningRules matchedRule = ticket.winningMaching(winningTicket.getNumbers());
            if (matchedRule.getMatchCount() > this.WINNING_RESTRICTION_NUMBER)
                machingRules.add(matchedRule);
        }

        return machingRules;
    }

    public Map<WinningRules, Integer> countRules(List<WinningRules> rules) {

        Map<WinningRules, Integer> counts = WinningRules.getNewKeyMap();

        for (WinningRules rule : rules) {
            if (counts.get(rule) == 0) {
                counts.put(rule, 1);
                continue;
            }
            counts.put(rule, counts.get(rule) + 1);
        }

        return counts;
    }

    private Integer calculateWinningMoney(Map<WinningRules, Integer> countRules) {
        return countRules.entrySet().stream().mapToInt(value -> value.getKey().getReward() * value.getValue()).sum();
    }

    public int calculateWinningPercent(float payedMoney, float winningMoney) {
        return (int) (((winningMoney - payedMoney) / payedMoney) * 100);
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

        builder.append("총 수익률은 " + this.winningPercent + "% 입니다.");
        return builder.toString();
    }
}
