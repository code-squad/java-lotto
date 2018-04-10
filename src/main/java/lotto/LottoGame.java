package lotto;

import java.util.*;

public class LottoGame {
    private static final int FIFTH_LOTTO_MATCH_NUMBER = 3;

    List<Lotto> lottos;

    public LottoGame(int money) {
        lottos = LottoStore.buyLotto(money);
    }

    public GameResult play(List<Integer> winningNumber) {
        Lotto winLotto = new Lotto(winningNumber);

        GameResult result = new GameResult();

        for (Lotto lotto : lottos) {
            saveWinResult(result, lotto, howManyMatchCount(lotto, winLotto));
        }
        return result;
    }

    private void saveWinResult(GameResult result, Lotto lotto, int matchCount) {
        if (isWinMatch(matchCount)) {
            result.saveGameResult(matchCount, lotto);
        }
    }

    private static boolean isWinMatch(int matchCount) {
        return matchCount >= FIFTH_LOTTO_MATCH_NUMBER;
    }

    static int howManyMatchCount(Lotto target, Lotto source) {
        int count = 0;
        for (int number : source.numbers) {
            if (isContains(target, number)) {
                ++count;
            }
        }
        return count;
    }

    private static boolean isContains(Lotto target, int number) {
        return target.numbers.contains(number);
    }
}
