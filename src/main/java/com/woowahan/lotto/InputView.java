package com.woowahan.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<Integer> inputLuckyNumbers() {
        List<Integer> luckyNumbers = new ArrayList<>();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        for (String luckyNumber : scanner.nextLine().split(",")) {
            luckyNumbers.add(Integer.parseInt(luckyNumber.trim()));
        }

        return luckyNumbers;
    }
}
