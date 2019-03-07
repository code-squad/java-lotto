package lotto.domain;

import lotto.InvalidInputException;
import lotto.WrongAmountException;

public class ExceptionCheck {

    public static boolean money(int money) {
        if (money % 1000 != 0) {
            return false;
        }
        return true;
    }

    public static boolean bonusNum(int bonus) {
        if (bonus < 1 || bonus > 45) {
            return false;
        }
        return true;
    }

    public static boolean manualNum(int manualNum, int price) {
        if (manualNum > price) {
            return false;
        }
        return true;
    }

    public static int moneyNumException(int money) throws InvalidInputException {
        if (!money(money)) {
            throw new InvalidInputException("잘못 입력하였습니다. 1000원 단위로 입력하세요");
        }
        return money;
    }

    public static int bonusNumException(int bonus) throws WrongAmountException {
        if (bonus < 1 || bonus > 45) {
            throw new WrongAmountException("숫자가 잘못되었습니다. 범위 안에서 입력해주세요(1~45)");
        }
        return bonus;
    }

    public static int manualNumException(int manualNum, int getPrice) throws InvalidInputException {
        if (manualNum > getPrice) {
            throw new InvalidInputException("구매한 금액보다 Lotto 장수가 많습니다.");
        }
        return manualNum;
    }
}
