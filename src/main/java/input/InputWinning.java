package input;

import lotto.Lotto;

import java.util.Scanner;

public class InputWinning {
    public static Lotto winningInput() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNum = scanner.next();
        Lotto winningNumber = new Lotto(winningNum);
        return winningNumber;
    }
}
