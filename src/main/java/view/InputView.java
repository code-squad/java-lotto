package view;

import domain.*;
import util.Parser;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static PurchaseMoney getPay() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return new PurchaseMoney(new Scanner(System.in).nextLine());
        } catch (ShortPurchaseMoneyException | NumberFormatException e) {
            System.out.println(e.getMessage());
            return getPay();
        }
    }

    public static String getWinningNum() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        try {
            return new Scanner(System.in).nextLine();
        } catch (InputLottoException e) {
            System.out.println(e.getMessage());
            return getWinningNum();
        }
    }

    public static LottoNum getBonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        try {
            return new LottoNum(new Scanner(System.in).nextInt());
        } catch (InputMismatchException | InputLottoNumberException e) {
            System.out.println(e.getMessage());
            return getBonusBall();
        }
    }

    public static int getHandOperated(PurchaseMoney purchaseMoney) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return purchaseMoney.obtainHandOperatedCount(new Scanner(System.in).nextLine());
        } catch (ShortPurchaseMoneyException | NumberFormatException e) {
            System.out.println(e.getMessage());
            return getHandOperated(purchaseMoney);
        }
    }

    public static List<Lotto> getHandOperatedLotto(int handOperatedNumber) {
        List<Lotto> lottos = new ArrayList<>();
        if(handOperatedNumber == 0) return lottos;
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        while(handOperatedNumber > 0) {
            try {
                lottos.add(LottoFactory.createHandOperatedLotto(new Scanner(System.in).nextLine()));
                handOperatedNumber--;
            } catch (InputLottoNumberException | InputLottoException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottos;
    }
}
