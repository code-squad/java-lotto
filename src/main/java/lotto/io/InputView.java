package lotto.io;

import lotto.util.LottoUtil;

import java.util.Scanner;

public class InputView {
    public static String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String money = scanner.nextLine();

        while(!LottoUtil.isNumeric(money) || Integer.parseInt(money) < 1000) {
            System.out.println("구입금액을 입력해 주세요.");
            money = scanner.nextLine();
        }
        System.out.println(String.format("%s", money));
        return money;
    }

    public static String inputLastLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        while(!LottoUtil.canParsing(numbers)) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            numbers = scanner.nextLine();
        }
        System.out.println();
        return numbers;
    }
}
