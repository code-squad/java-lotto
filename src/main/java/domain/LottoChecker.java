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

    public static Map<Integer, List<Lotto>> initWinnersLottos() {
        Map<Integer, List<Lotto>> winnersLottos = new HashMap<>();
        for(int i = 3 ; i <= 6 ; ++i)
            winnersLottos.put(i, new ArrayList<Lotto>());

        return winnersLottos;
    }

    public static void checkWinnigLotto(List<Integer> winnigNums, Map<Integer, List<Lotto>> resultMap, Lotto lotto) {
        int numOfCorrespond = lotto.howManyCorrespond(winnigNums);
        if(numOfCorrespond >= 3)
            putLottoInResultMap(resultMap, lotto, numOfCorrespond);
    }

    private static void putLottoInResultMap(Map<Integer, List<Lotto>> resultMap, Lotto lotto, int numOfCorrespon) {
        resultMap.get(numOfCorrespon).add(lotto);
    }
}
