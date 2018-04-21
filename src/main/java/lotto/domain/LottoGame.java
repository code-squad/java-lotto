package lotto.domain;


import java.util.Arrays;
import java.util.List;

/**
 * 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
 * 로또 1장의 가격은 1000원이다.
 * 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
 */

public class LottoGame {

    private List<Lotto> selectedLottos;

    private String[] lastWeekNumber;

    int bonus;

    public LottoGame(List<Lotto> selectedLottos, String[] lastWeekNumber, int bonus) {
        this.selectedLottos = selectedLottos;
        this.lastWeekNumber = lastWeekNumber;
        this.bonus = bonus;
    }

    public WinningLotto matchNumber(Lotto result) {
        return result.getWinningLotto(bonus);
    }

    public int[] convertStringArrayToIntArray(String[] strs) {
        return Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean assertMatch(int[] ints, int num) {
        for (int i : ints)
            if (i == num) return true;

        return false;
    }

    public GameResult saveResult(GameResult result) {
        for (Lotto lotto : selectedLottos) {
            WinningLotto winningLotto =  matchNumber(lotto);

            result.addWinningLotto(winningLotto.matchRank(convertStringArrayToIntArray(lastWeekNumber)));
        }

        return result;
    }

    public static long getEarnRate(double earned, double price) {
        return ((long) ((earned / price) * 100));
    }

}
