package view;

import domain.LottoGame;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final int PRICE = 1000;

    public static int inputMoney(Scanner sc){
        System.out.println("구매 금액을 입력해주세요.");
        int inputValue = Integer.valueOf(sc.nextLine());
        OutputView.printAmountLotto(LottoGame.amountOfLotto(inputValue));
        return inputValue;
    }

    public static String inputLuckyNumbers(Scanner sc) {
        System.out.println("지난 주 담청 번호를 입력하세요.");
        return sc.nextLine();
    }

    public static int inputBonusNumber(Scanner sc){
        System.out.println("보너스 볼을 입력해주세요.");
        return Integer.valueOf(sc.nextLine());
    }
}
