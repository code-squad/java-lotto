package lotto.domain;


import lotto.domain.GameResult;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;


/**
 * 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
 * 로또 1장의 가격은 1000원이다.
 * 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
 */

public class LottoGame {

    List<Lotto> selectedLottos;

    String[] lastWeekNumber;

    int bonus;

    public LottoGame(List<Lotto> selectedLottos, String[] lastWeekNumber, int bonus) {
        this.selectedLottos = selectedLottos;
        this.lastWeekNumber = lastWeekNumber;
        this.bonus = bonus;
    }

    public Lotto matchNumber(Lotto result, final String[] arr) {

        int[] ints = convertStringArrayToIntArray(arr);

        return result.getMatchNumber(ints, bonus);
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
            Lotto result_lotto =  matchNumber(lotto, lastWeekNumber);

            switch (result_lotto.getRank()) {
                case FIRST:
                    result.addFirstRank(result_lotto);
                    break;
                case SECOND:
                    result.addSecondRank(result_lotto);
                    break;
                case THIRD:
                    result.addThirdRank(result_lotto);
                    break;
                case FOURTH:
                    result.addFourthRank(result_lotto);
                    break;
                case FIFTH:
                    result.addFifthRank(result_lotto);
                    break;
                default:
                    result.addMiss(result_lotto);
            }

        }

        return result;
    }

    public static long getEarnRate(double earned, double price) {
        return ((long) ((earned / price) * 100));
    }

}
