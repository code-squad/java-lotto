package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int inputMoney(Scanner sc){
        System.out.println("구매 금액을 입력해주세요.");
        return Integer.valueOf(sc.nextLine());
    }

    public static String inputLuckyNumbers(Scanner sc) {
        System.out.println("지난 주 담청 번호를 입력하세요.");
        return sc.nextLine();
    }
}
