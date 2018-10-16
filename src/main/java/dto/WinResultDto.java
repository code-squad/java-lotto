package dto;

import domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class WinResultDto {

    private Map<Rank, Integer> winResultDto;

    private WinResultDto(Map<Rank, Integer> winResultDto) {
        this.winResultDto = winResultDto;
    }

    public static WinResultDto init() {
        return new WinResultDto(initValues());
    }

    private static Map<Rank, Integer> initValues() {
        Map<Rank, Integer> winResultDto = new HashMap<>();

        winResultDto.put(Rank.FIRST, 0);
        winResultDto.put(Rank.SECOND, 0);
        winResultDto.put(Rank.THIRD, 0);
        winResultDto.put(Rank.FOURTH, 0);
        winResultDto.put(Rank.NONE, 0);

        return winResultDto;
    }

    public void setRankAmt(Rank rank) {
        int amt = this.winResultDto.remove(rank);

        this.winResultDto.put(rank, ++amt);
    }

    public Map<Rank, Integer> getWinResultDto() {
        return this.winResultDto;
    }

    public int getYield(int purchaseAmt) {
        return getRevenue() / purchaseAmt;
    }

    private int getRevenue() {
        int sum = 0;
        for (Rank rank : winResultDto.keySet()) {
            sum += rank.getReward() * this.winResultDto.get(rank);
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Rank rank : winResultDto.keySet()) {
            sb.append(" (" + rank + " : " + this.winResultDto.get(rank) + ") ");
        }
        sb.append("}");

        return sb.toString();
    }

}
