package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class WinningDTO {
    private int totalCost;
    private List<Lotto> lottos;

    public WinningDTO(int totalCost, List<Lotto> lottos){
        this.totalCost = totalCost;
        this.lottos = lottos;

    }

    public int getTotalPrizes(){
        int totalPrizes = 0;
        for(Lotto lotto : lottos){
            totalPrizes += lotto.getWinningPrizes();
        }

        return totalPrizes;
    }

    public int getEarningsRate(){
        double totalEarnings = getTotalPrizes() - totalCost;

        return (int) (totalEarnings / totalCost * 100);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
