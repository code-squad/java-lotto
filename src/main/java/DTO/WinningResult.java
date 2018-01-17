package DTO;

import domain.lotto.LottoTicket;
import enums.WinningRules;

import java.util.*;

public class WinningResult {
    private static final Integer WINNING_RESTRICTION_NUMBER = 2;

    private Integer winningPercent;
    private Map<WinningRules, Integer> counts;

    public WinningResult(Integer inputMoney, LottoTicket winningTicket, List<LottoTicket> purchasedLottoTicket) {
        this.counts  = this.countRules(this.findMatching(winningTicket, purchasedLottoTicket));

        this.winningPercent = this.calculateWinningPercent(
                Float.intBitsToFloat(inputMoney)
                , Float.intBitsToFloat(this.calculateWinningMoney(counts))
        );
    }

    public List<WinningRules> findMatching(LottoTicket winningTicket, List<LottoTicket> purchasedLottoTicket) {
        List<WinningRules> machingRules = new ArrayList<>();

        for (LottoTicket ticket : purchasedLottoTicket) {
            WinningRules matchedRule = getMatchedRule(winningTicket, ticket);

            if (isAddAble(matchedRule))
                machingRules.add(matchedRule);
        }

        return machingRules;
    }

    private boolean isAddAble(WinningRules matchedRule) {
        return matchedRule.getMatchCount() > WINNING_RESTRICTION_NUMBER;
    }

    private WinningRules getMatchedRule(LottoTicket winningTicket, LottoTicket ticket) {
        return ticket.winningMaching(winningTicket.getNumbers());
    }

    public Map<WinningRules, Integer> countRules(List<WinningRules> rules) {

        Map<WinningRules, Integer> counts = WinningRules.getNewKeyMap();

        for (WinningRules rule : rules) {
            counts.put(rule, counts.get(rule) + 1);
        }

        return counts;
    }

    public Integer calculateWinningMoney(Map<WinningRules, Integer> countRules) {
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
