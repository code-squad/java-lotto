package view;

import domain.Lotto;
import domain.LottoFactory;
import domain.LottoNum;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static int getPay() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int price = new Scanner(System.in).nextInt();
            if(price < 1000) {
                throw new InputMismatchException();
            }
            return price;
        } catch (InputMismatchException ime) {
            System.out.println("구입할 수 없습니다. 1000원 미만입니다.");
            return getPay();
        }
    }

    public static String getWinningNum() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        try {
            return new Scanner(System.in).nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getWinningNum();
        }
    }

    public static LottoNum getBonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        try {
            return new LottoNum(new Scanner(System.in).nextInt());
        } catch (InputMismatchException ime) {
            System.out.println("유효하지 않는 형식의 숫자를 입력했습니다.");
            return getBonusBall();
        } catch (IllegalArgumentException ila) {
            System.out.println(ila.getMessage());
            return getBonusBall();
        }
    }
}
