package lotto.view;

import lotto.domain.InputTypeException;

import java.util.Scanner;

public class InputView {

    public static int buyLotto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        if (sc.hasNextInt()) {
            return checkBuyPrice(sc.nextInt());
        }
        throw new InputTypeException("구입 금액을 숫자로 입력해주세요");
    }

    public static int checkBuyPrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("구입 금액은 1,000원 이상입니다.");
        }
        return price;
    }

    public static String getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).next();
    }

    public static int getWinningBonusNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

}
