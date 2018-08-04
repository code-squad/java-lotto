package lotttoOlder.view;

import java.util.Scanner;
import lotttoOlder.utility.Parser;

public class InputView {

  public static String getLottoGameMoney(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("구입금액을 입력해 주세요.");

    return Parser.validateDigit(scanner.nextLine());
  }

  public static String getJackpotNum(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");

    return scanner.nextLine();
  }


}
