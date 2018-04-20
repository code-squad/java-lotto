package com.codesquad.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> inputWinningNumbers() {
        final List<String> winningNumbers = new ArrayList<>();
        winningNumbers.add(inputBasicWinningNumbers());
        winningNumbers.add(inputBonusNumber());
        return winningNumbers;
    }

    private static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String inputBasicWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
