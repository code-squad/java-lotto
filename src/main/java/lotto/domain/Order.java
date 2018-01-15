package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int totalCost;
    private List<Lotto> lottos;

    public Order(int totalCost){
        if(totalCost < Lotto.LOTTO_COST){
            throw new IllegalArgumentException("구매금액이 잘못되었습니다.");
        }

        this.totalCost = totalCost;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> purchase() {
        return createLotto(totalCost / Lotto.LOTTO_COST);
    }

    public List<Lotto> checkWinning(int[] luckyNumbers){
        if(luckyNumbers.length < Lotto.LOTTO_PICK_COUNT){
            throw new IllegalArgumentException("당첨번호가 잘못되었습니다.");
        }

        for(Lotto lotto : lottos){
            lotto.matchLuckyNumbers(luckyNumbers);
        }

        return lottos;
    }

    private List<Lotto> createLotto(int count){
        for(int i=0 ; i<count ; i++){
            lottos.add(new Lotto());
        }

        return lottos;
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
