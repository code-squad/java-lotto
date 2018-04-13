package lotto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.LottoInput.inputLastWeekNumber;
import static lotto.LottoInput.startLotto;
import static lotto.ResultView.printSingleLotto;
import static lotto.ResultView.showAmount;
import static lotto.ResultView.showResult;


/**
 * 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
 * 로또 1장의 가격은 1000원이다.
 * 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
 */

public class LottoGame {

    public static void main(String[] args) {
        int price = startLotto();
        int times = price / 1000;

        showAmount(times);

        List<Lotto> selectedLottos = new ArrayList<>();
        GenerateLottoNumber gl = new GenerateLottoNumber();

        ArrayList<Integer> range = gl.getNumberRange();

        for (int i = 0; i < times; i++) {
            Lotto lotto = gl.generateRandomNumber(range);

            if (lotto == null) continue;

            printSingleLotto(lotto);

            selectedLottos.add(lotto);
        }

        showResult(saveResult(selectedLottos, inputLastWeekNumber(), new GameResult()), price);

    }

    public static List<Integer> matchNumber(Lotto result, final String[] arr) {

        int[] ints = convertStringArrayToIntArray(arr);

        return result.getMatchNumberList(ints);
    }

    public static int[] convertStringArrayToIntArray(String[] strs) {
        return Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean assertMatch(int[] ints, int num) {
        for (int i : ints) {
            if (i == num) return true;
        }

        return false;
    }

    public static GameResult saveResult(List<Lotto> selectedLottos, String[] lastWeekNumber, GameResult result) {
        for (Lotto lotto : selectedLottos) {
            List<Integer> result_list =  matchNumber(lotto, lastWeekNumber);

            switch (result_list.size()) {
                case 6:
                    result.addMatch_six(result_list);
                    break;
                case 5:
                    result.addMatch_five(result_list);
                    break;
                case 4:
                    result.addMatch_four(result_list);
                    break;
                case 3:
                    result.addMatch_three(result_list);
                    break;
            }

        }

        return result;
    }

    public static long getEarnRate(double earned, double price) {
        return ((long) ((earned / price) * 100));
    }

}
