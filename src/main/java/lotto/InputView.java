package lotto;

import java.util.Scanner;

public class InputView {
    public String getInputPrice() {
        System.out.println("구입금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public String getWinNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

}
