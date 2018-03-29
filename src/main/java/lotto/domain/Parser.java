package lotto.domain;

public class Parser {
    private static final int LOTTO_PRICE = 1000;

    public static int parseToInt(String text) throws IllegalArgumentException {
        int money;
        try {
            money = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            e.
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static int getNumberOfTickets(int money) throws IllegalArgumentException {
        if (money < 1000) {
            throw new IllegalArgumentException();
        }
        return money / LOTTO_PRICE;
    }
}
