package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {

    public static Map<Integer, List<Lotto>> getWinnerLottos(List<Lotto> lottos, List<Integer> winnigNums) {
        Map<Integer, List<Lotto>> winnersLottos = initWinnersLottos();

        for(Lotto lotto : lottos)
            checkWinnigLotto(winnigNums, winnersLottos , lotto);

        return winnersLottos;
    }

    private static Map<Integer, List<Lotto>> initWinnersLottos() {
        Map<Integer, List<Lotto>> winnersLottos = new HashMap<>();
        for(int i = 3 ; i <= 6 ; ++i)
            winnersLottos.put(i, new ArrayList<Lotto>());

        return winnersLottos;
    }

    private static void checkWinnigLotto(List<Integer> winnigNums, Map<Integer, List<Lotto>> resultMap, Lotto lotto) {
        int correspond = lotto.howManyCorrespond(winnigNums);
        if(correspond >= 3)
            putLottoInResultMap(resultMap, lotto, correspond);
    }

    private static void putLottoInResultMap(Map<Integer, List<Lotto>> resultMap, Lotto lotto, int correspond) {
        if(!resultMap.containsKey(correspond))
            resultMap.put(correspond, new ArrayList<Lotto>());

        resultMap.get(correspond).add(lotto);
    }
}
