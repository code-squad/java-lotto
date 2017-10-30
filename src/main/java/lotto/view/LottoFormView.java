package lotto.view;

import java.util.Scanner;

import lotto.model.WinningLotto;

public class LottoFormView {
    public static int inputMoney(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        return money;
    }
    
    public static WinningLotto inputWinningLotto(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLotto = scanner.nextLine();
        return new WinningLotto(winningLotto);
    }
}
