package view;

import domain.LottoMachine;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        while (LottoMachine.isNotEnoughMoney(amount)) {
            System.out.println("구매 금액이 부족합니다.");
            amount = getPurchaseAmount();
        }
        return amount;
    }
}
