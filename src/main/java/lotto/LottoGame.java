package lotto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.LottoInput.inputLastWeekNumber;
import static lotto.LottoInput.startLotto;


/**
 * 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
 * 로또 1장의 가격은 1000원이다.
 * 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
 */

public class LottoGame {

    public static void main(String[] args) {
        int price = startLotto();
        int times = price / 1000;

        System.out.println(times + "개를 구매했습니다.");

        List<Lotto> selectedLottos = new ArrayList<>();
        GenerateLottoNumber gl = new GenerateLottoNumber();


        for (int i = 0; i < times; i++) {
            Lotto lotto = gl.generateRandomNumber();

            final String singleLotto =
            Stream.of(lotto)
                    .flatMap(obj -> obj.getSelectedNumbers().stream())
                    .map(num -> Integer.toString(num))
                    .collect(Collectors.joining(", ", "[", "]"));

            System.out.println(singleLotto);

            selectedLottos.add(lotto);
        }

        showResult(saveResult(selectedLottos, inputLastWeekNumber(), new GameResult()), price);

    }

    public static List<Integer> matchNumber(Lotto result, final String[] arr) {

        int[] ints = convertStringArrayToIntArray(arr);

        return Stream.of(result)
                .flatMap(lotto -> lotto.getSelectedNumbers().stream())
                .filter(num -> assertMatch(ints, num))
                .collect(Collectors.toList());
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

    private static void showResult(GameResult result, int price) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + result.getMatch_three().size() + "개");
        System.out.println("4개 일치 (50000원)- " + result.getMatch_four().size() + "개");
        System.out.println("5개 일치 (1500000원)- " + result.getMatch_five().size() + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.getMatch_six().size() + "개");

        System.out.println("총 수익률은 " + getEarnRate(((double) result.getEarnedMoney()), (double) price) + "%입니다");
    }

    public static long getEarnRate(double earned, double price) {
        return ((long) ((earned / price) * 100));
    }

}
