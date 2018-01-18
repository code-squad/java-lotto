package view;

import java.util.Scanner;

public class InputView {

  private static Scanner scanner = new Scanner(System.in);

  public static String inputWinningNumbers() {
    System.out.println("지난 주 당첨번호를 입력해 주세요.");
    return scanner.next();
  }

  public static int inputPurchaseMoney() {
    System.out.println("구입 금액을 입력해 주세요.");
    return scanner.nextInt();
  }

  public static int inputBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
    return scanner.nextInt();
  }
}
