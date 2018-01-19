package lotto.io;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.util.LottoUtil;
import lotto.util.LottoVendor;

import java.util.ArrayList;
import java.util.List;
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

    public static Lotto inputManualLotto(String text) {
        if (text!=null) {
            System.out.println(text);
        }
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        while(!LottoUtil.canLotto(numbers)) {
            if (text!=null) {
                System.out.println(text);
            }
            numbers = scanner.nextLine();
        }
        if (text!=null) {
            System.out.println();
        }
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

    public static Lotteries inputManualLotteries(int makeCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottoList = new ArrayList<>();
        while(lottoList.size() != makeCount) {
            lottoList.add(inputManualLotto(null));
        }
        return new Lotteries(lottoList);
    }

    public static int orderCountByUser(int limit) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        while(isOverLimit(number, limit)) {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            number = scanner.nextLine();
        }
        return Integer.parseInt(number);
    }

    private static boolean isOverLimit(String number, int limit) {
        if (!LottoUtil.isNumeric(number)) return true;
        return limit < Integer.parseInt(number);
    }
}