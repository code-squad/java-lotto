package lotto.domain;

import lotto.dto.WinningDTO;
import lotto.type.WinningType;

import java.util.*;

public class Order {

    private List<Lotto> lottos;

    public Order(int totalCost){
        if(totalCost < Lotto.LOTTO_COST){
            throw new IllegalArgumentException("구매금액이 잘못되었습니다.");
        }

        this.lottos = createLotto(totalCost / Lotto.LOTTO_COST);
    }

    public WinningDTO checkWinning(WinningLotto wLotto){
        WinningDTO result = new WinningDTO(getTotalCost());

        for(Lotto lotto : lottos){
            result.update(matchLotto(wLotto, lotto));
        }

        return result;
    }

    public WinningType matchLotto(WinningLotto wLotto, Lotto lotto){
        return WinningType.parse(wLotto.match(lotto), wLotto.isBonus(lotto));
    }

    private List<Lotto> createLotto(int count){
        lottos = new ArrayList<>();
        for(int i=0 ; i<count ; i++) {
            lottos.add(new Lotto(getTarget().subList(0, Lotto.LOTTO_PICK_COUNT)));
        }

        return lottos;
    }

    private List<Integer> getTarget() {
        List<Integer> target = new ArrayList<>();
        for(int t = Lotto.LOTTO_MIN_NUMBER; t<Lotto.LOTTO_MAX_NUMBER ; t++) {
            target.add((t+1));
        }

        Collections.shuffle(target);
        return target;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getTotalCost() {
        return lottos.size() * Lotto.LOTTO_COST;
    }
}
