package lotto.domain.utils;

import java.util.List;

public class Validator {
    public static final int LOTTO_PRICE = 1000;

    public static void validateInput(List<List<Integer>> numbers, int money) throws IllegalArgumentException {
        if (isNotEnoughMoney(money)) {
            throw new IllegalArgumentException("로또는 한 개당 1000원 입니다.");
        }
        if (isNotValidMoney(money)) {
            throw new IllegalArgumentException("1000원 단위의 수만 입력해 주세요.");
        }
        if (isOverPurchaseAmount(numbers, money)) {
            throw new IllegalArgumentException("수동로또의 수가 입력하신 금액을 넘습니다.");
        }
    }

    private static boolean isOverPurchaseAmount(List<List<Integer>> numbers, int money) {
        return money / LOTTO_PRICE < numbers.size();
    }

    private static boolean isNotEnoughMoney(int money) {
        return money < LOTTO_PRICE;
    }

    private static boolean isNotValidMoney(int money) {
        return money % LOTTO_PRICE != 0;
    }

    public static void checkOneTicket(String input) throws IllegalArgumentException {
        if (Parser.splitToLottoStrings(input).length != 1) {
            throw new IllegalArgumentException("당첨 로또는 하나여야 합니다.");
        }
    }
}