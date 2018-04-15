package domain;

public class ExceptionCheck {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final int NUM_LENGTH = 6;

    public static void priceCheck(int lottoPrice) {
        if (lottoPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("잔고가 부족합니다.");
        }
        if (lottoPrice % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("로또는 한장에 1000원 입니다.");
        }
    }

    public static void numLengthCheck(String[] previousWinNum) {
        if (previousWinNum.length != NUM_LENGTH) {
            throw new IllegalArgumentException("숫자 6개를 입력해 주세요.");
        }
    }
}
