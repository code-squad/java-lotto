package lotto.dto;

import lotto.type.WinningType;

import java.util.EnumMap;

public class WinningDTO {
    private int totalCost;
    private EnumMap<WinningType, Integer> result;

    public WinningDTO(int totalCost, EnumMap<WinningType, Integer> result){
        this.totalCost = totalCost;
        this.result = result;

    }

    public int getTotalPrizes(){
        int totalPrizes = 0;
        for(WinningType type : WinningType.values()){
            totalPrizes += result.get(type) * type.getPrizes();
        }

        return totalPrizes;
    }

    public int getWinningCount(WinningType type){
        return result.get(type);
    }

    public int getEarningsRate(){
        double totalEarnings = getTotalPrizes() - totalCost;

        return (int) (totalEarnings / totalCost * 100);
    }

}
