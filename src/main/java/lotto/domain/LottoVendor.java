package lotto.domain;

public class LottoVendor {
    public static int parseMoney(String money) {
        if (!isNumeric(money)) new IllegalArgumentException();
        return Integer.parseInt(money);
    }

    private static boolean isNumeric(String money) {
        return money.matches("^[0-9]*$");
    }
}
