package dto;

import vo.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class LottosResult {
    private Map<Rank, Integer> rankCount;
    private double totalRateOfReturn;

    public LottosResult(Map<Rank, Integer> rankCount, double totalRateOfReturn) {
        this.rankCount = rankCount;
        this.totalRateOfReturn = totalRateOfReturn;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }

    public double getTotalRateOfReturn() {
        return totalRateOfReturn;
    }

    public List<String> getMessage() {
        List<String> resultMessage = new ArrayList<>();
        List<Rank> ranks = rankCount.keySet()
                .stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        for (Rank rank : ranks) {
            StringBuilder sb = new StringBuilder();
            sb.append(rank.getCountOfMatch())
                    .append("개 일치");
            if (rank.equals(Rank.SECOND)) sb.append(", 보너스 볼 일치");
            sb.append(" (")
                    .append(rank.getWinningMoney())
                    .append("원) ")
                    .append("- ")
                    .append(rankCount.get(rank))
                    .append("개\n");

            resultMessage.add(sb.toString());
        }
        return resultMessage;
    }
}
