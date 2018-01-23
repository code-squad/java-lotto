package lotto.domain;


import lotto.dto.WinningDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Order {

    private int customLottoCount;
    private Lottos lottos;

    public Order(int totalCost, List<String> customLottoNumber){
        if(totalCost < Lotto.COST){
            throw new IllegalArgumentException("구매금액이 잘못되었습니다.");
        }

        this.lottos = new Lottos();

        int totalCount = totalCost / Lotto.COST;

        Optional<List> listOptional = Optional.ofNullable(customLottoNumber);
        listOptional.orElseThrow(IllegalArgumentException::new);

        if(!customLottoNumber.isEmpty()){
            this.customLottoCount = createCustom(customLottoNumber);
        }

        createAuto(totalCount - customLottoNumber.size());
    }

    public int countOfCustomLotto(){
        return this.customLottoCount;
    }

    public int countOfLotto() {
        return lottos.size();
    }

    public WinningDTO checkWinning(WinningLotto wLotto){
        return lottos.match(wLotto);
    }

    private int createCustom(List<String> customLottoNumber){
        for(String text : customLottoNumber){
            lottos.add(new Lotto(text));
        }

        return lottos.size();
    }

    private void createAuto(int count){
        for(int i=0 ; i<count ; i++) {
            lottos.add(new Lotto(getTarget().subList(0, Lotto.PICK_COUNT)));
        }
    }

    private List<Integer> getTarget() {
        List<Integer> target = new ArrayList<>();
        for(int t = LottoNumber.MIN_NUMBER; t<LottoNumber.MAX_NUMBER; t++) {
            target.add((t+1));
        }

        Collections.shuffle(target);
        return target;
    }

    public Lottos getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
