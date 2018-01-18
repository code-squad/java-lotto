package com.woowahan.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        return money;
    }

    public List<Integer> inputLuckyNumbers() {
        List<Integer> luckyNumbers = new ArrayList<>();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] inputNumbers = scanner.nextLine().split(",");
        for (String inputNumber : inputNumbers) {
            luckyNumbers.add(Integer.parseInt(inputNumber.trim()));
        }

        return luckyNumbers;
    }
}
