package lotto;

import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        String inputPrice =  getInputPrice();
        return;
    }

    private static String getInputPrice() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
