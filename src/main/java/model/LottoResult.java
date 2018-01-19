package model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    Map<ResultTypes, Integer> map;

    public LottoResult(){
        this.map = new HashMap<>();
    }

    private void put(ResultTypes key, Integer value){
        map.put(key, value);
    }

    private boolean containsKey(ResultTypes key){
        return map.containsKey(key);
    }

    public void matchLotto(WinningLotto winningLotto, Lotto lotto){
        ResultTypes key = winningLotto.compare(lotto);

        if (!this.map.containsKey(key)) {
            this.map.put(key, 1);
            return;
        }

        this.map.put(key, this.map.get(key) + 1);
    }

    public long getPrize() {
        long prizeSum = 0;

        for(ResultTypes type : this.map.keySet()) {
            prizeSum += type.calculatePrize(this.map.get(type));
        }

        return prizeSum;
    }
}
