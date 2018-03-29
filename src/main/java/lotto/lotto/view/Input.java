package lotto.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static int inputMoney() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = scan.nextInt();

        moneyCheckException(money);
        return money / 1000;
    }

    public static List<Integer> inputWinningNumber() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scan2.nextLine();

        return divideNum(numbers.split(","));
    }

    public static List<Integer> divideNum(String[] numbers) {
        List<Integer> lotto = new ArrayList<>();

        notLottoException(numbers);
        for (String num : numbers) {
            int oneNumber = intOf(num);
            overException(oneNumber);
            lotto.add(oneNumber);
        }
        return lotto;
    }

    public static int intOf(String num) {
        return Integer.parseInt(num.trim());
    }

    public static void overException(int lottoNumber) {
        if (lottoNumber<1 && 45<lottoNumber)
            throw new IllegalArgumentException("1부터 45까지만 입력해 주세요.");
    }

    public static void notLottoException(String[] numbers) {
        if (numbers.length != 6)
            throw new IllegalArgumentException("당첨 번호가 잘못 입력 되었습니다");
    }

    public static void moneyCheckException(int money) {
        if (money < 1000)
            throw new IllegalArgumentException("돈이 부족합니다.");
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요");
        }
    }

}
