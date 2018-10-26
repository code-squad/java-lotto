package view;

import domain.*;
import util.Parser;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int getPay() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int price = Parser.parseInteger(new Scanner(System.in).nextLine());
            if(price < 1000) {
                throw new InputMismatchException("구입할 수 없습니다. 1000원 미만입니다.");
            }
            return price;
        } catch (InputMismatchException | NumberFormatException e) {
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

    public static int getHandOperated(int pay) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            int handOperatedNum = new Scanner(System.in).nextInt();
            if(pay / LottoGame.LOTTO_PRICE < handOperatedNum) {
                throw new IllegalArgumentException("구입한 금액보다 더 많이 구매할 수 없습니다.");
            }
            return handOperatedNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getHandOperated(pay);
        }
    }

    public static List<Lotto> getHandOperatedLotto(int handOperatedNumber) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        List<Lotto> lottos = new ArrayList<>();
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
