package lotto.domain;

import lotto.dto.WinningDTO;
import lotto.util.RandomUtils;

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

    public WinningDTO checkWinning(List<Integer> luckyNumbers){
        Lotto lucky = new Lotto(luckyNumbers);

        for(Lotto lotto : lottos){
            lotto.matchLuckyNumbers(lucky);
        }

        return new WinningDTO(this.totalCost, this.lottos);
    }

    private List<Lotto> createLotto(int count){
        for(int i=0 ; i<count ; i++){
            lottos.add(new Lotto(RandomUtils.pickRandom(Lotto.TARGET_NUMBER, Lotto.LOTTO_PICK_COUNT)));
        }

        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
