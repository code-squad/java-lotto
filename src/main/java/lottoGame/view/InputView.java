package lottoGame.view;

import lottoGame.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주새요.");
        return Integer.valueOf(sc.nextLine());
    }

    public static List<Integer> inputLuckyNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> luckyNums = new ArrayList<>();
        int i = 0;
        for(String luckNum:sc.nextLine().split(", ")) {
            luckyNums.add(Integer.valueOf(luckNum));
        }
        return luckyNums;
    }
}
