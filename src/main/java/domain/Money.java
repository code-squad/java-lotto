package domain;

import java.util.Objects;

import static domain.LottoUtils.TICKET_PRICE;

public class Money {

    private int presentMoney;
    private int drawedMoney;
    private int earnedMoney;

    private Money(int money) {
        if (!isValidMoney(money)) {
            throw new IllegalArgumentException(String.format("0이상 1000원 단위로 입력해 주세요. 입력값 : %d", money));
        }
        presentMoney = money;
        drawedMoney = 0;
        earnedMoney = 0;
    }

    static boolean isValidMoney(int money) {
        return money > 0 && (money % TICKET_PRICE == 0);
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public void withDraw(int money) {
        presentMoney -= money;
        drawedMoney += money;
    }

    public void depositEarnings(int money) {
        presentMoney += money;
        earnedMoney += money;
    }

    public int calcProfit() {
        return (int)(((double)earnedMoney - (double)drawedMoney) / (double)drawedMoney * 100);
    }

    public int getPresentMoney() {
        return presentMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return presentMoney == money.presentMoney &&
                drawedMoney == money.drawedMoney &&
                earnedMoney == money.earnedMoney;
    }

    @Override
    public int hashCode() {

        return Objects.hash(presentMoney, drawedMoney, earnedMoney);
    }
}
