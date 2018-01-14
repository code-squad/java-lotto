package domain;

import enums.LottoPrize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {
    public static Map<LottoPrize, Integer> getWinnerLottos(List<Lotto> lottos, WinningNumber winningNumber) {
        Map<LottoPrize, Integer> winnersLottos = initWinnersLottos();

        for(Lotto lotto : lottos)
            checkWinnigLotto(winningNumber, winnersLottos , lotto);

        return winnersLottos;
    }

    public static Map<LottoPrize, Integer> initWinnersLottos() {
        Map<LottoPrize, Integer> winnersLottos = new HashMap<>();
        for(LottoPrize prize : LottoPrize.values())
            winnersLottos.put(prize, 0);

        return winnersLottos;
    }

    public static void checkWinnigLotto(WinningNumber winningNumber, Map<LottoPrize, Integer> resultMap, Lotto lotto) {
        int numOfCorrespond = lotto.howManyCorrespond(winningNumber.getWinningLottos());
        boolean matchBonusNum = lotto.isBonusNumMatch(winningNumber.getBonusNum());

        if(numOfCorrespond >= 3) {
            LottoPrize prize = LottoPrize.valueOf(numOfCorrespond, matchBonusNum);
            putLottoInResultMap(resultMap, prize);
        }
    }

    private static void putLottoInResultMap(Map<LottoPrize, Integer> resultMap, LottoPrize prize) {
        resultMap.put(prize, resultMap.get(prize) + 1);
    }
}
