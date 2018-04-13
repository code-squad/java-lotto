package step0_1;

import java.util.Scanner;

/**
 * 문자열 덧셈 계산기 파라미터 입력을 위한 화면출력 class
 */
public class InputView {

  public static String getInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("덧셈할 문자열을 입력하세요.(예01. 3:4 / 예02. //;\\n4.5234;6.83564\")");
    return scanner.next();
  }
}
