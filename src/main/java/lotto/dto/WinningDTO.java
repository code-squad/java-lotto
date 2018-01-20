package lotto.dto;

import lotto.type.WinningType;

import java.util.EnumMap;

public class WinningDTO {
    private int totalCost;
    private EnumMap<WinningType, Integer> result;

    public WinningDTO(int totalCost){
        this.totalCost = totalCost;
        this.result = createResult();

    }

    public void update(WinningType type){
        int count = result.get(type);
        result.put(type, count+1);
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

    private EnumMap<WinningType, Integer> createResult(){
        result = new EnumMap<>(WinningType.class);
        for(WinningType type : WinningType.values()){
            result.put(type, 0);
        }

        return result;
    }

}
