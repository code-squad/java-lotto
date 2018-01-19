package lotto.domain;

import lotto.dto.WinningDTO;
import lotto.type.WinningType;

import java.util.*;

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

    public WinningDTO checkWinning(WinningLotto wLotto){
        EnumMap<WinningType, Integer> result = createResult();
        for(Lotto lotto : lottos){
            updateResult(result, matchLotto(wLotto, lotto));
        }

        return new WinningDTO(totalCost, result);
    }

    public WinningType matchLotto(WinningLotto wLotto, Lotto lotto){
        return WinningType.parse(wLotto.match(lotto), wLotto.isBonus(lotto));
    }

    private void updateResult(EnumMap<WinningType, Integer> result, WinningType type){
        int count = result.get(type);
        result.put(type, count+1);
    }

    private EnumMap<WinningType, Integer> createResult(){
        EnumMap<WinningType, Integer> result = new EnumMap<>(WinningType.class);
        for(WinningType type : WinningType.values()){
            result.put(type, 0);
        }

        return result;
    }

    private List<Lotto> createLotto(int count){
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

}
