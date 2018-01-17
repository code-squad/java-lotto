package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
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

    public static Lotto inputLastLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        while(!LottoUtil.canLotto(numbers)) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            numbers = scanner.nextLine();
        }
        System.out.println();
        return new Lotto(numbers);
    }

    public static LottoNumber inputLuckyNumber(Lotto lotto) {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String luckyNumber = scanner.nextLine();
        while(!LottoUtil.canLottoNumber(luckyNumber) && lotto.contains(new LottoNumber(luckyNumber))) {
            System.out.println("보너스 볼을 입력해 주세요.");
            luckyNumber = scanner.nextLine();
        }
        System.out.println();
        return new LottoNumber(luckyNumber);
    }
}
