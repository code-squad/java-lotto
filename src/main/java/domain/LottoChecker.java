package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    public static Map<Integer, Integer> getWinnerLottos(List<Lotto> lottos, List<Integer> winnigNums) {
        Map<Integer, Integer> winnersLottos = initWinnersLottos();

        for(Lotto lotto : lottos)
            checkWinnigLotto(winnigNums, winnersLottos , lotto);

        return winnersLottos;
    }

    public static Map<Integer, Integer> initWinnersLottos() {
        Map<Integer, Integer> winnersLottos = new HashMap<>();
        for(int i = 3 ; i <= 6 ; ++i)
            winnersLottos.put(i, 0);

        return winnersLottos;
    }

    public static void checkWinnigLotto(List<Integer> winnigNums, Map<Integer, Integer> resultMap, Lotto lotto) {
        int numOfCorrespond = lotto.howManyCorrespond(winnigNums);
        if(numOfCorrespond >= 3)
            putLottoInResultMap(resultMap, numOfCorrespond);
    }

    private static void putLottoInResultMap(Map<Integer, Integer> resultMap, int numOfCorrespon) {
        resultMap.put(numOfCorrespon, resultMap.get(numOfCorrespon) + 1);
    }
}
