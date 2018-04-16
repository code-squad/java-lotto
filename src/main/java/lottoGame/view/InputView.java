package lottoGame.view;

import lottoGame.domain.Lotto;

import java.util.*;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static int inputBonusLottoBall() {
        System.out.println("보너스 볼을 입력해 주세요");
        return Integer.valueOf(sc.nextLine());
    }

    public static int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주새요.");
        return Integer.valueOf(sc.nextLine());
    }

    public static Set<Integer> inputLuckyNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Set<Integer> luckyNums = new HashSet<>();
        int i = 0;
        for(String luckNum:sc.nextLine().split(", ")) {
            luckyNums.add(Integer.valueOf(luckNum));
        }
        return luckyNums;
    }
}
