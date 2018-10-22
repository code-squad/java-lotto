package view;

import domaim.Lotto;
import domaim.LottoFactory;
import util.PriceException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_STANDARD = ", ";

    public static int getPay() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int price = new Scanner(System.in).nextInt();
            if(price < 1000) {
                throw new PriceException("구입할 수 없습니다. 1000원 미만입니다.");
            }
            return price;
        } catch (PriceException priceException) {
            return getPay();
        } catch (InputMismatchException ime) {
            System.out.println("숫자를 입력하세요. 예) 1000원 이상");
            return getPay();
        }
    }

    public static Lotto getWinningNum() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        try {
            return LottoFactory.createLotto(new Scanner(System.in).nextLine());
        } catch (Exception lottoException) {
            System.out.println("잘못된 형식으로 입력하셨습니다.");
            return getWinningNum();
        }
    }
}
