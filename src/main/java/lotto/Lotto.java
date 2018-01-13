package lotto;

public class Lotto {

    private static final int PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static int getCount(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("인자는 0보다 커야 합니다");
        }
        return money / PRICE;
    }

    public Result getResult(WinningNumbers winningNumber) {
        return lottoNumbers.getWinResult(winningNumber);
    }

}
