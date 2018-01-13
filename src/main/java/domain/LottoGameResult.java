package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {
    private List<Lotto> lottos;

    public LottoGameResult(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Integer, List<Lotto>> getResult(List<Integer> winnigNums) {
        Map<Integer, List<Lotto>> resultMap = new HashMap<>();
        for(Lotto lotto : lottos)
            checkWinnigLotto(winnigNums, resultMap, lotto);

        return resultMap;
    }

    private void checkWinnigLotto(List<Integer> winnigNums, Map<Integer, List<Lotto>> resultMap, Lotto lotto) {
        int correspond = lotto.howManyCorrespond(winnigNums);
        if(correspond >= 3)
            putLottoInResultMap(resultMap, lotto, correspond);
    }

    private void putLottoInResultMap(Map<Integer, List<Lotto>> resultMap, Lotto lotto, int correspond) {
        if(!resultMap.containsKey(correspond))
            resultMap.put(correspond, new ArrayList<Lotto>());

        resultMap.get(correspond).add(lotto);
    }
}
